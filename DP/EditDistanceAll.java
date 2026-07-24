import java.util.*;

public class EditDistanceAll {

    // ---------- Recursion ----------
    static int editRec(String a, String b, int i, int j) {
        if (i == 0) return j;
        if (j == 0) return i;

        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return editRec(a, b, i - 1, j - 1);
        }

        int insert = 1 + editRec(a, b, i, j - 1);
        int delete = 1 + editRec(a, b, i - 1, j);
        int replace = 1 + editRec(a, b, i - 1, j - 1);

        return Math.min(insert, Math.min(delete, replace));
    }

    // ---------- Memoization ----------
    static int editMemo(String a, String b, int i, int j, int[][] dp) {
        if (i == 0) return j;
        if (j == 0) return i;

        if (dp[i][j] != -1) return dp[i][j];

        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return dp[i][j] = editMemo(a, b, i - 1, j - 1, dp);
        }

        int insert = 1 + editMemo(a, b, i, j - 1, dp);
        int delete = 1 + editMemo(a, b, i - 1, j, dp);
        int replace = 1 + editMemo(a, b, i - 1, j - 1, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    // ---------- Tabulation ----------
    static int editTab(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String a = "horse";
        String b = "ros";

        System.out.println("Recursion: " + editRec(a, b, a.length(), b.length()));

        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println("Memoization: " + editMemo(a, b, a.length(), b.length(), dp));

        System.out.println("Tabulation: " + editTab(a, b));
    }
}
