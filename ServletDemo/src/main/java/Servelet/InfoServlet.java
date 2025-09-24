package Servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class InfoServlet extends HttpServlet {

    // viene invocato quando un client effettua una richiesta http get all'endpoint (url) collegato
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // legge un parametro dall'URL (query string) del tipo ?nome=pippo
        String nome = request.getParameter("nome");

        // se il parametro è vuoto metto un default
        if (nome == null || nome.isBlank())
            nome = "Default";

        //legge un header dalla richiesta per capire il tipo di client utilizzatto
        String userAgent = request.getHeader("User-Agent");

        //oteniamo l'ora del server
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataOraCorrente = now.format(formatter);

        // Costruzione risposta HTML
        response.setContentType("text/html");
        PrintWriter out =response.getWriter();

        out.println("<h1>Info Servlet</h1>");
        out.println("<p>Benvenuto nella pagina info Servlet</p>");
        out.println("<h2>Parametro nella richiesta</h2>");
        out.printf("<p>%s</p>\n", nome);
        out.println("<h2>Info del client</h2>");
        out.printf("<p>%s</p>\n", userAgent);
        out.println("<h2>Info del server</h2>");
        out.printf("<p>%s</p>\n", dataOraCorrente);
    }
}
