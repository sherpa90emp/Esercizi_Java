package Array;

public class MassimoMinimo {
    public static void main(String[] args) {
        // trovare il massimo di un array di interi

        int[] array = {15, 24, 37, 4, 5, 61, 75, 8, 96, 10};

        maxMin(array);

        Ordinamento.ordinaArrayeStampa(array); //abbiamo importato un metodo da un'altra classe
    }

    public  static  void maxMin(int[] array) {
        int max = array[0];
        int min = array[0];

        for (int i : array) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i; //per ogni ì controlla il minore e sostituiscilo alla variabile min
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}
