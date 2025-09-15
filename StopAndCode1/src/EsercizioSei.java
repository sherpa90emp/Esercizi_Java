import java.util.Scanner;

public class EsercizioSei {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci la tua data di nascita (DD/MM/AAAA): ");
        String dataDiNascita = in.nextLine();
        int annoCorrente = 2025;
        int annoDiNascita = Integer.parseInt(dataDiNascita.substring(6,10));
        System.out.println("Il numero dei tuoi anni " + (annoCorrente - annoDiNascita) + " + 1 e' un numero pari?" );
        if ((annoCorrente - annoDiNascita + 1) % 2 == 0 ) {
            System.out.println("Si, e' un numero pari");
        } else {
            System.out.println("No, non e' un numero pari");
        }
    }
}
