package combinatorialAlgorithms;

/**
 * 18/07/2017
 */
public class Variation {


    public static <T> void gen(T[] elements, int k) {

        int[] vector = new int[k];

        while (true) {

            printVar(elements, vector);

            int index = k - 1;

            while (index >= 0 && vector[index] == elements.length - 1) {
                index--;
            }
        }

    }

    private static <T> void printVar(T[] elements, int[] vector) {

        for (int i = 0; i < vector.length; i++) {
            System.out.println(elements[vector[i]]);
        }
        System.out.println();
    }

}
