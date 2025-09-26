package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//una servlet che accetta messaggi da http e li salva
public class HttpMessageServlet extends HttpServlet {

    private static final String FILE_NAME = "messaggi_salvati.txt";
    private Path filePath;

    //viene chiamato quando è creata una istanza della servlet
    @Override
    public void init() throws ServletException {
        filePath = Paths.get(FILE_NAME); //ottiene il percorso del file
        System.out.println("HttpMessageServlet: File di salvataggio: " + filePath.toAbsolutePath());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.printf("<h1>Inviaci un messaggio!</h1>");
        out.println("<form action='message' method='POST'>");
        out.println("Inserisci il messaggio da inviare:<br>");
        out.println("<textarea name='messaggio' rows='5'></textarea><br><br>");
        out.println("<button type='submit'>Invia messaggio</button>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // recuperiamo il messaggio nella request
        String message = req.getParameter("messaggio");
        //controllo esistenza messaggio
        if (message == null || message.isBlank()) {
            resp.sendRedirect("save?error=empty_message");
            return;
        }
        // prepariamo la stringa da salvare, aggiungendo un timestamp
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String toSave = "[" + timestamp + "]" + message + "\n";

        // salviamo la stringa
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile(), true))) {
            writer.write(toSave);
        } catch (IOException ioEx) {
            System.err.println(ioEx.getMessage());
            resp.sendRedirect("save?error=save_failed");
        }
        resp.sendRedirect("save?success=true");
    }
}
