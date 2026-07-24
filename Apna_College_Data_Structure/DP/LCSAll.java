import java.util.*;

public class LCSAll {

    // ---------- Recursion ----------
    static int lcsRec(String a, String b, int i, int j) {
        if (i == 0 || j == 0) return 0;

        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return 1 + lcsRec(a, b, i - 1, j - 1);
        } else {
            return Math.max(lcsRec(a, b, i - 1, j), lcsRec(a, b, i, j - 1));
        }
    }

    // ---------- Memoization ----------
    static int lcsMemo(String a, String b, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return dp[i][j] = 1 + lcsMemo(a, b, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(
                    lcsMemo(a, b, i - 1, j, dp),
                    lcsMemo(a, b, i, j - 1, dp)
            );
        }
    }

    // ---------- Tabulation ----------
    static int lcsTab(String a, String b) {
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String a = "abcde";
        String b = "ace";

        System.out.println("Recursion: " + lcsRec(a, b, a.length(), b.length()));

        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println("Memoization: " + lcsMemo(a, b, a.length(), b.length(), dp));

        System.out.println("Tabulation: " + lcsTab(a, b));
    }
}
