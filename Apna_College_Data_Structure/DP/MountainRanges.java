public class MountainRanges {
    static long mountainRanges(int n) {
        // same catalan number
        long[] dp = new long[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            long ways = 0;
            for (int j = 0; j < i; j++) {
                ways += dp[j] * dp[i - j - 1];
            }
            dp[i] = ways;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Mountain Ranges: " + mountainRanges(n));
    }
}
