package ch.hslu.ad.sw01;

public final class Fibonacci {

  // hint: hier könnte eine Map verwendet werden --> Vorteil: kein IndexOutOfBound, Nachteil: wahrscheinlich
  // tendentiell längere Laufzeit und Cache sollte ja eigentlich schneller sein als die Berechnung ohne Cache...
  private static Integer[] fibonacciNumberCache = new Integer[10000];

  public static void resetFibonacciNumberCache() {
    Fibonacci.fibonacciNumberCache = new Integer[10000];
  }

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
    if (n < 2) {
      return n;
    }
    // Rekursionsvorschrift: n >= 2 -> return f(n-1) + f(n-2)
    if (fibonacciNumberCache[n] != null) {
      return fibonacciNumberCache[n];
    }
    final int fibonacciNumber = recursive(n - 2) + recursive(n - 1);
    fibonacciNumberCache[n] = fibonacciNumber;
    return fibonacciNumber;
  }

  public static int iterative(final int n) {
    int first = 0;
    int second = 1;
    for (int i = 0; i < n; i++) {
      int temp = first + second;
      second = first;
      first = temp;
    }
    return first;
  }
}
