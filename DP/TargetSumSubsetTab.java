public class TargetSumSubsetTab {
    // ---------- Tabulation ----------
    static boolean targetSumSubset(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // sum=0 always possible (empty set)
        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= target; s++) {
                boolean notTake = dp[i - 1][s];
                boolean take = false;
                if (arr[i - 1] <= s) {
                    take = dp[i - 1][s - arr[i - 1]];
                }
                dp[i][s] = take || notTake;
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3};
        int target = 10;

        System.out.println("Target Sum Subset Possible? " + targetSumSubset(arr, target));
    }
}