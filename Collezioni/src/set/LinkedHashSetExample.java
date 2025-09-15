package set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        System.out.println("Confronto tra HASHSET e LINKEDHASHSET");

        //hash set
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Primo");
        hashSet.add("Secondo");
        hashSet.add("Terzo");
        hashSet.add("Quarto");
        hashSet.add("Quinto");
        // ordine casuale con hashset; viene associato un indice casuale
        for (String elem : hashSet)
            System.out.println("- " + elem);

        System.out.println("\n");

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Primo");
        linkedHashSet.add("Secondo");
        linkedHashSet.add("Terzo");
        linkedHashSet.add("Quarto");
        linkedHashSet.add("Quinto");
        //mantiene ordine inserimento
        for (String elem : linkedHashSet)
            System.out.println("- " + elem);

        Set<String> pagineVisitate = new LinkedHashSet<>();
        visistaPagina(pagineVisitate, "Home");
        visistaPagina(pagineVisitate, "Prodotti");
        visistaPagina(pagineVisitate, "Home");
        visistaPagina(pagineVisitate, "Chi siamo");
        visistaPagina(pagineVisitate, "Contatti");
        visistaPagina(pagineVisitate, "Prodotti");

        int numero = 1;
        for (String pagina : pagineVisitate) {
            System.out.println(numero++ + " - " + pagina);
        }
    }

    public static void visistaPagina(Set<String> cronologia, String newPanina) {
        if (cronologia.add(newPanina)) {
            System.out.println("Pagina visitata per la prima volta!" + newPanina);
        } else {
            System.out.println("Già visitata: " + newPanina);
        }
    }
}
