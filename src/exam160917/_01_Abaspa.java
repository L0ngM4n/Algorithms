package exam160917;


import dynamicProgramming.LCSubstring;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 16/09/2017
 */
public class _01_Abaspa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String firstStr = sc.nextLine();
        String secondStr = sc.nextLine();
        int[][] memo = new int[firstStr.length()][secondStr.length()];
        LCSubstring lcs = new LCSubstring(memo, firstStr.toCharArray(), secondStr.toCharArray());
        int[] lcsSrgs = lcs.longestCommonSubstring();
        String result = reconstruct(memo, lcsSrgs);
        System.out.println(lcs(firstStr, secondStr));
    }

    private static String reconstruct(int[][] memo, int[] lcsSrgs) {

        return null;
    }

    private _01_Abaspa() {
    }

    // return the longest common prefix of suffix s[p..] and suffix t[q..]
    private static String lcp(String s, int p, String t, int q) {
        int n = Math.min(s.length() - p, t.length() - q);
        for (int i = 0; i < n; i++) {
            if (s.charAt(p + i) != t.charAt(q + i)) {
                return s.substring(p, p + i);

            }
        }
        return s.substring(p, p + n);
    }

    // compare suffix s[p..] and suffix t[q..]
    private static int compare(String s, int p, String t, int q) {
        int n = Math.min(s.length() - p, t.length() - q);
        for (int i = 0; i < n; i++) {
            if (s.charAt(p + i) != t.charAt(q + i))
                return s.charAt(p + i) - t.charAt(q + i);
        }
        if (s.length() - p < t.length() - q) {
            return -1;
        } else if (s.length() - p > t.length() - q) {
            return +1;
        } else {

            return 0;
        }
    }

    public static String lcs(String str1, String str2) {
        SuffixArray suffix1 = new SuffixArray(str1);
        SuffixArray suffix2 = new SuffixArray(str2);

        // find longest common substring by "merging" sorted suffixes
        String lcs = "";
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            int p = suffix1.index(i);
            int q = suffix2.index(j);
            String x = lcp(str1, p, str2, q);
            if (x.length() > lcs.length()) {
                lcs = x;
            }
            if (compare(str1, p, str2, q) < 0) {
                i++;
            } else {
                j++;
            }
        }
        return lcs;
    }

    public static class SuffixArray {

        private Suffix[] suffixes;

        public SuffixArray(String text) {
            int n = text.length();
            this.suffixes = new Suffix[n];
            for (int i = 0; i < n; i++) {
                suffixes[i] = new Suffix(text, i);
            }
            Arrays.sort(suffixes);
        }

        private class Suffix implements Comparable<Suffix> {

            private final String text;
            private final int index;

            private Suffix(String text, int index) {
                this.text = text;
                this.index = index;
            }

            private int length() {
                return text.length() - index;
            }

            private char charAt(int i) {
                return text.charAt(index + i);
            }

            public int compareTo(Suffix other) {
                if (this == other) return 0;  // optimization
                int n = Math.min(this.length(), other.length());
                for (int i = 0; i < n; i++) {
                    if (this.charAt(i) < other.charAt(i)) return -1;
                    if (this.charAt(i) > other.charAt(i)) return +1;
                }
                return this.length() - other.length();
            }

            public String toString() {
                return text.substring(index);
            }
        }

        public int length() {
            return suffixes.length;
        }


        public int index(int i) {
            if (i < 0 || i >= suffixes.length) throw new IllegalArgumentException();
            return suffixes[i].index;
        }

        public int lcp(int i) {
            if (i < 1 || i >= suffixes.length) throw new IllegalArgumentException();
            return lcpSuffix(suffixes[i], suffixes[i - 1]);
        }

        // longest common prefix of s and t
        private int lcpSuffix(Suffix s, Suffix t) {
            int n = Math.min(s.length(), t.length());
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != t.charAt(i)) return i;
            }
            return n;
        }

        public String select(int i) {
            if (i < 0 || i >= suffixes.length) throw new IllegalArgumentException();
            return suffixes[i].toString();
        }

        public int rank(String query) {
            int lo = 0, hi = suffixes.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int cmp = compare(query, suffixes[mid]);
                if (cmp < 0) hi = mid - 1;
                else if (cmp > 0) lo = mid + 1;
                else return mid;
            }
            return lo;
        }

        // compare query string to suffix
        private int compare(String query, Suffix suffix) {
            int n = Math.min(query.length(), suffix.length());
            for (int i = 0; i < n; i++) {
                if (query.charAt(i) < suffix.charAt(i)) return -1;
                if (query.charAt(i) > suffix.charAt(i)) return +1;
            }
            return query.length() - suffix.length();
        }

    }

}
