import java.util.*;

public class MinJumpsTab {

    static int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, (int)1e9);

        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == (int)1e9) continue;

            for (int jump = 1; jump <= arr[i] && i + jump < n; jump++) {
                dp[i + jump] = Math.min(dp[i + jump], dp[i] + 1);
            }
        }

        return dp[n - 1] == (int)1e9 ? -1 : dp[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println("Minimum Jumps: " + minJumps(arr));
    }
}
