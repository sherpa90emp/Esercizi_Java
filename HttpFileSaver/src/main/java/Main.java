import Servlet.HttpMessageServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);

        context.addServlet(HttpMessageServlet.class, "/message");

        server.start();

        System.out.println("Server avviato, endpoint disponibili:");
        System.out.println(" - http://localhost:8080/message");

        server.join();
    }
}
