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


        resp.sendRedirect("/magazin_virtual/generareChitanta");
    }
}
