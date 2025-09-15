package Array;

import java.util.Arrays;

public class Ordinamento {
    public static void main(String[] args) {
        // dato un array di interi: stampare i suoi elementi in ordine crescente

        int[] numeri = {42, 7, 89, 15, 63, 28, 91, 34, 76, 50};
        //int fristNum = numeri[0];

       ordinaArrayeStampa(numeri); //evocazione del metodo

        int[] array2 = {78, 85, 89, 63, 52, 14, 159, 12, 36};

        ordinaArrayeStampa(array2);
    }

    public static void ordinaArrayeStampa(int[] numeri) {
        for (int i = 0; i < numeri.length; i++) {
            int key = numeri[i];
            int j = i - 1;

            while ( j >= 0 && numeri[j] > key){
                numeri[j + 1] = numeri[j];
                j--;
            }

            numeri[j + 1] = key;
        }
        System.out.println(Arrays.toString(numeri));
    }
}
