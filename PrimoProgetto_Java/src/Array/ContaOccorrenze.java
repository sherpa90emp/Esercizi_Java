package Array;

public class ContaOccorrenze {
    public static void main(String[] args) {
        // dato un array stampare quante volte compare il numero n

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = 1;

        int counter = 0;
        for (int a: array) {
            if (a == i){
                counter++;
            }
        }
        System.out.println(counter);
    }
}
