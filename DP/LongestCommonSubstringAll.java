public class LongestCommonSubstringAll {

    // ---------- Recursion (returns max length) ----------
    static int lcsSubstringRec(String a, String b, int i, int j, int count) {
        if (i == 0 || j == 0) return count;

        int count1 = count;
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            count1 = lcsSubstringRec(a, b, i - 1, j - 1, count + 1);
        }

        int count2 = lcsSubstringRec(a, b, i - 1, j, 0);
        int count3 = lcsSubstringRec(a, b, i, j - 1, 0);

        return Math.max(count1, Math.max(count2, count3));
    }

    // ---------- Memoization (best with dp[i][j] = length ending at i,j) ----------
    static int lcsSubstringMemo(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

    // ---------- Tabulation ----------
    static int lcsSubstringTab(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String a = "abcde";
        String b = "abfce";

        System.out.println("Recursion: " + lcsSubstringRec(a, b, a.length(), b.length(), 0));
        System.out.println("Memo/DP-style: " + lcsSubstringMemo(a, b));
        System.out.println("Tabulation: " + lcsSubstringTab(a, b));
    }
}
