package pwabd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/generareChitanta")
public class GenerareChitantaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        Map<String, Integer> produse_cumparate = (HashMap<String, Integer>) context.getAttribute("produse_cumparate");
        String[] numeComponenta = (String[]) context.getAttribute("numeComponenta");
        int[] pretComponenta = (int[]) context.getAttribute("pretComponenta");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Client client = (Client) session.getAttribute("client");

        // Genereaza raspunsul HTML
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Produse vandute</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY BGCOLOR='white'>");
        out.println("<H3>Produse vandute</H3>");
        out.println("<TABLE>");

        out.println("<TR>");
        out.println("<TD>");
        out.println("Nume: ");
        out.println("</TD>");
        out.println("<TD>");
        out.println(client.getNume());
        out.println("</TD>");
        out.println("</TR>");

        out.println("<TR>");
        out.println("<TD>");
        out.println("Prenume: ");
        out.println("</TD>");
        out.println("<TD>");
        out.println(client.getPrenume());
        out.println("</TD>");
        out.println("</TR>");

        out.println("<TR>");
        out.println("<TD>");
        out.println("Oras: ");
        out.println("</TD>");
        out.println("<TD>");
        out.println(client.getOras());
        out.println("</TD>");
        out.println("</TR>");

        out.println("<TR>");
        out.println("<TD>");
        out.println("Adresa: ");
        out.println("</TD>");
        out.println("<TD>");
        out.println(client.getAdresa());
        out.println("</TD>");
        out.println("</TR>");

        out.println("</TABLE>");

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
        HttpSession session = req.getSession();

        while ((line = buffer.readLine()) != null) sb.append(line);

        String requestBody = sb.toString();
        System.out.println(requestBody);

        String[] body = requestBody.split("&");   
        System.out.println(body[0]);

        String nume = body[0].split("=")[1];
        String prenume = body[1].split("=")[1];
        String oras = body[2].split("=")[1];
        String adresa = body[3].split("=")[1];
        String metoda_plata = body[4].split("=")[1];

        Client client = new Client(nume, prenume, oras, adresa, metoda_plata);
        if (session.getAttribute("client") == null)
            session.setAttribute("client", client);
        
        resp.sendRedirect("/magazin_virtual/listaProduse");
    }
}
