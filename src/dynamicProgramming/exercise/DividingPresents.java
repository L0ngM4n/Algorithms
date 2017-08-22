package dynamicProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 21/08/2017
 */
public class DividingPresents {

//  private static int[] s = {3, 2, 3, 2, 2, 77, 89, 23, 90, 11};
  private static int[] sum;

  private static void getPossibleSolutions(int[] s) {

    int total = Arrays.stream(s).sum();
    sum = new int[total + 1];
    sum[0] = 0;
    for (int i = 1; i < sum.length; i++) {
      sum[i] = -1;

    }

    for (int i = 0; i < s.length; i++) {

      for (int j = total - 1; j >= 0; j--) {

        if (sum[j] != -1 && sum[j + s[i]] == -1) {
          sum[j + s[i]] = i;
        }
      }
    }


    int half = total / 2;
    for (int i = half; i >= 0; i--) {

      if (sum[i] != -1) {
        String str = "Difference: %d\n" + "Alan:%d Bob:%d\n" + "Alan takes: %s\n" + "Bob takes the rest.\n" ;
        int alan = i;
        int bob = total - i;
        String alansPresents = getAlanPresents(alan, s);
        System.out.printf(str, bob - alan, alan, bob, alansPresents);
        break;
      }

    }
  }

  private static String getAlanPresents(int alan, int[] s) {
    StringBuilder sb = new StringBuilder();
    int currentSum = alan;

    while (currentSum != 0) {
      sb.append(s[sum[currentSum]]).append(" ");
      currentSum -= s[sum[currentSum]];
    }

    return sb.toString().trim();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] presents = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    getPossibleSolutions(presents);
  }

}
