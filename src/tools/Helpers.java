package tools;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 13/07/2017
 */
public class Helpers {

    public static <T> void swap(T[] arr, int fIndex, int secIndex) {
        T temp = arr[fIndex];
        arr[fIndex] = arr[secIndex];
        arr[secIndex] = temp;
    }

    public static <T extends Comparable<T>> boolean isLess(T secondEl, T firstEl) {
        return secondEl.compareTo(firstEl) < 0;
    }

    public static <T> String print(T[] array) {
        StringJoiner sj = new StringJoiner(" ");

        Arrays.stream(array).forEach((e -> sj.add(String.valueOf(e))));
        System.out.println(sj.toString());
        return sj.toString();
    }

    public static <T extends Comparable<T>> String isSorted(T[] array) {

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1].compareTo(array[i]) > 0) {
                return "Not sorted";
            }
        }

        return "Sorted";
    }
}
