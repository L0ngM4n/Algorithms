package dynamicProgramming.lab1707;

import java.util.HashSet;
import java.util.Set;

/**
 * 16/08/2017
 */
public class DownRightMove {

  public static void main(String[] args) {

     int [][] cells = {
         {2, 6, 1, 8, 9, 4, 2},
         {1, 8, 0, 3, 5, 6, 7},
         {3, 4, 8, 7, 2, 1, 8},
         {0, 9, 2, 8, 1, 7, 9},
         {2, 7, 1, 9, 7, 8, 2},
         {4, 5, 6, 1, 2, 5, 6},
         {9, 3, 5, 2, 8, 1, 9},
         {2, 3, 4, 1, 7, 2, 8}
     };

     int rowsCount = cells.length;
     int colsCount = cells[0].length;

     int[][] sums = new int[rowsCount][colsCount];
     
     //Set best paths in 0 column
      sums[0][0] = cells[0][0];
    for (int row = 1; row < rowsCount; row++) {
      sums[row][0] = sums[row - 1][0] + cells[row][0];
    }
    
    //Set best path in 0 row

    for (int col = 1; col < colsCount; col++) {
      sums[0][col] = sums[0][col - 1 ] + cells[0][col];
    }


    //Start finding path

    for (int row = 1; row < rowsCount; row++) {
      for (int col = 1; col < colsCount; col++) {
        sums[row][col] = Math.max(sums[row - 1][col], sums[row][col - 1]) + cells[row][col];
      }
    }

    Set<Pair> path = reconstructPath(sums);


    printMatrx(cells, path);
  }

  private static void printMatrx(int[][] sums, Set<Pair> path) {
    String ANSI_RED = "\u001B[31m";
    String ANSI_RESET = "\u001B[0m";

    for (int i = 0; i < sums.length; i++) {
      for (int j = 0; j < sums[0].length; j++) {
        if (path.contains(new Pair(i, j))) {
          System.out.printf(ANSI_RED + "%d ", sums[i][j]);
        } else {
          System.out.printf(ANSI_RESET + "%d ", sums[i][j]);

        }
      }
      System.out.println();

    }
  }

  private static Set<Pair> reconstructPath(int[][] sums) {

    Set<Pair> path = new HashSet<>();

    int r = sums.length - 1;
    int c = sums[0].length - 1;
    path.add(new Pair<>(r, c));

    while (r > 0 && c > 0) {
      if (sums[r - 1][c] > sums[r][c - 1]){
        path.add(new Pair<>(r - 1, c));
        r--;
      } else {
        path.add(new Pair<>(r, c - 1));
        c--;
      }
    }

    while (r > 0) {
      path.add(new Pair<>(r - 1, c));
      r--;
    }

    while (c > 0){
      path.add(new Pair<>(r, c - 1));
      c--;
    }
    return path;
  }

}
