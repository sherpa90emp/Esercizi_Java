import java.util.Scanner;

public class EsercizioUno {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci il tuo nome: ");
        String nome = in.nextLine();
        System.out.print("Inserisci il tuo cognome: ");
        String cognome = in.nextLine();
        System.out.println(nome + " " + cognome);
    }
}
