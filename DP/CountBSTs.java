public class CountBSTs {
    static long countBST(int n) {
        // Catalan number
        long[] dp = new long[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            long ways = 0;
            for (int root = 1; root <= i; root++) {
                ways += dp[root - 1] * dp[i - root];
            }
            dp[i] = ways;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Count of BSTs: " + countBST(n));
    }
}
