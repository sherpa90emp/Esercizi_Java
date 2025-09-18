import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfacceFunzionali {
    public static void main(String[] args) {
        // Es:  Predicate torna un booleano e accetta sempre un ingresso
        Predicate<Integer> isPositive = (num) -> num > 0;
        System.out.println("Il numero 10 è positivo? " + isPositive.test(10));
        System.out.println("Il numero -5 è positivo? " + isPositive.test(-5));
        System.out.println("Il numero 20 è positivo? " + isPositive.test(20));
        System.out.println("Il numero 0 è positivo? " + isPositive.test(0));

        // Es: Function<T, R> prende input e output ed esegue una funzione
        Function<String, Integer> stringLenght = (str) -> str.length();
        System.out.println("Lunghezza di `ciao mondo!` è: " + stringLenght.apply("Ciao mondo!"));

        // Es: Consumer<String> prende un valore in ingresso non da nulla in cambio
        Consumer<String> printUppercase = (s) -> System.out.println(s.toUpperCase());
        printUppercase.accept("ciao mondo!");

        // Es: Suppliers non prende ingresso ma ritorno un output
        Supplier<Integer> randomInt = () -> (int)(Math.random() * 100) + 1;
        System.out.println("Primo numero random: " + randomInt.get());
        System.out.println("Secondo numero random: " + randomInt.get());

    }
}
