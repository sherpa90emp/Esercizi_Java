import java.sql.Timestamp;
import java.util.Scanner;

public class EsercizioDue {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Inserisci il tuo nome: ");
        String nome = in.nextLine();
        System.out.print("Inserisci il tuo cognome: ");
        String cognome = in.nextLine();

        System.out.print("Inserisci la tua eta: ");
        byte eta = in.nextByte();

        System.out.print("Inserisci il tuo stipendio medio: ");
        int reddito = in.nextInt();

        System.out.println( " " + cognome);
        System.out.println("Eta: " + eta);
        System.out.println("Reddito Medio: " + reddito + " euro");

        byte maggioreEta = 18;
        if (eta >= maggioreEta) {
            System.out.println("Maggiorenne");
        } else {
            System.out.println("Minorenne");
        }
        System.out.println("Il suo cognome inizia per: " + cognome.charAt(0));

    }
}