import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5; // Example input
        System.out.println("Number of ways to climb using recursion " + n + " stairs is: " + climbStairsr(n));
        System.out.println("Number of ways to climb using memoization " + n + " stairs is: " + climbStairsm(n));  
        System.out.println("Number of ways to climb using tabulation " + n + " stairs is: " + climbStairst(n));  
    }
    //recursion - O(n^2)
    public static int climbStairsr(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairsr(n - 1) + climbStairsr(n - 2);
    }
    //memoization - O(n)
    public static int climbStairsm(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
    
    private static int helper(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    }
    //tabulation - O(n)
    public static int climbStairst(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}