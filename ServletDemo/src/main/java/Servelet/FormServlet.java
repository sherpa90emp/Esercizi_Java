package Servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // imposto content type della risposta ad HTML
        PrintWriter out = response.getWriter(); // estratto oggetto per scrittura su response HTTP
        // scrivo risposta HTML su HTTP
        out.println("<form action='form' method='POST'>");
        out.println("<label for='nome'>Il tuo nome:</label>");
        out.println("<input type='text' name='nome'><br><br>");
        out.println("<label for='messaggio'>Inviaci un messaggio:</label>");
        out.println("<textarea name='messaggio' rows='5'></textarea><br><br>");
        out.println("<button type='submit'>Invia messaggio</button>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // recupero i dati inseriti nella richiesta POST usando i loro nomi (name)
        String nome = request.getParameter("nome");
        String messaggio = request.getParameter("messaggio");

        //controllo se i dati esistono
        if (nome == null || nome.isBlank())
            nome = "Antonio";
        if (messaggio == null || nome.isBlank())
            messaggio = "messaggio vuoto";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>Grazie!</h1>");
        out.println("<h2>Autore:</h2>");
        out.printf("<p>%s</p>", nome);
        out.println("<h2>Messaggio:</h2>");
        out.printf("<p>%s</p>", messaggio);
        out.println("<a href='form'>Invia un altro messaggio</a>");
    }
}
