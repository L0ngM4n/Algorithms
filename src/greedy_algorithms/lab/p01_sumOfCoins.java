package greedy_algorithms.lab;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class p01_sumOfCoins {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String[] elements = in.nextLine().substring(7).split(", ");
    int[] coins = new int[elements.length];
    for (int i = 0; i < coins.length; i++) {
      coins[i] = Integer.parseInt(elements[i]);
    }

    int targetSum = Integer.parseInt(in.nextLine().substring(5));

    Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
    // fancy printing
  }

  public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {

    coins = sortCoins(coins);
    Map<Integer, Integer> result = new HashMap<>();

    int currentSum = 0;
    int coinIndex = 0;

    while (currentSum != targetSum && coinIndex < coins.length) {

      int currentCoin = coins[coinIndex];
      int remainder = targetSum - currentSum;
      int numberOfCoins = remainder / currentCoin;

      if (currentSum + (currentCoin * numberOfCoins) <= targetSum) {

        result.put(currentCoin, numberOfCoins);
        currentSum += currentCoin * numberOfCoins;
        coinIndex++;
      }

    }
    if (currentSum != targetSum) {
      throw new IllegalArgumentException();
    }

    return result;
  }

  private static int[] sortCoins(int[] coins) {
    Integer[] integers = ArrayUtils.toObject(coins);

    Arrays.sort(integers, new Comparator<Integer>() {

      @Override
      public int compare(Integer o1, Integer o2) {

        return o2.compareTo(o1);
      }
    });

    return ArrayUtils.toPrimitive(integers);
  }
}
