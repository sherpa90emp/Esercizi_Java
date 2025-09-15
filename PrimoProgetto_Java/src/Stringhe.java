import java.util.Arrays;

public class Stringhe {
    public static void main(String[] args) {
        String nome = "Mario"; // string è una classe e va scritta con la S maiuscola
        System.out.println(
                nome.charAt(0) //stampa il carattere in posizione 0 nella stringa nome, ovvero la M di Mario
        );
        System.out.println(
                nome.length() //ci la lunghezza; non è possibile concatenare due matodi che ritornano due volori diversi, in questo caso char e int
        );
        System.out.println(
                nome.toUpperCase() //restituisce la stringa tutta in maiuscolo
        );
        String altroNome = "Mario";
        System.out.println(nome == altroNome); //funziona da java 11 in poi, preferibile solo su
        System.out.println(nome.equals(altroNome)); // equals si usa per controllare se due oggetti sono uguali (retrocompatibile)

        System.out.println(
                nome.startsWith("M") //controlla se la stringa inizia con "M"
        );

        String pippo = "  pippo  ";
        System.out.println(pippo.trim()); //elimina gli spazi

        String cognome = "Rossi";
        System.out.println(
                nome + " " + cognome // la stringa vuota è un carattere; concatenazione di due stringhe; il backslash \ fa da escape per i caratteri di controllo es: \" (per inserire i doppi apici)
        );

        // java 11+
        System.out.println(
                cognome.isEmpty() // se la stringa è vuota
        );
        System.out.println(
                nome.isBlank() // se la stringa contiene solo spazi
        );

        System.out.println(
                nome.substring(1,2) // crea una sottostringa, partendo dalla posizione 1 e arriva alla 2 (esclusa)
        );

        //csv = comma separated value; è un file
        String csv = "nome;cognome;eta";
        //usiamo string split per recuperare i dati del csv
        String[] dati = csv.split(";");
        System.out.println(
                dati[0] //1,2 per vedere i dati nelle altre posizioni dell'array
        );
        System.out.println(Arrays.toString(dati)); //per vedere l'array nella sua interezza
    }
}
