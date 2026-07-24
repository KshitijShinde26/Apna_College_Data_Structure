public class TimeComplexity {
    public static void main(String[] args) {
        int n = 5; // Example input size
        int sum = 0;

        // O(n) time complexity example
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        System.out.println("Sum of first " + n + " numbers is: " + sum);

        // O(n^2) time complexity example
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count++;
            }
        }
        System.out.println("Total iterations in nested loop: " + count);
    }
}
