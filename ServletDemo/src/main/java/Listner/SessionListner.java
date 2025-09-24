package Listner;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

//Viene notificato dell'evento di creazione della sessione di HTTP
public class SessionListner implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("||||||||||||||||||||||||||");
        System.out.println("|||||SESSIONE CREATA||||||");
        System.out.println("||||| " + se.getSession().getId());
        System.out.println("||||||||||||||||||||||||||");
    }
}
