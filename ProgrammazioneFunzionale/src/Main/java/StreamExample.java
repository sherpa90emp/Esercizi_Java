import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {

        List<Persona> persone = Arrays.asList(
                new Persona("Anna", 23, "Italia"),
                new Persona("Mario", 34, "Italia"),
                new Persona("Michela", 46, "Italia"),
                new Persona("Giorgio", 32, "Italia"),
                new Persona("Frank", 27, "Germania"),
                new Persona("Pavel", 26, "Polonia"),
                new Persona("Zoe", 41, "Germania"),
                new Persona("Ingrid", 38, "Svezia"),
                new Persona("Paul", 24, "Germania"),
                new Persona("Francesca", 45, "Italia"),
                new Persona("Paolo", 33, "Italia")
        );

        System.out.println("Lista di persone originale; " + persone);

        // Esempio1: Cercare tutti i nomi delle persone con più di 30 anni che siano italiane, ordinali alfabeticamente

        // Metodo classico
        List<String> nomiPersone = new ArrayList<>();
        for (Persona p : persone){
            if(p.getEra() > 30 && p.getNazione().equals("Italia"))
                nomiPersone.add(p.getNome());
        }

        Collections.sort(nomiPersone);

        System.out.println("Metodo classico");
        System.out.println("Nomi persone: " + nomiPersone);

        // metodo Stream API
        List<String> nomiPersoneStream = persone.stream() // Ritorna uno stream di Persone
                .filter(p -> p.getNazione().equals("Italia"))
                .filter(p -> p.getEra() > 30)
                .map(p -> p.getNome())
                .sorted((a,b) -> a.compareTo(b))
                .toList();

        System.out.println("Metodo Stream API");
        System.out.println("Nomi persone: " + nomiPersoneStream);

        // Operazioni su tutti gli elementi dello stream
        // Es: stampare a video i nomi tutte le peorsone della GErmania

        persone.stream()
                .filter(p -> p.getNazione().equals("Germania"))
                .forEach(p-> System.out.print(p.getNome() + " "));

        // Es: troviamo il nome della prima persona italiana
        persone.stream()
                .filter(p->p.getNazione().equals("Italia"))
                .findFirst()
                .ifPresent(p -> System.out.println("prima persona italiana: " + p));

        // Es: calcola la media della eta
        int media = (Collections.max(persone).getEra() + Collections.min(persone).getEra()) / 2;
        System.out.println(media);

        System.out.println(media * persone.size());
    }




    static class Persona implements Comparable { //POJO = Plain Old Java Object
        private String nome;
        private int era;
        private String nazione;

        public Persona(String nome, int era, String nazione) {
            this.nome = nome;
            this.era = era;
            this.nazione = nazione;
        }

        public String getNome() {
            return nome;
        }

        public int getEra() {
            return era;
        }

        public String getNazione() {
            return nazione;
        }

        @Override
        public String toString() {
            return "\nPersona{" +
                    "nome='" + nome + '\'' +
                    ", era=" + era +
                    ", nazione='" + nazione + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}
