package pwabd;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/generareChitanta")
public class GenerareChitantaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader buffer = req.getReader();
        String line;
        ServletContext context = getServletContext(); // TODO Sesiune
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
        
    }
}
