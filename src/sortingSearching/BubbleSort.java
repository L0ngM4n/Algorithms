package sortingSearching;

import tools.Helpers;

/**
 * 13/07/2017
 */
public class BubbleSort {


    public static <T extends Comparable<T>> void sort(T[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (!Helpers.isLess(arr[j], arr[j + 1])) {
                    Helpers.swap(arr, j, j + 1);
                }

            }
        }
    }
}
