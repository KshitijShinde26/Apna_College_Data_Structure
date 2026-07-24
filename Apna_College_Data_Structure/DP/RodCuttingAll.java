import java.util.*;

public class RodCuttingAll {

    static final int INF = (int) 1e9;

    // ---------- Recursion ----------
    static int rodCutRec(int[] price, int n, int len) {
        if (n == 1) {
            return len * price[0];
        }

        int notTake = rodCutRec(price, n - 1, len);
        int take = Integer.MIN_VALUE;

        int rodLen = n;
        if (rodLen <= len) {
            take = price[n - 1] + rodCutRec(price, n, len - rodLen);
        }

        return Math.max(take, notTake);
    }

    // ---------- Memoization ----------
    static int rodCutMemo(int[] price, int n, int len, int[][] dp) {
        if (n == 1) return len * price[0];

        if (dp[n][len] != -1) return dp[n][len];

        int notTake = rodCutMemo(price, n - 1, len, dp);
        int take = Integer.MIN_VALUE;

        int rodLen = n;
        if (rodLen <= len) {
            take = price[n - 1] + rodCutMemo(price, n, len - rodLen, dp);
        }

        return dp[n][len] = Math.max(take, notTake);
    }

    // ---------- Tabulation ----------
    static int rodCutTab(int[] price, int len) {
        int n = price.length;
        int[][] dp = new int[n + 1][len + 1];

        for (int L = 0; L <= len; L++) {
            dp[1][L] = L * price[0];
        }

        for (int i = 2; i <= n; i++) {
            for (int L = 0; L <= len; L++) {
                int notTake = dp[i - 1][L];
                int take = Integer.MIN_VALUE;

                int rodLen = i;
                if (rodLen <= L) {
                    take = price[i - 1] + dp[i][L - rodLen];
                }

                dp[i][L] = Math.max(take, notTake);
            }
        }

        return dp[n][len];
    }

    public static void main(String[] args) {
        int[] price = {2, 5, 7, 8, 10}; // length 1..5
        int len = 5;

        System.out.println("Recursion: " + rodCutRec(price, price.length, len));

        int[][] dp = new int[price.length + 1][len + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println("Memoization: " + rodCutMemo(price, price.length, len, dp));

        System.out.println("Tabulation: " + rodCutTab(price, len));
    }
}
