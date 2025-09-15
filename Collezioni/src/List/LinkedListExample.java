package List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> numeri = new LinkedList<>();

        numeri.add(1);
        numeri.add(2);
        numeri.add(3);
        System.out.println("Lista: " + numeri);
        //accesso agli estremi efficiente
        System.out.println("Ultimo: " + numeri.getLast());
        System.out.println("Primo: " + numeri.getFirst());
        // rimozione degli estremi efficiente
        Integer rimossoPrimo = numeri.removeFirst();
        Integer rimossoSecondo = numeri.removeLast();
        System.out.println("Primo: " + rimossoPrimo);
        System.out.println("Secondo: " + rimossoSecondo);
        System.out.println("Lista numeri dopo rimozione: " + numeri);
        //Arraylist - inserimento in testa  = costoso
        List<Integer> arrayList = new ArrayList<>();
        long start = System.nanoTime(); //calcola il tempo trascorso dal 1970 a quando lo castiamo
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, i);
        }
        long stop = System.nanoTime() - start; //
        System.out.println("Array time: " + stop);
        // Linked list - inserimento in testa = efficiente
        start = System.nanoTime();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            linkedList.addFirst(i);
        }
        long timeLinked = System.nanoTime() - start;
        System.out.println("Linked time: " + timeLinked);
        System.out.println("Linked è meglio di array di: " + stop/timeLinked);
    }
}
