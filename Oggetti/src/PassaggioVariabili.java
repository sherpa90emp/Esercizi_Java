public class PassaggioVariabili {
    public static void main(String[] args) {
        //diff fra passaggio per valore e passaggio per riferimento

        //passaggio per valore = viene effettuata una copia della variabile
        int num = 10;
        aumenta(num);
        System.out.println("Ma stampa sempre: " + num); // per questo motivo viene ristampato 10; il più uno del metodo aumenta viene fatto sulla copia di num

        //passaggio per riferimento - passiamo il riferimento ad un oggetto
        Contatore counter = new Contatore(); //oggetto dichiarato sotto nella inner class (normalmente non si fa)
        counter.valore = 10;
        aumenta(counter);
        System.out.println(counter.valore); // passando il valore all'oggetto si modifica attraverso il metodo = passaggio per riferimento (side effect)
    }

    public  static void aumenta(int num) {
        System.out.println("Passato: " + num);
        num = num+1;
        System.out.println("Adesso vale: " + num);
    }

    public static void aumenta(Contatore counter) {
        counter.valore += 1;
    }
}

//inner class
class Contatore {
    int valore;
}
