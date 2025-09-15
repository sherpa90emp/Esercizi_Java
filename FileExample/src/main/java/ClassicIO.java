import java.io.*;

public class ClassicIO {

    private static final String FILE_NAME = "nuovo_file.txt";

    public static void main(String[] args) {

        scrivereSuFile(FILE_NAME);
        leggereDaFile(FILE_NAME);
    }

    private static void leggereDaFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Il file " + path + " non esiste!");
            return;
        }
        try (
                FileReader reader = new FileReader(path);
                BufferedReader buffered = new BufferedReader(reader)
        ) {
            // String rigaIniziale = "";
            String rigaIniziale; // serve la dichiarazione
            while ((rigaIniziale = buffered.readLine()) != null) {
                System.out.println(rigaIniziale);
                //rigaIniziale = buffered.readLine(); si condensa tutto nella condizione del while, aggiorna la variabile e la controlla
            }
        } catch (IOException ioEx) {
            System.err.println("Errore: " + ioEx.getMessage());
        }
    }

    public static void scrivereSuFile(String path) {
        // try with resources = risorse chiude in automatico
        try (
                FileWriter writer = new FileWriter(path);
                BufferedWriter buffered = new BufferedWriter(writer)
        ) {
            buffered.write("Questa è la prima riga");
            buffered.newLine();
            buffered.write("Seconda riga");
            buffered.newLine();
            buffered.write("Fine");
        } catch (IOException ioEx) {
            System.err.println("Errore: " + ioEx.getMessage());
        }
    }
}
