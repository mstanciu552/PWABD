package pwabd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaProduse")
public class ListaProduseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        String[] numeComponenta = (String[]) context.getAttribute("numeComponenta");
        String[] producator = (String[]) context.getAttribute("producator");
        int[] pretComponenta = (int[]) context.getAttribute("pretComponenta");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Genereaza raspunsul HTML
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>Produse vandute</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY BGCOLOR='white'>");
        out.println("<H3>Produse vandute</H3>");
        out.println("<form method=\"post\" action=\"prelProduseSelectate\">");

        if (numeComponenta != null) {
            out.println("<TABLE>");
            for (int i = 0; i < numeComponenta.length; i++) {
                out.println("<TR>");
                out.println("<TD>");
                out.println("<input id=\"checkbox-" + numeComponenta[i] + "\" type=\"checkbox\">");
                out.println("</TD>");
                out.println("<TD>");
                out.println("<input type=\"number\" id=\"quantity-id\" name=\"quantity-" + numeComponenta[i] + "\" min=\"0\" value=\"0\">");
                out.println("</TD>");
                out.println("<TD>");
                out.println(numeComponenta[i]);
                out.println("</TD>");
                out.println("<TD>");
                out.println(producator[i]);
                out.println("</TD>");
                out.println("<TD>");
                out.println(pretComponenta[i]);
                out.println("</TD>");
                out.println("</TR>");
            }
            out.println("</TABLE>");
            out.println("<input type=\"submit\" value=\"Submit\">");
        } else {
            out.println("<P>Numar total de produse: 0 </P>");
        }
        out.println("</form>");
        out.println("</BODY>");
        out.println("</HTML>");

        out.close();
    }
}
