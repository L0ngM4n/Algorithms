package dynamicProgramming;

/**
 * 16/09/2017
 */
public class LCSubstring {
    private int[][] T;
    private char[] str1;
    private char[] str2;

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


}
