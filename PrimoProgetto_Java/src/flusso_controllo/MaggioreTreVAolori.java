package flusso_controllo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MaggioreTreVAolori {
    public static void main(String[] args) {
        // chiedere all'utente di inserire 3 numeri interi
        // stapare il maggiore tra essi
        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci qui il primo numero: ");
        int a = in.nextInt();
        System.out.print("Inserisci qui il secondo numero: ");
        int b = in.nextInt();
        System.out.print("Inserisci qui il terzo numero: ");
        int c = in.nextInt();

        if(a >= b && a >= c){
            System.out.println(a);
        } else if (b >= a && b >= c) {
            System.out.println(b);
        } else if (c >= a && c >= b) {
            System.out.println(c);
        }

        // Versione di Giuseppe
        try {


            System.out.println("Il massimo è: " + max2);
        } catch (InputMismatchException iMex) {
            System.out.println("E' necessario inserire un numero");
        }

        Scanner in2 = new Scanner(System.in);
        System.out.println("Inserire 3 numeri interi");

        System.out.println("Inserire primo numero: ");
        int max2 = in2.nextInt();

        System.out.println("Inserire secondo numero: ");
        int aux = in2.nextInt();

        if(aux > max2) {
            max2 = aux;
        }

        System.out.println("Inserire terzo numero: ");
        aux = in.nextInt();

        if(aux > max2) {
            max2 = aux;
