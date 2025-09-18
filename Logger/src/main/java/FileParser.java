import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class FileParser {

    File controler = new File("controler.txt");
    Logger logger = Logger.getInstance();


    private FileParser() {
    }

    private static final FileParser sole_instance = new FileParser();


    public static FileParser getInstance() {
        return sole_instance;
    }

    public List<String> readAllLines() {
        if (!controler.exists()) {
            // FIXME fare un'eccezione custom file non esiste
            return null;
        }
        List<String> retValue = new LinkedList<>();
        try (
                FileReader reader = new FileReader(controler.getName());
                BufferedReader buffered = new BufferedReader(reader);
        ) {
            String row;
            while ((row = buffered.readLine()) != null) {
                logger.info(row);
                retValue.add(row);
            }
        } catch (IOException ioEx) {
            System.out.println("ERRORE: " + ioEx.getMessage());
        } finally {
            return retValue;
        }
    }

    public List<LogLevel> readLevels(List<String> daFile){
        List<LogLevel> logLevelList = new LinkedList<>();
        for(String s : daFile){
            if(s.startsWith("/")) continue;
            String [] split =  s.split(";");
            if(split.length != 3) continue;
            split[1]= split[1].trim();
            if(split[1].startsWith("\"")) split[1] = split[1].substring(1);
            if(split[1].endsWith("\"")) split[1] = split[1].substring(0, split[1].length()-1);
            boolean activation = (split[2].equals("true")) ? true : false;
            LogLevel newLevel = new LogLevel(split[0], split[1], activation);
            if(logLevelList.contains(newLevel)) continue;
            logLevelList.add(newLevel);
            logger.debug(newLevel.toString());
        }
        return logLevelList;
    }

}
