package ch.hslu.ad.sw01;

public final class Fibonacci {
  private static Integer[] fibonacciNumbers = new Integer[10000];

  public static int recursive(final int n) {
    // Rekursionsbasis: n < 2 -> return n
    if (n < 2) {
      return n;
    }
    // Rekursionsvorschrift: n >= 2 -> return f(n-1) + f(n-2)
    return recursive(n - 2) + recursive(n - 1);
  }

  public static int recursiveOptimized(final int n) {
    // Rekursionsbasis: n < 2 -> return n
    if (fibonacciNumbers[n] != null) {
      return fibonacciNumbers[n];
    }
    if (n < 2) {
      return n;
    }
    // Rekursionsvorschrift: n >= 2 -> return f(n-1) + f(n-2)
    final int fibonacciNumber = recursive(n - 2) + recursive(n - 1);
    fibonacciNumbers[n] = fibonacciNumber;
    return fibonacciNumber;
  }

  public static int iterative(final int n) {
    int a = 0;
    int b = 1;
    for (int i = 0; i < n; i++) {
      int c = a + b;
      b = a;
      a = c;
    }
    return a;
  }
}
