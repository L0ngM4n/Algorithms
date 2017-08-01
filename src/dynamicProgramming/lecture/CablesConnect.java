package dynamicProgramming.lecture;

/**
 * 01/08/2017
 */
public class CablesConnect {

  static int[] p1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
  static int[] p2 = new int[] {2, 5, 3, 8, 7, 4, 6, 9, 1};
  static int[][] maxCon = new int[p1.length + 1][p2.length + 1];

  public static void main(String[] args) {

    for (int i = 0; i < p1.length; i++) {
      for (int j = 0; j < p2.length; j++) {
        maxCon[i][j] = -1;
      }
    }

    int num = genConnections(p1.length - 1, p2.length - 1);
    System.out.println(num);

  }

  private static int genConnections(int x, int y) {

    if (x < 0 || y < 0) {
      return 0;
    }

    if (maxCon[x][y] != -1){
      return maxCon[x][y];
    }

    if (p1[x] == p2[y]) {

      maxCon[x][y] = 1 + genConnections(x - 1, y - 1);
    } else {

      int reducedX = genConnections(x - 1, y);
      int reducedY = genConnections(x, y - 1);

      maxCon[x][y] = Math.max(reducedX, reducedY);
    }
    return maxCon[x][y];
  }
}
