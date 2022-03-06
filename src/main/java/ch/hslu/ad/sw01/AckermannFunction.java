package ch.hslu.ad.sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.BiFunction;

public class AckermannFunction {
  private static final Logger LOG = LogManager.getLogger(AckermannFunction.class);

  public static void main(String[] args) {
    measureRuntime(AckermannFunction::ackermann, 0, 4);
    measureRuntime(AckermannFunction::ackermann, 1, 2);
    measureRuntime(AckermannFunction::ackermann, 2, 2);
    measureRuntime(AckermannFunction::ackermann, 3, 2);
    measureRuntime(AckermannFunction::ackermann, 4, 2);
  }

  private static void measureRuntime(final BiFunction<Long, Long, Long> function, final long n, final long m) {
    LOG.info("n: {}, m: {}", n, m);
    long start = System.nanoTime();
    function.apply(n, m);
    long end = System.nanoTime();
    LOG.info("Time in nano seconds: " + (end - start));
  }

  private static long ackermann(long n, long m) {
    if (n <= 0) {
      return m + 1;
    }
    if (m <= 0) {
      return ackermann(n - 1, 1);
    }
    return ackermann(n - 1, ackermann(n, m - 1));
  }
}
