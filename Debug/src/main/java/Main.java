public class Main {
    public static final int COSTANTE_PRIMITIVA = 123; // Va nell'HEAP

    public static final String COSTANTE_OGGETTO = "asdfgslakhjlfaj"; // Va nell'HEAP

    public static void main(String[] args) {
        Calcolatrice calc = new Calcolatrice();

        int x = 10; // Dati Primitivi stanno nello Stack
        int y = 0;

        int somma = calc.somma(x, y);
        int differenza = calc.sottrazione(x,y);
        int prodotto = calc.moltiplicazione(x,y);
        double quoziente = calc.divisione(x,y);

        System.out.println("Somma: " + somma);
        System.out.println("Differenza: " + differenza);
        System.out.println("Prodotto: " + prodotto);
        System.out.println("Quoziente: " + quoziente);  // Infinity

        for(int i=1; i<=100; i++){
            if(i% 10 == 0)
                Debug.println("Sono arrivato a i= "+ i);
        }

    }
}
