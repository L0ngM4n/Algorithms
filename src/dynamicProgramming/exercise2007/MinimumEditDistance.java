package dynamicProgramming.exercise2007;

/**
 * 22/08/2017
 */
public class MinimumEditDistance {
  private static int COST_DELETE = 1;
  private static int COST_INSERT = 2;
  private static String s1 = " equalrent";
  private static String s2 = " different";
  private static int[][] f = new int[s1.length()][s2.length()];


  public static void main(String[] args) {


    //initialise
    for (int i = 0; i < s1.length(); i++) {
      f[i][0] = i * COST_DELETE;
    }

    for (int j = 0; j < s2.length(); j++) {
      f[0][j] = j * COST_INSERT;
    }

    //main cycle
    for (int i = 1; i < s1.length(); i++) {
      for (int j = 1; j < s2.length(); j++) {
        int costReplace = getCostReplace(i, j);
        f[i][j] = Math.min(f[i - 1][j - 1] + costReplace,
                          Math.min(f[i][j - 1] + COST_INSERT, f[i -1][j] + COST_DELETE));
      }
    }
    printM(f);
    System.out.println();


    int i = f.length - 1;
    int j = f[0].length - 1;
    System.out.printf("Minimum edit distance: %d\n", f[i][j]);
    printEditOperations(i, j);
  }

  private static int getCostReplace(int i, int j) {
    return s1.charAt(i) == s2.charAt(j) ? 0 : 3;
  }

  private static void printEditOperations(int i, int j) {


    if (0 == j) {
      for (j = 1; j <= i; j++) {
        System.out.printf("DELETE %s\n", j - 1);
      }
    } else if (i == 0) {
      for (i = 1; i <= j; i++) {
        System.out.printf("INSERT %s, %s\n", i - 1, s2.charAt(i));
      }
    } else if (i > 0 && j > 0){
      if (f[i][j] == f[i - 1][j - 1] + getCostReplace(i, j)) {
        printEditOperations(i - 1, j - 1);
        if (getCostReplace(i, j) > 0){
          System.out.printf("REPLACE %s %s\n", i - 1, s2.charAt(j));
        }
      } else if (f[i][j] == f[i][ j - 1] + COST_INSERT) {
        printEditOperations(i, j - 1);
        System.out.printf("INSERT %s, %s\n", i, s2.charAt(j));
      } else if (f[i][j] == f[i - 1][j] + COST_DELETE) {
        printEditOperations(i - 1, j);
        System.out.printf("DELETE %s\n", i - 1);
      }
    }

  }

  private static void printM(int [][] f) {
    for (int i = 0; i < f.length; i++) {
      for (int j = 0; j < f[0].length; j++) {
        int num = f[i][j];
        System.out.print(((num < 10) ? "  " : " ") + num);
      }
      System.out.println();

    }
  }
}
