package Servelet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//associa una request http (quindi metodo e url) a una classe
public class HelloServlet extends HttpServlet {


    /**
     * viene chiamato dal container (il server jetty) ogni volta che riceve una richiesta
     * su URL mappato a questa servlet
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession(); // richiede esplicitamente la sessione

        //imposto il content type alla response perchè tornerò una pagina html
        response.setContentType("text/html; charset=utf-8");

        //faccio riferimento al writer della response
        PrintWriter out = response.getWriter();

        //scrivo sul writer i dati che voglio mandare in risposta
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Esempio di Servlet</title>");
        out.println("<body>");
        out.println("<h1>Ciao salla Servlet</h1>");
        out.println("<p>Questa pagina è stata creata senza olio di palma</p>");
        out.println("<p>Il tutto a runtime</p>");
        out.println("</body>");
        out.println("</head>");
        out.println("</html>");
    }
}
