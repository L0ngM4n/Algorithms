package exam160917;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 16/09/2017
 */
public class _02_Balls {
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        int p = Integer.parseInt(sc.nextLine());
        int targetSumN = Integer.parseInt(sc.nextLine());
        int pocketLimitK = Integer.parseInt(sc.nextLine());

        int[] variations = init(p);
        int currentSum = p;

        getSequences(0, p, 0, p, targetSumN, pocketLimitK, variations);

        System.out.println(sb.toString().trim());
    }

    private static void getSequences(int currentSum,int leftP, int currentPocket, int p, int targetSumN, int pocketLimitK,
                                     int[] variations) {

        if (currentSum + leftP == targetSumN) {
            sb.append(print(variations));
            sb.append(System.lineSeparator());
            return;
        }

        if (currentSum + leftP > targetSumN || currentPocket >= variations.length) {
            return;
        }


        for (int i = pocketLimitK; i > 0; i--) {
            variations[currentPocket] = i;
            leftP = p - currentPocket - 1;
            currentSum += i;
            getSequences(currentSum, leftP, currentPocket + 1, p, targetSumN, pocketLimitK, variations);
            currentSum -= i;
        }


    }


    private static String print(int[] variations) {
        StringJoiner sj = new StringJoiner(", ");
        for (int variation : variations) {

            sj.add(String.valueOf(variation));

        }
        return  sj.toString();
    }

    private static int getCurrentSum(int[] variations) {
        int sum = 0;
        for (int num : variations) {
            sum += num;
        }
        return sum;
    }

    private static int[] init(int p) {

        int[] var = new int[p];
        for (int i = 0; i < var.length; i++) {
            var[i] = 1;
        }
        return var;
    }
}

