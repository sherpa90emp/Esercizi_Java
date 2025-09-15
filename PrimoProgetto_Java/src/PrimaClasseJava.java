// doppio slash = commento
// il nome della classe pubblica deve essere come il nome del file = la classe PrimaClasseJava deve essere dentro al file PrimeClasseJava.java

public class PrimaClasseJava {
    public static void main(String[] args) {
        //metodo main
        System.out.println("Hello World!");

        System.out.print("Hello "); //lo spazio viene riconosciuto
        System.out.print(" "); //uno spazio vuoto è comunque una stringa si formano quindi due spazi
        System.out.print("World!");
        int numeroIntero = 123;
        System.out.println(numeroIntero);

        // dichiarazione variabile
        short numeroPiccolo;
        // System.out.println(numeroPiccolo); darebbe problemi
        // inizializzazione variabile
        numeroPiccolo = 12;

        byte unByte = 127;
        System.out.println(unByte);

        // operatore di pre-incremento che provoca overflow nel byte
        System.out.println(++unByte);

        char c = 'a';
        System.out.println(c);

        // post- incrermento sulla variabile c
        c++;
        System.out.println(c); //stampa la b perchè è a + 1 = b

        boolean staPiovendo = false;
        System.out.println(staPiovendo);

        double prezzo = 9.99;
        System.out.println(prezzo + 2 / 2); // segue le regole della matematica

        int a = 10;
        int b = 3;
        int divisione = a / b;
        System.out.println(divisione); //darà come risultato 3, utilizzando int ci perdiamo parte del valore poichè dovrebbe essere 3,3 periodico
        double divisioneConVirgola = a / (double)b; //è stato fatto un cast = trasformazione di un tipo in un altro (abbiamo trasformato un intero in double per farlo risultare periodico)
        System.out.println(divisioneConVirgola);

        int resto = 3%2; // % = resto della divisione
        System.out.println(resto);

        boolean isNuvoloso = true;
        // or è vero se almeno uno è vero
        System.out.println(staPiovendo || isNuvoloso); // || = or

        // and(e di congiunzione) è vero se entrambi sono veri
        System.out.println(staPiovendo && isNuvoloso); // && = and

        // stampo se a è maggiore di b
        System.out.println(a > b);

        int somma = 0;
        somma = somma + 1;
        somma += 2; //è la stessa cose che scrivere la sintassi sopra
        System.out.println(somma);
        }
}
