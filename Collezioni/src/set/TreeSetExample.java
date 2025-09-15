package set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        //Tree set con ordinamento naturale
        Set<Integer> numeri = new TreeSet<>();
        numeri.add(10);
        numeri.add(20);
        numeri.add(65);
        numeri.add(55);
        System.out.println(numeri);

        Set<String> nomi = new TreeSet<>(); //li ordina per alfabeto
        nomi.add("Marco");
        nomi.add("Tarma");
        nomi.add("Eri");
        nomi.add("Fio");
        System.out.println(nomi);

        // test con comparatore personalizzato, che compara per lunghezza stringa
        Set<String> nomiPerLunghezza = new TreeSet<>(new Comparator<String>() { //implementazione dell'interfaccia comparable
            @Override
            public int compare(String o1, String o2) {
                int result = Integer.compare(o1.length(), o2.length());
                if (result == 0)
                    return o1.compareTo(o2); // se la lunghezza è uguale vado in ordine alfabetico
                return result;
            }
        });

        nomiPerLunghezza.add("Alessandro");
        nomiPerLunghezza.add("Bernardo");
        nomiPerLunghezza.add("Carla");
        nomiPerLunghezza.add("Marco");
        nomiPerLunghezza.add("Mario");
        System.out.println(nomiPerLunghezza);
    }
}
