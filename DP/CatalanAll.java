import java.util.*;

public class CatalanAll {

    // ---------- Recursion ----------
    static long catRec(int n) {
        if (n <= 1) return 1;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catRec(i) * catRec(n - i - 1);
        }
        return ans;
    }

    // ---------- Memoization ----------
    static long catMemo(int n, long[] dp) {
        if (n <= 1) return 1;
        if (dp[n] != -1) return dp[n];

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catMemo(i, dp) * catMemo(n - i - 1, dp);
        }
        return dp[n] = ans;
    }

    // ---------- Tabulation ----------
    static long catTab(int n) {
        long[] dp = new long[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            long ans = 0;
            for (int j = 0; j < i; j++) {
                ans += dp[j] * dp[i - j - 1];
            }
            dp[i] = ans;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Recursion: " + catRec(n));

        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Memoization: " + catMemo(n, dp));

        System.out.println("Tabulation: " + catTab(n));
    }
}
