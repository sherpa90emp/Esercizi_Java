package List;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListComparason {
    public static void main(String[] args) {
        System.out.println("ArrayList vs LinkedList");
        int size = 100000;
        testRandomAccess(size);
    }

    public static void testRandomAccess(int size) {
        System.out.println("Test accesso casuale a " + size + " elementi.");
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i); //abbiamo pienato gli array/list
        }
        //test arraylist
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int index = (int) (Math.random() * size);
            arrayList.get(index);
        }
        long timeArray = System.nanoTime() - start;
        // test linkedList
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int index = (int) (Math.random() * size);
            linkedList.get(index);
        }
        long timeLinked = System.nanoTime() - start;

        System.out.println("Array time: " + timeArray/100000.0 + " ms");
        System.out.println("Linked time: " + timeLinked/100000.0 + " ms"); //.0 perchè è un long
        System.out.println("Vincitore: " + (timeArray < timeLinked ? "ArrayList" : "LinkedList"));
    }
}
