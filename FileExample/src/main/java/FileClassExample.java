import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileClassExample {
    public static void main(String[] args) {
        // Creiamo un oggetto file al percorso relativo incluso nel metodo
        File mioFile = new File("mio_file.txt"); //se non scrivo nulla il percorso del file è sempre relativo al main
        if (mioFile != null)
            System.out.println("L'oggetto File è diverso da null"); // creiamo l'ggetto e quindi esiste, ma se dopo cerchiamo il file.txt allora ci dirà che non esiste
        System.out.println("Il file esiste? " + mioFile.exists()); //Controllare se il file esiste

        // Creiamo il file
        try {
            boolean created = mioFile.createNewFile();
            if (created) System.out.println("Il file è stato creato con successo");
            else System.out.println("Il file esiste già");
        } catch (IOException ioEx) {
            System.out.println("ERRORE: " + ioEx.getMessage());
        }

        System.out.println("Il file esiste? " + mioFile.exists()); //Controllare se il file esiste

        // info sui file
        if (mioFile.exists()) {
            System.out.println("\nNome: " + mioFile.getName());
            System.out.println("Percorso: " + mioFile.getAbsolutePath());
            System.out.println("File? " + mioFile.isFile());
            System.out.println("Directory? " + mioFile.isDirectory());
            System.out.println("Dimensione: " + mioFile.length());
            System.out.println("Ultima modifica: " + new Date(mioFile.lastModified()));
        }

        // Creare una Directory
        File miaDirectory = new File("miaDirectory");
        boolean created = miaDirectory.mkdir(); //make directory, torna un boleano
        if (created) System.out.println("Directory " + miaDirectory.getName() + " create con successo!");
        else System.out.println("Directory " + miaDirectory.getName() + " già presente!");
        System.out.println("Directory? " + miaDirectory.isDirectory());
    }
}
