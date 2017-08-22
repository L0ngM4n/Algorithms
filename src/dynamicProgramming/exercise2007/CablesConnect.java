package dynamicProgramming.exercise2007;

/**
 * 01/08/2017
 */
public class CablesConnect {

  static int[] p1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
  static int[] p2 = new int[] {2, 5, 3, 8, 7, 4, 6, 9, 1};
  static int[][] maxCon = new int[p1.length + 1][p2.length + 1];

  public static void main(String[] args) {
    for (int i = 1; i < maxCon.length; i++) {
      for (int j = 1; j < maxCon[0].length; j++) {
        maxCon[i][j] = -1;
      }
    }



    int max = getMaxConnected(p1.length - 1, p2.length - 1);
    System.out.println(max);
  }

  private static int getMaxConnected(int x, int y) {

    if (x < 0 || y < 0) {
      return 0;
    }

    if (maxCon[x][y] != -1) {
      return maxCon[x][y];
    }

    if (p1[x] == p2[y]) {
      maxCon[x][y] =  1 + getMaxConnected(x - 1, y - 1);
    } else {
      int reduceP1 = getMaxConnected(x - 1, y);

      int reduceP2 = getMaxConnected(x, y -1);
      return Math.max(reduceP1, reduceP2);
    }

    return maxCon[x][y];
  }
}
