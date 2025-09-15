package Stringhe;


import java.util.Scanner;

public class Iniziali {
    public static void main(String[] args) {
        // chiedere all'utente di inserire Nome
        // e Cognome
        // stampiamo in console le iniziali nel seguente formato : es M.R.

        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci il tuo nome: ");
        String nome = in.nextLine().trim();
        System.out.print("Inserisci il tuo cognome: ");
        String cognome = in.nextLine().trim(); // trim per togliere gli spazi

        if (!nome.isEmpty() && !cognome.isEmpty()) {
            String iniziali = nome.toUpperCase().charAt(0) + "." + cognome.toUpperCase().charAt(0) + ".";
            System.out.println(iniziali);
        }
    }
}
