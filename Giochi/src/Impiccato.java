import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Impiccato {

    //TODO implementare "parole.txt"

    public static void main(String[] args) {
        String[] parole = {"Bulbasaur", "Ivysaur", "Venusaur",
                "Charmander", "Charmeleon", "Charizard",
                "Squirtle", "Wartortle", "Blastoise",
                "Caterpie", "Metapod", "Butterfree",
                "Weedle", "Kakuna", "Beedrill",
                "Pidgey", "Pidgeotto", "Pidgeot",
                "Rattata", "Raticate", "Spearow", "Fearow",
                "Ekans", "Arbok", "Pikachu", "Raichu"};

        Random random = new Random();
        int index = random.nextInt(parole.length);
        String parolaRandom = parole[index].toLowerCase();
        System.out.println(parolaRandom);

        char[] parola = parolaRandom.toCharArray(); //dalla parola selezionata random, abbiamo messo le lettere dentro un array indicizzandole secondo l'ordine della parola stessa
        char[] progress = new char[parola.length]; // creiamo un secondo array lungo quanto la parola selezionata random
        Arrays.fill(progress, '_'); // popoliamo l'array di _ che poi saranno sostituiti dall'utente

        Scanner scanner = new Scanner(System.in);
        boolean indovinato = false; //variabile di partenza false perche ovviamente il gioco inizia e non ha indovinato

        System.out.println("Benvenuto al gioco dell'impiccato!");
        System.out.println("Scegli il livello di difficoltà:");
        System.out.println("1. Facile");
        System.out.println("2. Medio");
        System.out.println("3. Difficile");
        System.out.print("Con quale difficolatà vuoi giocare? ");
        int difficolta = scanner.nextInt();
        int numeroTentativi;

        switch (difficolta){
            case 1:
                numeroTentativi = parolaRandom.length() + 5;
                break;
            case 2:
                numeroTentativi = parolaRandom.length() + 3;
                break;
            case 3:
                numeroTentativi = parolaRandom.length();
                break;
            default:
                System.out.println("Livello non valido, impostato a medio di default!");
                numeroTentativi = parolaRandom.length() + 3;
        }

        String letterInserite = "";

        while (numeroTentativi > 0 && !indovinato) {
            System.out.print("Inserisci una lettera: ");
            char lettera = scanner.next().toLowerCase().charAt(0);

            if (letterInserite.contains(lettera + "")) {
                System.out.println("Hai già inserito la lettera: " + lettera + ", riprova");
                continue;
            }

            letterInserite += lettera;

            boolean trovato = false;
            for (int i = 0; i < parola.length; i++) {
                if (parola[i] == lettera) {
                    progress[i] = lettera;
                    trovato = true;
                }
            }

            if (trovato)
                System.out.println("Lettera presente: " + String.valueOf(progress));
            else
                System.out.println("Lettera sbagliata. Tentativi rimasti: " + --numeroTentativi);
            if (parolaRandom.equals(String.valueOf(progress))) {
                indovinato = true;
            }

        }

        if (indovinato)
            System.out.println("Complimeti, hai indovinato la parola: " + parolaRandom);
        else
            System.out.println("Hai perso, la parola era: " + parolaRandom);
    }
}
