package sortingSearching;

import org.apache.commons.lang3.time.StopWatch;
import tools.Helpers;

import java.util.Random;

/**
 * 13/07/2017
 */
public class Main{


    public static void main(String[] args) {

        int arraySize = 5_000_000;
        Integer[] array = new Integer[arraySize];
        Random random = new Random();
        StopWatch stopWatch = new StopWatch();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(arraySize);
        }
//        System.out.println(Helpers.print(array));
        stopWatch.start();
        System.out.println(Helpers.isSorted(array));
        MergeSort.sort(array);
//        InsertionSort.sort(array);
        stopWatch.stop();
        System.out.println(stopWatch.toString());
//        System.out.println(Helpers.print(array));

        System.out.println(Helpers.isSorted(array));;

    }

}
