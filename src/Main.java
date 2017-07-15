import org.apache.commons.lang3.time.StopWatch;
import sortingSearching.InsertionSort;
import tools.Helpers;

import java.util.Random;

/**
 * 13/07/2017
 */
public class Main{


    public static void main(String[] args) {

        int arraySize = 50_000;
        Integer[] array = new Integer[arraySize];
        Random random = new Random();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(arraySize);
        }
//        System.out.println(Helpers.print(array));
        System.out.println(Helpers.isSorted(array));

        InsertionSort.sort(array);
        stopWatch.stop();
        System.out.println(stopWatch.toString());
//        System.out.println(Helpers.print(array));

        System.out.println(Helpers.isSorted(array));;

    }

}
