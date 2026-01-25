import java.util.*;

public class Knapsack01All {

    // ---------- Recursion ----------
    static int knapsackRec(int[] wt, int[] val, int n, int W) {
        if (n == 0 || W == 0) return 0;

        if (wt[n - 1] > W) {
            return knapsackRec(wt, val, n - 1, W);
        } else {
            int take = val[n - 1] + knapsackRec(wt, val, n - 1, W - wt[n - 1]);
            int notTake = knapsackRec(wt, val, n - 1, W);
            return Math.max(take, notTake);
        }
    }

    // ---------- Memoization ----------
    static int knapsackMemo(int[] wt, int[] val, int n, int W, int[][] dp) {
        if (n == 0 || W == 0) return 0;

        if (dp[n][W] != -1) return dp[n][W];

        if (wt[n - 1] > W) {
            return dp[n][W] = knapsackMemo(wt, val, n - 1, W, dp);
        } else {
            int take = val[n - 1] + knapsackMemo(wt, val, n - 1, W - wt[n - 1], dp);
            int notTake = knapsackMemo(wt, val, n - 1, W, dp);
            return dp[n][W] = Math.max(take, notTake);
        }
    }

    // ---------- Tabulation ----------
    static int knapsackTab(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    int take = val[i - 1] + dp[i - 1][w - wt[i - 1]];
                    int notTake = dp[i - 1][w];
                    dp[i][w] = Math.max(take, notTake);
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int W = 7;
        int n = wt.length;

        System.out.println("Recursion: " + knapsackRec(wt, val, n, W));

        int[][] dp = new int[n + 1][W + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println("Memoization: " + knapsackMemo(wt, val, n, W, dp));

        System.out.println("Tabulation: " + knapsackTab(wt, val, W));
    }
}
