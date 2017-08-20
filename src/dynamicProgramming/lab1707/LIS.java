package dynamicProgramming.lab1707;

import java.util.Stack;

/**
 * 16/08/2017
 */
public class LIS {

  public static void main(String[] args) {
    LIS lis = new LIS();

    System.out.println(lis.getLIS());
  }

  //                        i         x
  private static int[] s = {3, 14, 1, 2, 5, 12, 15, 7, 18, 30, 8, 9, 11, 10, 1, 30, 59, 62, 12, 53, 35, 89, 12, 15, 123, 1 ,9 , 25 , 2};

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


  public int getLIS() {

    int maxLenIndex = 0;
    for (int cur = 0; cur < s.length; cur++) {
      len[cur] = 1;
      prev[cur] = -1;
      int maxPrevLen = 0;

      for (int p = 0; p < cur; p++) {
        if (s[p] < s[cur]) {
          if (maxPrevLen < len[p]) {
            maxPrevLen = len[p];
            len[cur] = 1 + maxPrevLen;
            prev[cur] = p;
            if (len[cur] > len[maxLenIndex]) {
              maxLenIndex = cur;
            }
          }
        }
      }

    }
    printSequence(maxLenIndex);
    return len[maxLenIndex];
  }

  private void printSequence(int lastIndex) {
    Stack<Integer> sequence = new Stack<>();
    while (lastIndex != -1) {
      sequence.push(s[lastIndex]);
      lastIndex = prev[lastIndex];
    }
    while (!sequence.empty()) {
      System.out.print(sequence.pop() + " ");
    }
    System.out.println();
  }

}
