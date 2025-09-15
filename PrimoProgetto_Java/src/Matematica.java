public class Matematica {
    public static void main(String[] args) {
        // la classe Math ci espone dei metodi per effettuare operazioni matematiche

        //potenze, con metodo pow
        double base = 2.0;
        double esponente = 3.0;
        double potenza = Math.pow(base, esponente); // il primo parametro è la base, il secondo l'esponente
        System.out.println(potenza);

        //radice, con metodo sqrt (square root)
        double radice = Math.sqrt(16);
        System.out.println(radice);

        //max e min
        int a = 10;
        int b = 1;
        System.out.println(Math.max(a, b));
        System.out.println(Math.min(a, b));

        //ritorna l'itero superiore (.floor ritorna l'intero inferiore)
        double tetto = Math.ceil(16.2);
        System.out.println(tetto);

        // costante tutta maiuscola (final) viola
        System.out.println(Math.PI);

        // genera un numero random compreso tra 0.0 1.0 (escluso 1.0)
        double random = Math.random();
        System.out.println(random);

        //torna un numero tra 0 e 99
        int randomInt = (int)(Math.random() * 100);
        System.out.println(randomInt);

        int d6 = (int) (Math.random() * 6) + 1; // +1 per non farlo tornare 0
        System.out.println(d6);
  }
}
