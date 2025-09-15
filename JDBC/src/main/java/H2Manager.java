import org.h2.tools.Server;

import java.sql.SQLException;

public class H2Manager {

    // private static final String JDBC_URL = "jdbc:h2:mem:testdb";
    public static final String JDBC_URL = "jdbc:h2:tcp://localhost/./db-data/sample"; // tcp
    public static final String USER = "sa";
    public static final String PASS = "";
    private Server webServer; // abilitare console frontend
    private Server tcpServer; // connessione al db tramite tcp

    /**
     * Avvia il server web per la console ammisistrazione di H2  e il server TCP per la connesione JDBC.  @throws SQLException Se si verifica un errore durante l'avvio del server.
     */
    public void startServer() throws SQLException {
        webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
        System.out.println("Console H2 avviata: " + webServer.getURL());
        tcpServer = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-ifNotExists").start();
        System.out.println("JDBC URL per la console: " + tcpServer.getURL());
    }

    public void  stopServer() {
        if (tcpServer != null) {
            tcpServer.stop();
            System.out.println("Server TCP fermato");
        }
        if (webServer != null) {
            webServer.stop();
            System.out.println("Web server fermato");
        }
    }
}

