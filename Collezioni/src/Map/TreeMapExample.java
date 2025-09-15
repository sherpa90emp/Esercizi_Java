package Map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        //Treemap con ordinamento naturale
        Map<String, Double> voti = new TreeMap<>();
        voti.put("Matematica", 8.5);
        voti.put("Fisica", 7.0);
        voti.put("Italiano", 6.0);
        voti.put("Chimica", 8.0);

        for (Map.Entry<String, Double> entry : voti.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());

        //ordinamento personalizzato, ordina in base al voto
        Map<String, Double> votiPerVoto = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String v1, String v2) {
                Double voto1 = voti.get(v1);
                Double voto2 = voti.get(v2);
                //ordino per voto decrescente
                int risultato = Double.compare(voto2, voto1); //metto quindi il voto due per primo
                if (risultato == 0) return v1.compareTo(v2);
                return risultato;
            }
        });
        votiPerVoto.putAll(voti);
        System.out.println("*******");
        for (Map.Entry<String, Double> entry : votiPerVoto.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}
