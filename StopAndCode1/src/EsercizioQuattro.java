import java.util.Scanner;

public class EsercizioQuattro {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci la tua data di nascita (DD/MM/AAAA): ");
        String dataDiNascita = in.nextLine();
        int annoCorrente = 2025;
        int annoDiNascita = Integer.parseInt(dataDiNascita.substring(6,10));
        System.out.println("La tua eta è di: " + (annoCorrente - annoDiNascita) + " anni");
        if ((annoCorrente - annoDiNascita) >= 18) {
            System.out.println("Sei maggiorenne");
        } else {
            System.out.println("Sei minorenne");
        }
    }
}
