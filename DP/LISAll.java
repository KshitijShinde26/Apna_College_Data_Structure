import java.util.*;

public class LISAll {

    // ---------- Recursion ----------
    static int lisRec(int[] arr, int idx, int prevIdx) {
        if (idx == arr.length) return 0;

        int notTake = lisRec(arr, idx + 1, prevIdx);
        int take = 0;

        if (prevIdx == -1 || arr[idx] > arr[prevIdx]) {
            take = 1 + lisRec(arr, idx + 1, idx);
        }
        return Math.max(take, notTake);
    }

    // ---------- Memoization ----------
    static int lisMemo(int[] arr, int idx, int prevIdx, int[][] dp) {
        if (idx == arr.length) return 0;

        if (dp[idx][prevIdx + 1] != -1) return dp[idx][prevIdx + 1];

        int notTake = lisMemo(arr, idx + 1, prevIdx, dp);
        int take = 0;

        if (prevIdx == -1 || arr[idx] > arr[prevIdx]) {
            take = 1 + lisMemo(arr, idx + 1, idx, dp);
        }

        return dp[idx][prevIdx + 1] = Math.max(take, notTake);
    }

    // ---------- Tabulation ----------
    static int lisTab(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] > arr[prev]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println("Recursion: " + lisRec(arr, 0, -1));

        int[][] dp = new int[arr.length][arr.length + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println("Memoization: " + lisMemo(arr, 0, -1, dp));

        System.out.println("Tabulation: " + lisTab(arr));
    }
}
