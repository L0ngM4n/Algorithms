package dynamicProgramming;

/**
 * 16/09/2017
 */
public class LCSubstring {
    private int[][] T;
    private char[] str1;
    private char[] str2;
    int lcStuff[][];

    public LCSubstring(int[][] t, char[] str1, char[] str2) {
        T = t;
        this.str1 = str1;
        this.str2 = str2;
    }

    public int[] longestCommonSubstring(){


        int max = 0;
        int[] maxEnd = new int[3];
        for(int i=1; i <= str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    T[i][j] = T[i-1][j-1] +1;
                    if(max < T[i][j]){
                        max = T[i][j];
                        maxEnd[0] = i;
                        maxEnd[1] = j;
                    }
                }
            }
        }
        maxEnd[2] = max;
        return maxEnd;
    }

    public int[][] getLcStuff() {
        return lcStuff;
    }

    public  int[] lcSubStr(char X[], char Y[], int m, int n)
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
