package flusso_controllo;

import java.util.Scanner;

public class Uguali {
    public static void main(String[] args) {
        //Chiedere all'utente di inserire due numeri interi
        //stampare "sono uguali" se sono = ; stampare "non sono uguali" se non sono =

        // con l'oggetto scanner 'in' recuperoiamo input utente da console
        Scanner in = new Scanner(System.in); //System.in legge dalla console (mentre .out scrive)
        System.out.print("Inserisci primo numero intero: ");
        int a = in.nextInt(); //bloccano il flusso del codice, finche non viene inserito un int non procede
        System.out.print("\nInserisci secondo numero intero: "); // \n vuol dire vai a capo
        int b = in.nextInt();

        if (a == b) {
            System.out.println("sono uguali");
        } else {
            System.out.println("non sono uguali");
        }
        System.out.println(
                (a == b ? "" : "non") + " sono uguali"
        );
    }
}
