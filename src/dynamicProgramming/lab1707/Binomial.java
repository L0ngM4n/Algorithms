package dynamicProgramming.lab1707;

/**
 * 16/08/2017
 */
public class Binomial {

  private static long binomialLowMemory(int n, int k) {
    long[] zeroRow = new long[n + 1];
    long[] firstRow = new long[n + 1];

    zeroRow[0] = 1;
    firstRow[0] = 1;
    firstRow[1] = 1;

    for (int i = 2; i < n + 1; i++) {
      if (i % 2 == 0) {
        for (int j = 1; j <= i; j++) {
          zeroRow[j] = firstRow[j - 1] + firstRow[j];
        }
      } else {
        for (int j = 1; j <= i; j++) {
          firstRow[j] = zeroRow[j - 1] + zeroRow[j];
        }
      }
    }

    if (k % 2 == 0)

    {
      return firstRow[k];
    } else

    {
      return zeroRow[k];
    }

  }

  private static long bin(int n, int k) {

    long[][] triangle = new long[n + 1][n + 1];
    triangle[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      triangle[i][0] = 1;
      for (int j = 1; j <= i; j++) {
        long prev0 = triangle[i - 1][j - 1];
        long prev1 = triangle[i - 1][j];
        triangle[i][j] = prev0 + prev1;
      }
    }

    return triangle[n][k];
  }

  private static long binomial(int n, int k) {
    if (k > n - k)
      k = n - k;

    long b = 1;
    for (int i = 1, m = n; i <= k; i++, m--)
      b = b * m / i;
    return b;
  }

  public static void main(String[] args) {
    System.out.println(binomial(30, 7));
    System.out.println(bin(30, 7));
    System.out.println(binomialLowMemory(30, 7));
  }
}
