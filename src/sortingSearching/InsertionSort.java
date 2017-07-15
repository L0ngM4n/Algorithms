package sortingSearching;

import tools.Helpers;

/**
 * 13/07/2017
 */
public class InsertionSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {


        for (int i = 0; i < arr.length; i++) {

            int prev = i - 1;

            while (prev >= 0 && arr[prev].compareTo(arr[prev + 1]) > 0) {
                Helpers.swap(arr, prev, prev + 1);
                prev--;
            }

        }
    }
}
