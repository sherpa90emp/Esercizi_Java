package Repository;

import java.sql.*;

/**
 * Classe repository (Pattern DAO - Data Access Object)
 * Questa classe i sola la logica di accesso ai dati dal resto dell'app.
 * Ogni metodo effettua una operazione specifica sul dp.
 */
public class StudentsRepository {
    private final Connection connection;

    /**
     * Costruttore che riceve la connessione al db.
     * @param connection la connessione attiva da utilizzare per le operazioni.
     */
    public StudentsRepository(Connection connection) {
        this.connection = connection;
    }

    /**
     * Crea la tabella studenti eliminandola prima se esiste già.
     * @throws SQLException Se si verifica un errore SQL
     */
    public void setupTable() throws SQLException {
        System.out.println("> setupTable");
        try (Statement statement = connection.createStatement()) {
            //drop table if exists studenti
            String dropQuery = "DROP TABLE IF EXISTS studenti";
            statement.execute(dropQuery);

            // Create table studenti (id primary key; nome varchar 255, cognome varchar 255)
            String createQuery = "CREATE TABLE studenti (id INT PRIMARY KEY, nome VARCHAR(255), cognome VARCHAR(255))";
            statement.executeUpdate(createQuery);
            System.out.println("Tabella creata");
        }
    }

    /**
     * Inserisce dati di esempio in tabella.
     * @throws SQLException Se si verifica un errore SQL.
     */
    public void insertSampleData() throws SQLException {
        System.out.println("> insertSampleData");
        try (Statement statement = connection.createStatement()) {
            String insertQuery1 = "INSERT INTO studenti VALUES (1, 'Mario', 'Rossi')";
            statement.executeUpdate(insertQuery1);

            String insertQuery2 = "INSERT INTO studenti VALUES (2, 'Carlo', 'Rosso')";
            statement.executeUpdate(insertQuery2);
        }
    }

    /**
     * Esegue una query per selezionare tutti gli studenti e li stampoa in cosnole.
     * @throws SQLException Se si verifica un errore SQL
     */
    public void queryAndPrintStudents() throws SQLException {
        System.out.println("> queryAndPrintStudents");
        try (Statement statement = connection.createStatement()){
            String querySelect = "SELECT * FROM studenti";
            statement.executeQuery(querySelect);
            ResultSet resultSet = statement.executeQuery(querySelect);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cognome = resultSet.getString("cognome");
                System.out.printf("ID: %d, Nome: %s, Cognome: %s\n", id, nome, cognome);
            }
        }
    }

    /**
     * Esegue una interrogazione al db stampando i dati ricevuti
     * @throws SQLException Se si verifica un erroe SQL.
     */
    public void queryDbMetadata() throws SQLException {
        System.out.println("<-- Metadati database -->");
        DatabaseMetaData metaData = connection.getMetaData();

        System.out.println("Db Product Name: " + metaData.getDatabaseProductName());
        System.out.println("DB version: " + metaData.getDatabaseProductVersion());
        System.out.println("Username: " + metaData.getUserName());
    }
}
