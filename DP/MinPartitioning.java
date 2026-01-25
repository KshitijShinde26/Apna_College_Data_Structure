public class MinPartitioning {

    static int minPartitionDiff(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int x : arr) sum += x;

        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= sum; s++) {
                boolean notTake = dp[i - 1][s];
                boolean take = false;
                if (arr[i - 1] <= s) take = dp[i - 1][s - arr[i - 1]];
                dp[i][s] = take || notTake;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= sum / 2; s1++) {
            if (dp[n][s1]) {
                int s2 = sum - s1;
                ans = Math.min(ans, Math.abs(s2 - s1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        System.out.println("Minimum Partition Difference: " + minPartitionDiff(arr));
    }
}
