package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> etaPersone = new HashMap<>();
        // inserisco coppie chiave/valore = nome/età
        etaPersone.put("Mario", 25);
        etaPersone.put("Anna", 30);
        etaPersone.put("Carlo", 56);
        etaPersone.put("Luigi", 56);
        System.out.println(etaPersone);
        System.out.println(etaPersone.size());
        //inserimento duplicato e aggiornamento
        etaPersone.put("Carlo", 45);
        System.out.println(etaPersone);

        //ricerca valore per chiave
        Integer etaMario = etaPersone.get("Mario");
        System.out.println("Età mario: " + etaMario);
        // controllo esistenza chiave
        if (etaPersone.containsKey("Anna"))
            System.out.println("Anna è presente nella mappa");
        // controllo esistenza vaolre
        if (etaPersone.containsValue(56))
            System.out.println("Qualcuno ha 28 anni");

        //aggiunge o aggiorna solo se non esiste
        etaPersone.putIfAbsent("Mario", 50);
        System.out.println("età mario: " + etaPersone.get("Mario"));
        // rimuovo per chiave, mi torna il valore
        Integer etaRimossa = etaPersone.remove("Luigi");
        System.out.println("Età rimossa di Luigi: " + etaRimossa);

        //iterazione sulle chiavi; poco performante rispetto alle iterazioni sulle entry
        System.out.println("Iterazione sulle chiavi: ");
        Set<String> chiavi = etaPersone.keySet();
        for (String nome : chiavi)
            System.out.println(nome + " -> " + etaPersone.get(nome));

        //iterazione sui valori
        System.out.println("Iterazione sui valori");
        for (Integer eta : etaPersone.values())
            System.out.println(" - " + eta + " anni");

        // Iterazione sulle Entry
        System.out.println("Iterazione sille entry");
        for (Map.Entry<String, Integer> entry : etaPersone.entrySet())
            System.out.println(entry.getKey() + " ha " + entry.getValue() + " anni");
    }
}
