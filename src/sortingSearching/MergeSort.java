package sortingSearching;

import tools.Helpers;

/**
 * 17/07/2017
 */
public class MergeSort{

    private static Integer[] aux;

    public static void sort(Integer[] arr) {

        aux =  new Integer[arr.length];

        sort(arr, 0, arr.length - 1);
    }

    private static  void sort(Integer[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }


    private static void merge(Integer[] arr, int left, int mid, int right) {

        if (Helpers.isLess(arr[mid], arr[mid + 1])) {
            return;
        }

        for (int index = left; index < right + 1; index++) {

            aux[index] = arr[index];
        }


        int l = left;
        int r = mid + 1;
        for (int index = left; index <= right; index++) {

            if (l > mid) {
                arr[index] = aux[r++];

            } else if (r > right) {
                arr[index] = aux[l++];

            } else if (Helpers.isLess(aux[l], aux[r]))  {
                arr[index] = aux[l++];

            } else {
                arr[index] = aux[r++];
            }
        }
    }

}
