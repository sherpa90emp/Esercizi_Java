package Stringhe;

import java.util.Scanner;

public class StampaVocali {
    public static void main(String[] args) {
        // data una stringa in igresso: stampare solamente le vocali

        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci una stringa: ");
        String input = in.nextLine().toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                System.out.print(c);
            }
        }

        System.out.println("\n");
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                System.out.print(c);
            }
        }
    }
}
