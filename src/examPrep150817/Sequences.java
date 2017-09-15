package examPrep150817;

import java.util.Scanner;

/**
 * 15/09/2017
 */
public class Sequences {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int targetSum = Integer.parseInt(sc.nextLine());


    byte[] variations = new byte[targetSum];

    getSequences(0, 0, targetSum, variations);
  }

  private static void getSequences(int index, int currentSum, int targetSum, byte[] variations) {
    if (currentSum <= targetSum && currentSum != 0) {
      print(variations);
    }

    if (currentSum >= targetSum) {
      return;
    }

    for (byte i = 1; i <= targetSum - currentSum; i++) {
      variations[index] = i;
      getSequences(index + 1, currentSum + i, targetSum, variations);
      variations[index] = 0;
    }
  }


  private static void print(byte[] variations) {
    StringBuilder sj = new StringBuilder();
    for (byte variation : variations) {
      if (variation > 0) {
        sj.append(String.valueOf(variation)).append(" ");
      }
    }
    System.out.println(sj.toString().trim());
  }
}
