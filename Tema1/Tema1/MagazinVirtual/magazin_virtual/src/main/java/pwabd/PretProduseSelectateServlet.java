package pwabd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prelProduseSelectate")
public class PretProduseSelectateServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Map<String, Integer> produse_cumparate = (HashMap<String, Integer>) context.getAttribute("produse_cumparate");
        String[] numeComponenta = (String[]) context.getAttribute("numeComponenta");
        int[] pretComponenta = (int[]) context.getAttribute("pretComponenta");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // Genereaza raspunsul HTML
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Produse vandute</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY BGCOLOR='white'>");
        out.println("<H3>Produse vandute</H3>");

        if (produse_cumparate != null) {
            out.println("<TABLE>");
            int pret, suma = 0;
            for (Map.Entry<String, Integer> set : produse_cumparate.entrySet()) {
                pret = 0;
                for (int i = 0; i < numeComponenta.length; i++) {
                    if (numeComponenta[i].compareTo(set.getKey()) == 0) {
                        pret = pretComponenta[i];
                        suma += pretComponenta[i]*set.getValue();
                    }
                }
                out.println("<TR>");
                out.println("<TD>");
                out.println(set.getKey());
                out.println("</TD>");
                out.println("<TD>");
                out.println(set.getValue());
                out.println("</TD>");
                out.println("<TD>");
                out.println(pret * set.getValue());
                out.println("</TD>");
                out.println("</TR>");

                
            }
            out.println("<TR>");
            out.println("<HR>");
            out.println("<TD>");
            out.println("Suma ");
            out.println("</TD>");
            out.println("<TD>");
            out.println("totala ");
            out.println("</TD>");
            out.println("<TD>");
            out.println(suma);
            out.println("</TD>");
            out.println("</TR>");
            out.println("</TABLE>");

            context.setAttribute("pret_total", suma);
        } else {
            out.println("<P>Numar total de produse cumparate: 0 </P>");
        }
        out.println("</BODY>");
        out.println("</HTML>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader buffer = req.getReader();
        String line;
        while ((line = buffer.readLine()) != null) sb.append(line);

        String requestBody = sb.toString();
        System.out.println(requestBody);

        ServletContext context = getServletContext();
        Map<String, Integer> produse_cumparate = new HashMap<String, Integer>();


        String[] body = requestBody.split("&");

        for (String parameter : body) {
            String[] key_val = parameter.split("="); 
            String[] temp = key_val[0].split("-");
            String key = "";

            for (int i = 1; i < temp.length; i++) {
                key += temp[i];
                if (i != temp.length - 1) key += "-";
            }

            Integer value = Integer.parseInt(key_val[1]);

            if (value != 0)
                produse_cumparate.put(key.replace("+", " "), value);
        }
        
        context.setAttribute("produse_cumparate", produse_cumparate);


        resp.sendRedirect("/magazin_virtual/prelProduseSelectate");
    }
}
