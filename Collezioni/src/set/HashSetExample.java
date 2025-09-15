package set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        //Creazione di un hashset
        Set<String> colori = new HashSet<>();
        colori.add("Rosso");
        colori.add("Blu");
        colori.add("Verde");
        colori.add("Rosso");//la ripetizione è permessa ma non viene visualizzata
        System.out.println("Set di colori: " + colori);
        System.out.println("Dimensione: " + colori.size());
        //verifica presenza
        if (colori.contains("Verde")) {
            System.out.println("Nei colori è presente il Verde!");
        }
        //rimozione
        boolean rimosso = colori.remove("Blu");
        System.out.println("Blu rimosso: " + rimosso);
        System.out.println("Set dopo rimozione: " + colori);
        //unione di insiemi
        Set<String> unione = new HashSet<>(colori); //creato a partire da un vecchio hasset
        Set<String> altriColori = new HashSet<>();
        altriColori.add("Ocra");
        altriColori.add("Ciano");
        altriColori.add("Magenta");
        altriColori.add("Verde"); //se già presente non lo aggiunge nuovamente sempre il discorso della ripetizione
        unione.addAll(altriColori);
        System.out.println("Unioni di insiemi: " + unione);

        Set<String> intersezione = new HashSet<>(colori);
        intersezione.retainAll(altriColori);
        System.out.println("Intersezione: " + intersezione); // restituisce ciò che è uguale fra i due

        Set<String> differenza = new HashSet<>(colori); // quello che viene scritto qui è quello da cui si sottrae richiamando il metodo retainAll
        differenza.retainAll(altriColori);
        System.out.println("Differenza: " + differenza);

        for (String colore : unione)
            System.out.println("- " + colore);
    }
}
