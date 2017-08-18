package dynamicProgramming.lab1707;

import java.util.Stack;

/**
 * 17/08/2017
 */
public class LongestZigZagSequence {

     private static int[] s = {8, 10, 3, 5, 7, 0, 8, 9, 10, 20, 20, 20, 12, 19, 11};
//  private static int[] s = {2, 1, 3};

  private static int[] oddBig;
  private static int[] oddBigPrev;
  private static int[] evenBig;
  private static int[] evenBigPrev;

  public LongestZigZagSequence() {
    oddBig = new int[s.length];
    evenBig = new int[s.length];
    oddBigPrev = new int[s.length];
    evenBigPrev = new int[s.length];
  }

  public LongestZigZagSequence(int[] sequence) {
    s = sequence;
    oddBig = new int[sequence.length];
    evenBig = new int[sequence.length];
    oddBigPrev = new int[sequence.length];
    evenBigPrev = new int[sequence.length];
  }

  public int getLzz() {
    int maxLen = 0;
    boolean isEven = true;
    int maxLenIndex = 0;


    evenBigPrev[0] = -1;
    oddBigPrev[0] = -1;
    for (int c = 0; c < s.length; c++) {
      evenBig[c] = 1;
      oddBig[c] = 1;
      for (int p = 0; p < c; p++) {
        // smaller c
        if (evenBig[p] % 2 == 0 && s[p] > s[c]) {
          evenBig[c] = evenBig[p] + evenBig[c];
          evenBigPrev[c] = p;
          //bigger c
        } else if (evenBig[p] % 2 != 0 && s[p] < s[c]) {
          evenBig[c] = evenBig[p] + evenBig[c];
          evenBigPrev[c] = p;
        }

        if (oddBig[p] % 2 == 0 && s[p] < s[c]) {
          oddBig[c] = oddBig[p] + oddBig[c];
          oddBigPrev[c] = p;
        } else if (oddBig[p] % 2 != 0 && s[p] > s[c]) {
          oddBig[c] = oddBig[p] + oddBig[c];
          oddBigPrev[c] = p;
        }

        if (maxLen < Math.max(oddBig[c], evenBig[c])) {
          maxLen = Math.max(oddBig[c], evenBig[c]);
          isEven = oddBig[c] < evenBig[c];
          maxLenIndex = c;
        }

      }
    }
    printSequence(isEven, maxLenIndex);
    return maxLen;
  }

  private void printSequence(boolean isEven, int maxLenIndex) {
    Stack<Integer> sequence = new Stack<>();
    while (maxLenIndex != -1) {
      sequence.push(s[maxLenIndex]);
      maxLenIndex = isEven ? evenBigPrev[maxLenIndex] : oddBigPrev[maxLenIndex];
    }
    while (!sequence.empty()) {
      System.out.print(sequence.pop() + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    LongestZigZagSequence lzz = new LongestZigZagSequence();

    System.out.println(lzz.getLzz());

  }

}
