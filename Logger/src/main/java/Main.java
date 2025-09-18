import java.util.List;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance(); // Ci trona l'unica istanza di logger
        FileParser fileParser = FileParser.getInstance();

        List<String> righeLette = fileParser.readAllLines();

        fileParser.readLevels(righeLette);

        logger.debug("Ciao");
        logger.info("Mondo");
        logger.warn("Hai le ruote sgonfie");
        logger.error("Hai bucato");
    }
}
