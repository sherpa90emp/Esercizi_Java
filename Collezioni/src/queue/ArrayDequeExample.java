package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        deque.offerLast("Primo");
        deque.offerLast("Secondo");
        deque.offerLast("Terzo");
        System.out.println(deque);

        //rimozione dall'inizio
        while(!deque.isEmpty())
            System.out.println("Pop: " + deque.pop()); // equivale a removeFrist

        System.out.println(deque);

        // aggiungo in entrambe le estremità
        deque.addFirst("Centro");
        deque.addFirst("Sinistra");
        deque.addLast("Destra");
        System.out.println(deque);

        simulaUndoRedo();
    }

    public static void simulaUndoRedo() {
        Deque<String> cronologiaAzioni = new ArrayDeque<>();
        Deque<String> azioniAnnullate = new ArrayDeque<>();
        // eseguiamo delle azioni
        eseguiAzioni("Scrivi 'Hello'", cronologiaAzioni, azioniAnnullate);
        eseguiAzioni("Aggiungi 'World'", cronologiaAzioni, azioniAnnullate);
        eseguiAzioni("Cambia colore rosso", cronologiaAzioni, azioniAnnullate);
        eseguiAzioni("Ingrandisci font", cronologiaAzioni, azioniAnnullate);
        System.out.println("Cronologia: " + cronologiaAzioni);
        //undo
        undo(cronologiaAzioni, azioniAnnullate);
        undo(cronologiaAzioni, azioniAnnullate);
        //redo
        redo(cronologiaAzioni, azioniAnnullate);
        System.out.println("Stato finale cronologia: " + cronologiaAzioni);
        System.out.println("Azioni annullate: " + azioniAnnullate);
    }
    private  static void eseguiAzioni(String azione, Deque<String> cronologia, Deque<String> annullate) {
        cronologia.addLast(azione);
        annullate.clear();
        System.out.println("Eseguito azione: " + azione);
    }
    private static void undo(Deque<String> cronologia, Deque<String> annullate) {
        if ((!cronologia.isEmpty())) {
            String azione = cronologia.removeLast();
            annullate.addFirst(azione);
            System.out.println("Undo: " + azione);
        }
    }
    private static void redo(Deque<String> cronologia, Deque<String> annullate) {
        if (!annullate.isEmpty()) {
            String azione = annullate.removeFirst();
            cronologia.addLast(azione);
            System.out.println("Redo: " + azione);
        }
    }
}
