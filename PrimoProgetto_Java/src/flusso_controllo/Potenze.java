package flusso_controllo;

import java.util.Scanner;

public class Potenze {
    public static void main(String[] args) {
        // Chiedere in igresso un numero intero e stampare le prime dieci poetenze che hanno per base il numero dato

        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci un numero intero: ");
        int base = in.nextInt();

        for (int i = 0; i < 10; i++) {
             System.out.println(base + "^" + i + "=" + Math.pow(base, i));
        }
    }
}
