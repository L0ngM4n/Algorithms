package sortingSearching;

import tools.Helpers;

/**
 * 13/07/2017
 */
public class Selection {

    public static <T extends Comparable<T>> void sort(T[] arr){
        for (int idx = 0; idx < arr.length; idx++) {
            int min = idx;

            for (int curr = idx + 1; curr < arr.length; curr++) {

                if (Helpers.isLess(arr[curr], arr[min])) {
                    min = curr;
                }
            }

            Helpers.swap(arr, min, idx);
        }
    }
}
