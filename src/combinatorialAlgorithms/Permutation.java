package combinatorialAlgorithms;

import tools.Helpers;

/**
 * 18/07/2017
 */
public class Permutation {


    public static <T> void gen(T[] elements, int index){

        if (index >= elements.length) {
            Helpers.print(elements);
        } else {
            gen(elements, index + 1);

            for (int i = index  + 1; i < elements.length; i++) {
                Helpers.swap(elements, index, i);
                gen(elements, index + 1);
                Helpers.swap(elements, index, i);
            }
        }
    }
}
