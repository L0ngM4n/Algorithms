import combinatorialAlgorithms.Permutation;
import org.apache.commons.lang3.time.StopWatch;
import tools.Helpers;

import java.util.Random;

/**
 * 13/07/2017
 */
public class Main{


    public static void main(String[] args) {

        int arraySize = 3;
//        Integer[] array = new Integer[arraySize];
        String[] array = new String[]{"A", "B", "B", "B", "B", "B", "B"};
        Random random = new Random();
        StopWatch stopWatch = new StopWatch();

//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(arraySize);
//        }
//        System.out.println(Helpers.print(array));
        stopWatch.start();
        System.out.println(Helpers.isSorted(array));
//        MergeSort.sort(array);
//        InsertionSort.sort(array);

        Permutation.gen(array, 0);
//        Helpers.print(array);


//        stopWatch.stop();
//        System.out.println(stopWatch.toString());
//        System.out.println(Helpers.print(array));

//        System.out.println(Helpers.isSorted(array));;

    }

}
