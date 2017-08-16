package dynamicProgramming.lab1707;

import java.util.Stack;

/**
 * 16/08/2017
 */
public class LIS {

  //                        i         x
  private static int[] s = {3, 14, 5, 12, 15, 7, 8, 9, 11, 10, 1};

  private static int[] len;
  private static int[] prev;

  public LIS() {
    len = new int[s.length];
    prev = new int[s.length];
  }

  public LIS(int[] sequence) {
    s = sequence;
    len = new int[sequence.length];
    prev = new int[sequence.length];

  }

  public int getLis() {
    int maxLen = 1;
    int prevIndex = -1;
    int lastIndex = 0;

    for (int x = 0; x < s.length; x++) {
      len[x] = 1;
      prev[x] = -1;

      for (int i = 0; i < x; i++) {
        if (s[i] < s[x]) {
          maxLen = len[i] + 1;
          len[x] = maxLen;
          prev[x] = i;
          lastIndex = x;
        }
      }
    }

    printSequence(lastIndex);

    return maxLen;
  }

  private void printSequence(int lastIndex) {
    Stack<Integer> sequence = new Stack<>();
    while (lastIndex != -1) {
      sequence.push(s[lastIndex]);
      lastIndex = prev[lastIndex];
    }
    while (!sequence.empty()){
      System.out.print(sequence.pop() + " ");
    }
    System.out.println();

  }

}
