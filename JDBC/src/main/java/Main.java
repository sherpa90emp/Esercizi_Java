import Repository.StudentsRepository;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
        H2Manager h2Manager = new H2Manager();
        try {
            // start server h2
            h2Manager.startServer();
            // stabiliamo una connessione con db
            Connection connection = DriverManager.getConnection( H2Manager.JDBC_URL, H2Manager.USER, H2Manager.PASS);
            // creiamo repository e chiamiamo metodi
            StudentsRepository repository = new StudentsRepository(connection);
            repository.setupTable();
            repository.insertSampleData();
            repository.queryAndPrintStudents();
            repository.queryDbMetadata();
            // aspettiamo input per chiudere app
            System.out.println("Premi invio per chiudere...");
            System.in.read();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            h2Manager.stopServer(); } }
        }
