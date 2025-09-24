package Servelet;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//imposta un cookie nel browser
public class SetCookieServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("name"); // recupero un parametro ?name=pippo
        if (userName == null || userName.isBlank())
            userName = "default";

        // creao un cookie come coppia chiave valore
        Cookie cookie = new Cookie("user_name", userName);

        //impostare scadenza cookie
        cookie.setMaxAge(60*60*24); //1 giorno

        //aggiungo il cookie alla risposta, il browser lo salverà una volta ricevuto
        resp.addCookie(cookie);

        //ritorno contenuto
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Cookie impostato</h1>");
    }
}
