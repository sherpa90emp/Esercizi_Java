import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        System.out.println("Espressioni Lambda");

        List<String> nomi = Arrays.asList("Mario", "Anna", "Giuseppe", "Giorgio");
        System.out.println("Lista non ordinata: " + nomi);

        // Ordinamento la lista con lambda expression () -> {}
        Collections.sort(nomi, (a, b) -> a.compareTo(b));
        System.out.println("Lista ordinata: " + nomi);

        // Versione classsica
//        Collections.sort(nomi, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2){
//                return o1.compareTo(o2);
//            }
//        });

        OperazioneMatematica addizione = (a, b) -> a + b;
        OperazioneMatematica moltiplicazione = (a, b) -> a * b;


        int risultatoSomma = calcola(1,2, addizione);
        int risultatoMoltiplicazione = calcola(1,2, moltiplicazione);

        System.out.println("risultatoSomma: " + risultatoSomma);
        System.out.println("risultatoMoltiplicazione: " + risultatoMoltiplicazione);

        int risultatoDivisione = calcola(4,2, (a,b) -> a/b);
        System.out.println("risultatoDivisione: " + risultatoDivisione);

        Collections.sort(nomi, String::compareTo); // method reference

    }

    public static int calcola(int a, int b, OperazioneMatematica op) {
        return op.esegui(a,b);
    }

    @FunctionalInterface
    interface OperazioneMatematica {
        int esegui(int a, int b);
    }
}
