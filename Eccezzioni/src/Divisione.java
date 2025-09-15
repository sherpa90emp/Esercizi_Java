public class Divisione {
    public static void main(String[] args) {
        // verrà lanciata una eccezione unchecked, poichè estende runtime: java.lang.ArithmeticException: / by zero
        // la possiamo gestire con il costrurtto
        try {
            //nel blocco try proviamo a eseguire delle righe di codice
            int i = 10 / 0;
        } catch (ArithmeticException pippo) { //oggetto pippo di tipo aritmeticexception
            System.out.println(pippo.getMessage()); // in questo modo non interrompe il flusso del codicee stampa quello che è  presente nell'eccezione che risale fino a trowable
        }

        // il metodo dividi dichiara di lanciare exception e non le gestirà lui ma verranno gestite qui le eccezioni
        try {
            dividi();
        } catch (ArithmeticException aex) {
            System.out.println("Ho gestito il metodo dividi");
        } finally {
            System.out.println("Questo blocco viene eseguito sempre!");
        }

        // si passa dalla più specifica alla più generica (interrupted -> exception)
        try {
            aspetta();
        } catch (InterruptedException iex){
            System.out.println("Non mi interromper che mi arrabbio");
        } catch (Exception ex) {
            System.out.println("Di solito si gestiscono le eccezioni specifiche");
        }

        int eta = 15;
        if (eta < 18)
            throw new IllegalArgumentException("Età non valida per la registrazione"); //abbiamo creato un nuovo oggetto illegal con un nuovo messaggio
    }

    // dichiaro che il mio metodo lancia ArithmeticException
    public static void dividi() throws ArithmeticException {
        int i = 10 / 0;
    }

    // dichiara di lanciare una eccezione checked, chi lo chiama è obbligato a gestirla
    public static void aspetta() throws InterruptedException{
        Thread.sleep(1000);
    }


    public static void bambola1() {
        bambola2();
    }
    public static void bambola2() {
        bambola3();
    }
    public static void bambola3() {
        int i = 10/0;
    }
}
