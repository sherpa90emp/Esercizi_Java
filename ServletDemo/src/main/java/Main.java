import Filter.LogFilter;
import Listner.SessionListner;
import Servelet.FormServlet;
import Servelet.HelloServlet;
import Servelet.InfoServlet;
import Servelet.SetCookieServlet;
import jakarta.servlet.DispatcherType;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.util.EnumSet;

public class Main {

    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        //avvia il server Jetty alla porta 8080 dichiarata sopra
        Server server = new Server(PORT);

        // agganciamoci al contesto delle servlet di jetty
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        // associamo l'handler al server
        server.setHandler(context);

        // aggiungiamo la nostra servlet al context
        context.addServlet(HelloServlet.class, "/hello");
        context.addServlet(InfoServlet.class, "/info");
        context.addServlet(FormServlet.class, "/form");
        context.addServlet(SetCookieServlet.class, "/set-Cookie");

        // Aggiunta del filter
        context.addFilter(LogFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));

        //Aggiunjta listener al contesto
        context.addEventListener(new SessionListner()); //necessario aggiungere un delay per vederla

        //faccio partire il server
        server.start();
        System.out.println("Server avviato. Endpoint disponibili:");
        System.out.println(" - http://localhost:8080/hello");
        System.out.println(" - http://localhost:8080/info");
        System.out.println(" - http://localhost:8080/form");
        System.out.println(" - http://localhost:8080/set-Cookie");
        // impedisce al software di chiudersi da solo e lascia il server attivo
        server.join();
    }
}
