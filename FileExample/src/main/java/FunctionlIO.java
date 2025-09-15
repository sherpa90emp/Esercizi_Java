import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FunctionlIO {

    private static final String NOME_FILE = "file_funzionale.txt";

    public static void main(String[] args) {
        Path path = Paths.get(NOME_FILE); // creo oggetto path
        List<String> listaStringhe = Arrays.asList(
                "Questa è la prima righa",
                "Madonna quanto è bello java",
                "Basta"
        );
        scrivereSulFile(path, listaStringhe);
        leggereDaFile(path);
        processareFile(path);
    }

    private static void processareFile(Path path) {
        try (Stream<String> streamDiRighe = Files.lines(path)) { //lo stream va chiuso quindi useremo il file con risorse
            streamDiRighe
                    .filter(riga -> riga.contains("Java"))
                    .map(String::toUpperCase)  // equivale a: s -> String.toUpperCase
                    .forEach(System.out::println); // s -> System.out.println(s) sono accorciabili perchè la variabile è una e il metodo è uno
        } catch (IOException ioEx) {
            System.err.println("Errore: " + ioEx.getMessage());
        }
    }

    private static void leggereDaFile(Path path) {
        try {
            List<String> listaRighe = Files.readAllLines(path);
            listaRighe.stream() // è possibile rimuovere lo stream
                    .forEach(riga -> System.out.println(riga));
        } catch (IOException ioEx) {
            System.err.println("Errore: " + ioEx.getMessage());
        }
    }

    private static void scrivereSulFile(Path path, List<String> listaStringhe) {
        try {
            Files.write(path, listaStringhe);
        } catch (IOException ioEx) {
            System.err.println("Errore: " + ioEx.getMessage());
        }
    }
}

