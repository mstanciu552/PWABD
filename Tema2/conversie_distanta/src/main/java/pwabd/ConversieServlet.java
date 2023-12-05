package pwabd;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pwabd.conversie.InfoConversie;
import pwabd.util.Eroare;
import pwabd.util.Unitati;

@WebServlet("/conversie")
public class ConversieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader buffer = req.getReader();
        String line;

        while ((line = buffer.readLine()) != null)
            sb.append(line);

        String requestBody = sb.toString();
        System.out.println(requestBody);

        String[] body = requestBody.split("&");
        double valoare = Double.parseDouble(body[0].split("=")[1]);
        String din = body[1].split("=")[1];
        String catre = body[2].split("=")[1];

        Unitati unitateDin = null;
        Unitati unitateCatre = null;

        if (din == "metri")
            unitateDin = Unitati.METRI;
        else if (din == "inch")
            unitateDin = Unitati.INCH;
        else
            unitateDin = Unitati.FEET;

        if (catre == "metri")
            unitateCatre = Unitati.METRI;
        else if (catre == "inch")
            unitateCatre = Unitati.INCH;
        else
            unitateCatre = Unitati.FEET;

        InfoConversie conversie = new InfoConversie();
        conversie.setValoareDeconvertit(valoare);
        conversie.setUnitateDin(unitateDin);
        conversie.setUnitateCatre(unitateCatre);

        Optional<Eroare> rezultat_conversie = conversie.converteste();

        // Daca Optional e empty => fara eroare
        if (!rezultat_conversie.isPresent())
            resp.sendRedirect("/conversie_distanta/infoConv.jsp");
    }
}
