package ch.hslu.ad.performanceTesting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public abstract class AlgorithmPerformanceTest {
  private final static Logger LOG = LogManager.getLogger(AlgorithmPerformanceTest.class);

  final static int LARGE_ARRAY = 50_492;
  final static int MEDIUM_ARRAY = LARGE_ARRAY / 2;
  final static int SMALL_ARRAY = MEDIUM_ARRAY / 2;

  final static boolean MEASURE_SMALL_ARRAY = true;
  final static boolean MEASURE_MEDIUM_ARRAY = true;
  final static boolean MEASURE_LARGE_ARRAY = true;

  final static boolean MEASURE_BEST_CASE = true;
  final static boolean MEASURE_WORST_CASE = true;
  final static boolean MEASURE_AVERAGE_CASE = true;

  final static int RUNS = 3;

  @BeforeAll
  static void beforeAll() {
    LOG.info("");
    if (MEASURE_SMALL_ARRAY) {
      LOG.info("Amount of items in small array:     " + SMALL_ARRAY);
    }
    if (MEASURE_MEDIUM_ARRAY) {
      LOG.info("Amount of items in medium array:    " + MEDIUM_ARRAY);
    }
    if (MEASURE_LARGE_ARRAY) {
      LOG.info("Amount of items in large array:     " + LARGE_ARRAY);
    }
    LOG.info("");
  }

  abstract static class PerformanceTestCase {
    private static boolean titlePrinted;

    @BeforeAll
    static void beforeAll() {
      titlePrinted = false;
    }

    @AfterAll
    static void afterAll() {
      titlePrinted = false;
    }

    @Test
    void bestCase() {
      fail("test case not implemented");
    }

    @Test
    void averageCase() {
      fail("test case not implemented");
    }

    @Test
    void worstCase() {
      fail("test case not implemented");
    }

    static void printTitleIfItWasFirstTestCase(final String algorithmName) {
      if (!titlePrinted) {
        LOG.info("");
        LOG.info("Runtime Measures for:               " + algorithmName);
        titlePrinted = true;
      }
    }

    void printResults(final String caseUsed, final long runTimeSmallArray, final long runTimeMediumArray,
                      final long runTimeLargeArray) {
      LOG.info("Case:                               " + caseUsed);
      if (MEASURE_SMALL_ARRAY) {
        LOG.info("Time on small array (ms):           " + runTimeSmallArray);
      }
      if (MEASURE_MEDIUM_ARRAY) {
        LOG.info("Time on medium array (ms):          " + runTimeMediumArray);
      }
      if (MEASURE_LARGE_ARRAY) {
        LOG.info("Time on large array (ms):           " + runTimeLargeArray);
      }
    }
  }
}
