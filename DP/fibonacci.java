public class fibonacci {
    public static void main(String[] args) {
        int n = 10; // Example input
        int[] fib = new int[n + 1];
        System.out.println("Fibonacci of " + n + " is: " + fibo(n,fib));
        System.out.println("Fibonacci of " + n + " using tabulation is: " + fiboTab(n));
    }
    //memoization
    public static int fibo(int n,int[] fib) {
        if (n <= 1) {
            return n;
        }
        if(fib[n]!=0){
            return fib[n];
        }
        fib[n] = fibo(n-1, fib) + fibo(n-2, fib);
        return fib[n];
    }
    //tabulation
    public static int fiboTab(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}