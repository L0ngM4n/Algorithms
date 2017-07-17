package sortingSearching;

import tools.Helpers;

/**
 * 17/07/2017
 */
public class QuickSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int left, int right) {

        if (right <= left) {
            return;
        }

        int partitionIndex = partition(arr, left, right);

        sort(arr, left, partitionIndex - 1);
        sort(arr, partitionIndex + 1, right);

    }

    private static <T extends Comparable<T>> int partition(T[] arr, int left, int right) {

        int leftScanIndex = left;
        int rightScanIndex = right;
        T partitionElement = arr[left];

        while (true) {
            while (Helpers.isLess(arr[++leftScanIndex], partitionElement)) {

                if (leftScanIndex == right) {
                    break;
                }
            }

            while (Helpers.isLess(partitionElement, arr[--rightScanIndex])) {

                if (rightScanIndex == right) {
                    break;
                }
            }


            if (leftScanIndex >= rightScanIndex) {
                break;
            }

            Helpers.swap(arr, leftScanIndex, rightScanIndex);
        }

        Helpers.swap(arr, leftScanIndex, rightScanIndex);

        // https://youtu.be/7OUW40faK2g?t=8156
        //TODO
        return rightScanIndex;
    }
}
