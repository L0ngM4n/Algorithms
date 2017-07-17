package sortingSearching;

import tools.Helpers;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 13/07/2017
 */
public class ShuffleFisherYates {

     public static <T> void shuffle(T[] arr) {

          for (int i = 0; i < arr.length; i++) {
               int nextIndex = ThreadLocalRandom.current().nextInt(i, arr.length);

               Helpers.swap(arr, i, nextIndex);

          }
     }

}
