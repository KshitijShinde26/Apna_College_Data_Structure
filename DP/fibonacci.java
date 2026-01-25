public class fibonacci {
    public static void main(String[] args) {
        int n = 10; // Example input
        int[] fib = new int[n + 1];
        System.out.println("Fibonacci of " + n + " is: " + fibo(n,fib));
    }

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
}