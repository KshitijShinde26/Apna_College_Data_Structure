public class UnboundedKnapsackTab {

    static int unboundedKnapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                int notTake = dp[i - 1][w];
                int take = 0;

                if (wt[i - 1] <= w) {
                    // Notice dp[i] (same row) because unlimited items
                    take = val[i - 1] + dp[i][w - wt[i - 1]];
                }

                dp[i][w] = Math.max(take, notTake);
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wt = {2, 3, 4};
        int[] val = {40, 50, 60};
        int W = 5;

        System.out.println("Unbounded Knapsack Max Value: " + unboundedKnapsack(wt, val, W));
    }
}
