import java.util.*;

public class WildcardMatchingAll {

    // ---------- Recursion ----------
    static boolean matchRec(String s, String p, int i, int j) {
        if (i == 0 && j == 0) return true;
        if (j == 0) return false;

        if (i == 0) {
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*') return false;
            }
            return true;
        }

        char pc = p.charAt(j - 1);
        char sc = s.charAt(i - 1);

        if (pc == sc || pc == '?') {
            return matchRec(s, p, i - 1, j - 1);
        } else if (pc == '*') {
            return matchRec(s, p, i, j - 1) || matchRec(s, p, i - 1, j);
        } else {
            return false;
        }
    }

    // ---------- Memoization ----------
    static boolean matchMemo(String s, String p, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return true;
        if (j == 0) return false;

        if (i == 0) {
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1;

        char pc = p.charAt(j - 1);
        char sc = s.charAt(i - 1);

        boolean ans;
        if (pc == sc || pc == '?') {
            ans = matchMemo(s, p, i - 1, j - 1, dp);
        } else if (pc == '*') {
            ans = matchMemo(s, p, i, j - 1, dp) || matchMemo(s, p, i - 1, j, dp);
        } else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }

    // ---------- Tabulation ----------
    static boolean matchTab(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char pc = p.charAt(j - 1);
                char sc = s.charAt(i - 1);

                if (pc == sc || pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";

        System.out.println("Recursion: " + matchRec(s, p, s.length(), p.length()));

        int[][] dp = new int[s.length() + 1][p.length() + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println("Memoization: " + matchMemo(s, p, s.length(), p.length(), dp));

        System.out.println("Tabulation: " + matchTab(s, p));
    }
}
