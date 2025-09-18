/**
 * La classe di avvio del progetto che serve a testare
 * le funzionalità del logger e del debugger con breakpoint.
 *
 * @author Vasco Rossi
 * @version 1.0
 * @since 2025.01
 */

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance(); // Ci trona l'unica istanza di logger

        logger.debug("Ciao");
        logger.info("Mondo");
        logger.warn("Hai le ruote sgonfie");
        logger.error("Hai bucato");

//        for(int i=0; i<1000; i++){
//            System.out.println("Iterazione n° " + (i+1));
//        }

        int somma = somma(2,1);
        boolean testPassato = somma == 3;

        System.out.println(testPassato);

    }

    /**
     * Esegue la somma di due numeri interi
     * @param a Numero a, da sommare
     * @param b Numero b, da sommare
     * @return La somma di a e b
     */

    public static int somma (int a, int b){
        return a - b;
    }
}
