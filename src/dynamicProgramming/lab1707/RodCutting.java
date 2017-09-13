package dynamicProgramming.lab1707;

/**
 * 23/08/2017
 */
public class RodCutting {

    static int[] prices = {0,1,5,8,9};
    static int[] memo = new int[prices.length];

    public static void main(String[] args) {
        System.out.println(cutRod(4));
    }

    private static int cutRod(int lenght) {
        if (memo[lenght] != 0) {
            return memo[lenght];
        }

        if (lenght == 0) {
            return 0;
        }

        int currentMax = Integer.MIN_VALUE;
        for (int i = 1; i <= lenght; i++) {
            currentMax = Math.max(currentMax, prices[i] + cutRod(lenght - 1));
        }
        return currentMax;
    }
}
