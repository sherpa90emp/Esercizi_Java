package queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // linked list implementa queque
        Queue<String> coda = new LinkedList<>();
        coda.offer("Primo cliente");
        coda.offer("Secondo cliente");
        coda.offer("Terzo cliente");
        System.out.println(coda);
        System.out.println(coda.size());

        //ispezione senza rimozione
        String prossimo = coda.peek();
        System.out.println("Prossimo da servire: " + prossimo);
        System.out.println(coda);

        // rimozione e ottenimento
        String servito = coda.poll();
        System.out.println("Serviamo il cliente: " + servito);
        System.out.println(coda); //un volta "servito" rimuove il cliente

        //metodi di accesso che lanciano eccezioni
        try {
            String testa = coda.element();
            System.out.println("Testa: " + testa);

            String removed = coda.remove();;
            System.out.println("Rimosso: " + removed);
            removed = coda.remove();
            System.out.println(removed);
            removed = coda.remove(); // eccezione perchè coda vuota
            System.out.println(removed);

        } catch (NoSuchElementException nseEx) {
            System.out.println("Errore: " + nseEx.getMessage());
        }
    }
}
