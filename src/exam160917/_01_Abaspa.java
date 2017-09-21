package exam160917;


import java.util.Scanner;

/**
 * 16/09/2017
 */
public class _01_Abaspa {
    private static int lcStuff[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String firstStr = sc.nextLine();
        String secondStr = sc.nextLine();
        int length[] = lcSubStr(firstStr.toCharArray(), secondStr.toCharArray(), firstStr.length(), secondStr.length());

        String lcString = reconstruct(length, lcStuff, firstStr.toCharArray()).reverse().toString();
        System.out.println(lcString);
    }

    private static StringBuilder reconstruct(int[] length, int[][] lcStuff, char[] firstStr) {
        StringBuilder sb = new StringBuilder();
        int row = length[0] - 1;
        int col = length[1] - 1;

        for (int i = 0; i < length[2]; i++) {
            sb.append(firstStr[col--]);
        }


        return sb;
    }


    public static int[] lcSubStr(char X[], char Y[], int m, int n)
    {
        // Create a table to store lengths of longest common suffixes of
        // substrings. Note that LCSuff[i][j] contains length of longest
        // common suffix of X[0..i-1] and Y[0..j-1]. The first row and
        // first column entries have no logical meaning, they are used only
        // for simplicity of program
        lcStuff = new int[m + 1][n + 1];
        int result[] = new int[3];  // To store length of the longest common substring

        // Following steps build LCSuff[m+1][n+1] in bottom up fashion
        for (int r = 0; r <= m; r++)
        {
            for (int c = 0; c <= n; c++)
            {
                if (r == 0 || c == 0)
                    lcStuff[r][c] = 0;
                else if (X[r - 1] == Y[c - 1])
                {
                    lcStuff[r][c] = lcStuff[r - 1][c - 1] + 1;
                    if (result[2] < lcStuff[r][c]) {
                        result[1] = r;
                        result[0] = c;
                        result[2] = lcStuff[r][c];
                    }
                }
                else
                    lcStuff[r][c] = 0;
            }
        }
        return result;
    }

}
