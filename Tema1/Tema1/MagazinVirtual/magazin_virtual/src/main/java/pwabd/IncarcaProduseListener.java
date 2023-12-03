package pwabd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.*;

public class IncarcaProduseListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        String numeFisier = "/produse/produse.txt"; // de schimbat cu parametru din web.xml
        int index = 6; // de schimbat cu parametru din web.xml

        String[] numeComponenta = new String[index];
        String[] producator = new String[index];
        int[] pretComponenta = new int[index];

        BufferedReader buffer = null;

        try {
            InputStream is = context.getResourceAsStream(numeFisier);
            buffer = new BufferedReader(new InputStreamReader(is));

            String linie = null;
            int i = 0;
            while ((linie = buffer.readLine()) != null) {
                String[] linie_separata = linie.split("/");
                numeComponenta[i] = linie_separata[0];
                producator[i] = linie_separata[1];
                pretComponenta[i++] = Integer.parseInt(linie_separata[2]);
            }

            context.setAttribute("numeComponenta", numeComponenta);
            context.setAttribute("producator", producator);
            context.setAttribute("pretComponenta", pretComponenta);

        } catch (IOException ex) {
            System.out.println("Exceptie: " + ex.getMessage());
            numeComponenta = null;
            producator = null;
            pretComponenta = null;
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException ioe) {
                }
            }
        }

    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        context.setAttribute("numeComponenta", null);
        context.setAttribute("producator", null);
        context.setAttribute("pretComponenta", null);

    }
}
