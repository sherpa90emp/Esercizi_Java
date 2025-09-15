import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfacciaFunzionale {
    public static void main(String[] args) {
        // Es: Predicate<T> torna un boolean e accetta sempre un ingresso
        Predicate<Integer> isPositive = (num) -> num > 0;
        System.out.println("Il nume 9 è positivo? " + isPositive.test(9));

        // Es: Function<T, R> prende input ed output ed esegue la funzione
        Function<String, Integer> stringLenght = (str) -> str.length();
        System.out.println("Lunghezza di 'ciao mondo!' è: " + stringLenght.apply("Ciao mondo!"));

        // Es: Consumer<String> prende un valore in ingresso e non da nulla in uscita
        Consumer<String> printUppercase = (s) -> System.out.println(s.toUpperCase());
        printUppercase.accept("ciao mondo!");

        // Es: Supplier<T> non prende in ingresso niente ma ritorna un output
        Supplier<Integer> randomInt = () -> (int) (Math.random() + 100) + 1;
        System.out.println("Primo numero random: " + randomInt.get());
    }
}
