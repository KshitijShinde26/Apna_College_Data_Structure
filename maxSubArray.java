public class maxSubArray {

    public static int maxSubArraySum(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        // prefix[i] = sum of first i elements
        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE;

        // Try every subarray using prefix sums
        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end <= n; end++) {
                int sum = prefix[end] - prefix[start];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1 ,-2,6,-1,3};
        System.out.println("Maximum subarray sum is: " + maxSubArraySum(arr));
    }
}
