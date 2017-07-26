package greedy_algorithms.lab;

import java.util.*;

public class p01_sumOfCoins {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String[] elements = in.nextLine().substring(7).split(", ");
    Integer[] coins = new Integer[elements.length];
    for (int i = 0; i < coins.length; i++) {
      coins[i] = Integer.parseInt(elements[i]);
    }

    int targetSum = Integer.parseInt(in.nextLine().substring(5));

    Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
    // fancy printing
  }

  public static Map<Integer, Integer> chooseCoins(Integer[] coins, int targetSum) {

    sortCoins(coins);
    Map<Integer, Integer> result = new HashMap<>();

    int currentSum = 0;
    int coinIndex = 0;

    while (currentSum != targetSum && coinIndex < coins.length) {

    }
    return null;
  }

  private static void sortCoins(Integer[] coins) {
    Arrays.sort(coins, new Comparator<Integer>() {

      @Override
      public int compare(Integer o1, Integer o2) {

        return o2.compareTo(o1);
      }
    });
  }
}
