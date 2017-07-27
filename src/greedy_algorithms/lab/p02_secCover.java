package greedy_algorithms.lab;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class p02_secCover {

  interface Filter<T> {
    boolean matches(T t);
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String[] elements = in.nextLine().substring(10).split(", ");
    int[] universe = new int[elements.length];
    for (int i = 0; i < elements.length; i++) {
      universe[i] = Integer.parseInt(elements[i]);
    }

    int numberOfSets = Integer.parseInt(in.nextLine().substring(16));
    List<int[]> sets = new ArrayList<>();
    for (int i = 0; i < numberOfSets; i++) {
      String[] setElements = in.nextLine().split(", ");
      int[] set = new int[setElements.length];
      for (int j = 0; j < setElements.length; j++) {
        set[i] = Integer.parseInt(setElements[i]);
      }
    }

    List<int[]> chosenSets = chooseSets(sets, universe);
  }

  public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {

    Set<Integer> solutionSet = new LinkedHashSet<Integer>(Arrays.asList(ArrayUtils.toObject(universe)));
    List<Set<Integer>> listOfSets = new ArrayList<Set<Integer>>();

    Filter<Set<Set<Integer>>> filter = integers -> {

      Set<Integer> union = new LinkedHashSet<>();
      for (Set<Integer> ints : integers) {
        union.addAll(ints);
      }
      return union.equals(solutionSet);
    };

    Set<Set<Integer>> firstSolution = shortestCombination(filter, listOfSets);

    List<int[]> result = new ArrayList<>();

    for (Set<Integer> integers : firstSolution) {
      Integer[] current = (Integer[])integers.toArray();
      result.add(ArrayUtils.toPrimitive(current));
    }
    return result;
  }

  private static <T> Set<T> shortestCombination(Filter<Set<T>> filter, List<T> listOfSets) {
    int size = listOfSets.size();

    if (size > 10) throw new IllegalArgumentException("Too many combinations");
    int combinations = 1 << size;
    List<Set<T>> possibleSolutions = new ArrayList<>();

    for (int i = 0; i < combinations; i++) {
      Set<T> combination = new LinkedHashSet<>();
      for (int j = 0; j < size; j++) {
        if (((i >> j) & 1) != 0) {
          combination.add(listOfSets.get(j));
        }
      }
      possibleSolutions.add(combination);

      // the possible solutions in order or size
      Collections.sort(possibleSolutions, new Comparator<Set<T>>() {

        @Override
        public int compare(Set<T> o1, Set<T> o2) {
          return o1.size()-o2.size();
        }
      });

      for (Set<T> possibleSol : possibleSolutions) {
        if (filter.matches(possibleSol)){
          return possibleSol;
        }
        return null;
      }
    }






    return null;
  }
}
