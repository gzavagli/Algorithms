public class Fibonacci {

    public static int fibonacci(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    public static int fibonacciMemoization(int n) {
        return fibonacciMemoization(n, new int[n + 1]);
    }

    private static int fibonacciMemoization(int i, int[] memo) {
        if (i == 0 || i == 1) return i;

        if (memo[i] == 0) {
            memo[i] = fibonacciMemoization(i - 1, memo) + fibonacciMemoization(i - 2, memo);
        }
        return memo[i];
    }
}
