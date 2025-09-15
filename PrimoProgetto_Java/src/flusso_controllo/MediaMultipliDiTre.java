package flusso_controllo;

import java.util.Scanner;

public class MediaMultipliDiTre {
    public static void main(String[] args) {
        // chiedere all'utente quanti numeri vuole inserire
        // far inserire una sequenza di interi
        // stampare la media di tutti i numeri divisibili per 3

        Scanner in = new Scanner(System.in);
        System.out.print("Quanti numeri vuoi inserire? ");
        int tot = in.nextInt();

        double somma = 0;
        int contatore = 0;

        for (int i = 0; i < tot; i++) {
            System.out.print("Inserisci numero: ");
            int numero = in.nextInt();
            if (numero % 3 == 0) {
                somma += numero;
                contatore++;
            }
        }
        if (contatore > 0) {
            double media =  somma / contatore;
            System.out.println("La media dei numeri divisibili per 3 è: " + media);
        } else {
            System.out.println("Nessun numero divisibile per 3 è stato inserito.");
        }
    }
}
