package examPrep140817._01_Medenka;

import java.util.*;

/**
 * 14/09/2017
 */
public class Medenka {
  private static Map<Integer, Integer> memo = new HashMap<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String medenkata = sc.nextLine().replaceAll("\\s", "");

    List<Integer> result = new ArrayList<>();

    int start = medenkata.indexOf('1');

    int nuts = getNutsCunt(medenkata);

    generateCuts(start, nuts, 0, medenkata, result);

  }


  private static void generateCuts(int start, int nuts, int cuts, String medenkata, List<Integer> result) {

    if (cuts == nuts - 1) {
      printCake(medenkata, result);
    } else {
      int end = medenkata.indexOf('1', start + 1);
      for (int i = start; i < end; i++) {
        result.add(i);
        memo.put(i, result.size() - 1);
        generateCuts(end, nuts, cuts + 1, medenkata, result);
        int last = result.remove(result.size() - 1);
        memo.remove(last);
      }

    }
  }

  private static void printCake(String medenkata, List<Integer> result) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < medenkata.toCharArray().length; i++) {
      sb.append(medenkata.charAt(i));
      if (memo.containsKey(i)) {
        sb.append("|");
      }
    }
    System.out.println(sb.toString());
  }

  private static int getStartIndex(int[] medenkata) {
    for (int i = 0; i < medenkata.length; i++) {
      if (medenkata[i] == 1) {
        return i;
      }
    }
    return -1;
  }


  private static int getNutsCunt(String medenkata) {
    int nuts = 0;
    for (char c : medenkata.toCharArray()) {
      if (c == '1') {
        nuts++;
      }
    }
    return nuts;
  }
}
