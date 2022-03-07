package ch.hslu.ad.sw01;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciTest {

  @Test
  void fibonacciRecursive_0_returns0() {
    assertThat(Fibonacci.recursive(0)).isZero();
  }

  @Test
  void fibonacciRecursive_1_returns1() {
    assertThat(Fibonacci.recursive(1)).isOne();
  }

  @Test
  void fibonacciRecursive_2_returns1() {
    assertThat(Fibonacci.recursive(2)).isOne();
  }

  @Test
  void fibonacciRecursive_7_returns13() {
    assertThat(Fibonacci.recursive(7)).isEqualTo(13);
  }

  @Test
  void fibonacciRecursiveOptimized_0_returns0() {
    assertThat(Fibonacci.recursiveOptimized(0)).isZero();
  }

  @Test
  void fibonacciRecursiveOptimized_1_returns1() {
    assertThat(Fibonacci.recursiveOptimized(1)).isOne();
  }

  @Test
  void fibonacciRecursiveOptimized_2_returns1() {
    assertThat(Fibonacci.recursiveOptimized(2)).isOne();
  }

  @Test
  void fibonacciRecursiveOptimized_7_returns13() {
    assertThat(Fibonacci.recursiveOptimized(7)).isEqualTo(13);
  }

  @Test
  void fibonacciIterative_1_returns1() {
    assertThat(Fibonacci.iterative(1)).isOne();
  }

  @Test
  void fibonacciIterative_2_returns1() {
    assertThat(Fibonacci.iterative(2)).isOne();
  }

  @Test
  void fibonacciIterative_7_returns13() {
    assertThat(Fibonacci.iterative(7)).isEqualTo(13);
  }

  @Test
  void compareRuntime() {
    System.out.println("----      Recursive      ----");
    measureRuntime(Fibonacci::recursive);
    System.out.println("---- Recursive Optimized ----");
    measureRuntime(Fibonacci::recursiveOptimized);
    System.out.println("----      Iterative      ----");
    measureRuntime(Fibonacci::iterative);

    // ----      Recursive      ----
    // Time in nano seconds: 47500
    // ---- Recursive Optimized ----
    // Time in nano seconds: 21300
    // ----      Iterative      ----
    // Time in nano seconds: 11000
  }

  // --> Runtimemessungen sollten immer mehrfach ausgeführt werden
  private void measureRuntime(final Function<Integer, Integer> function) {
    long start = System.nanoTime();
    //final long iterations = 1_000_000L;
    final long iterations = 100L;
    for (long i = 0; i < iterations; i++) {
      Fibonacci.resetFibonacciNumberCache();
      function.apply(10);
    }
    long end = System.nanoTime();
    final long averageRuntime = (end - start) / iterations;
    System.out.println("Time in nano seconds: " + averageRuntime);
  }
}