import java.util.Scanner;

public class IndovinaIlNumero {
    public static void main(String[] args) {
        // Il bot sceglie un numero casuale ompreso tra 0 e 100; il giocatore deve indovinarlo

        System.out.println("Benvenuto al gioco 'Indovina il numero'");
        int numeroRandom = (int) (Math.random() * 100) + 1;
        System.out.println("Ho scelto un numero fra 1 e 100, riesci ad indovinarlo?");
        int numeroTentativi = 0;
        Scanner input = new Scanner(System.in);


        int numGiocatore;
        do {
            System.out.print("Fai un tentativo: ");
            numGiocatore = input.nextInt();

            if (numGiocatore <= 0 || numGiocatore > 100) {
                System.out.println("Il numero che hai inserito non è nel range 1 - 100");
                continue; //blocca il ciclo nel caso di numero sbagliato e rinizia il ciclo da capo; il contatore non aumenta
            }

            numeroTentativi++;

            if (numeroRandom == numGiocatore) {
                String tentativi = numeroTentativi == 1 ? "Incredibile, hai indovinato in un tentativo!" : "Bravo hai indovinato in " + numeroTentativi + " tentativi!";
                System.out.println(tentativi);
            }
            else if (numGiocatore > numeroRandom)
                System.out.println("Troppo grande..."); //si possono omettere le parentesi graffe solo se la condizione è unica; con due è necessario mettere le graffe
            else
                System.out.println("Troppo piccolo...");
        } while (nonHaIndovinato(numeroRandom, numGiocatore));

    }

    private static boolean nonHaIndovinato(int numeroRandom, int numeroGiocatore) {
        return numeroRandom != numeroGiocatore;
    }
}
