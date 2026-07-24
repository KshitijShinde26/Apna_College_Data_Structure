import java.util.*;

public class CoinChangeMinAll {

    static final int INF = (int) 1e9;//10^9

    // ---------- Recursion ----------
    static int minCoinsRec(int[] coins, int amount, int idx) {
        if (amount == 0) return 0;
        if (idx == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            return INF;
        }

        int notTake = minCoinsRec(coins, amount, idx - 1);
        int take = INF;
        if (coins[idx] <= amount) {
            take = 1 + minCoinsRec(coins, amount - coins[idx], idx);
        }
        return Math.min(take, notTake);
    }

    // ---------- Memoization ----------
    static int minCoinsMemo(int[] coins, int amount, int idx, int[][] dp) {
        if (amount == 0) return 0;
        if (idx == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            return INF;
        }

        if (dp[idx][amount] != -1) return dp[idx][amount];

        int notTake = minCoinsMemo(coins, amount, idx - 1, dp);
        int take = INF;
        if (coins[idx] <= amount) {
            take = 1 + minCoinsMemo(coins, amount - coins[idx], idx, dp);
        }

        return dp[idx][amount] = Math.min(take, notTake);
    }

    // ---------- Tabulation ----------
    static int minCoinsTab(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // base case for coin[0]
        for (int a = 0; a <= amount; a++) {
            if (a % coins[0] == 0) dp[0][a] = a / coins[0];
            else dp[0][a] = INF;
        }

        for (int i = 1; i < n; i++) {
            for (int a = 0; a <= amount; a++) {
                int notTake = dp[i - 1][a];
                int take = INF;
                if (coins[i] <= a) {
                    take = 1 + dp[i][a - coins[i]];
                }
                dp[i][a] = Math.min(take, notTake);
            }
        }

        return dp[n - 1][amount] >= INF ? -1 : dp[n - 1][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int rec = minCoinsRec(coins, amount, coins.length - 1);
        System.out.println("Recursion: " + (rec >= INF ? -1 : rec));

        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int memo = minCoinsMemo(coins, amount, coins.length - 1, dp);
        System.out.println("Memoization: " + (memo >= INF ? -1 : memo));

        System.out.println("Tabulation: " + minCoinsTab(coins, amount));
    }
}
