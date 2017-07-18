package combinatorialAlgorithms;

import tools.Helpers;

import java.util.HashSet;

/**
 * 18/07/2017
 */
public class Permutation {


    public static <T> void gen(T[] elements, int index){

        if (index >= elements.length) {
            Helpers.print(elements);
        } else {
            gen(elements, index + 1);

            HashSet<T> used = new HashSet<>();
            used.add(elements[index]);
            for (int i = index  + 1; i < elements.length; i++) {
                if (!used.contains(elements[i])){
                    used.add(elements[i]);

                Helpers.swap(elements, index, i);
                gen(elements, index + 1);
                Helpers.swap(elements, index, i);
                }
            }
        }
    }
}
