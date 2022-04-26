package ch.hslu.ad.performanceTesting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;

import static ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest.LARGE_ARRAY;
import static ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest.MEASURE_AVERAGE_CASE;
import static ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest.MEASURE_BEST_CASE;
import static ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest.MEASURE_LARGE_ARRAY;
import static ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest.MEASURE_MEDIUM_ARRAY;
import static ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest.MEASURE_SMALL_ARRAY;
import static ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest.MEASURE_WORST_CASE;
import static ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest.MEDIUM_ARRAY;
import static ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest.RUNS;
import static ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest.SMALL_ARRAY;

public abstract class PerformanceTestCasePrimitive extends AlgorithmPerformanceTest.PerformanceTestCase {
  final String algorithmName;
  final Consumer<int[]> algorithm;
  final String masterArrayBestCase;
  final String masterArrayWorstCase;
  final String masterArrayAverageCase;

  public PerformanceTestCasePrimitive(final String algorithmName, final Consumer<int[]> algorithm, //
                                      final String masterArrayBestCase, //
                                      final String masterArrayAverageCase, //
                                      final String masterArrayWorstCase) {
    this.algorithmName = algorithmName;
    this.algorithm = algorithm;
    this.masterArrayBestCase = masterArrayBestCase;
    this.masterArrayAverageCase = masterArrayAverageCase;
    this.masterArrayWorstCase = masterArrayWorstCase;
  }

  @Test
  void bestCase() {
    if (MEASURE_BEST_CASE) {
      printTitleIfItWasFirstTestCase(algorithmName);
      measureRunTime(algorithm, "bestCase", masterArrayBestCase);
    }
  }

  @Test
  void averageCase() {
    if (MEASURE_AVERAGE_CASE) {
      printTitleIfItWasFirstTestCase(algorithmName);
      measureRunTime(algorithm, "averageCase", masterArrayAverageCase);
    }
  }

  @Test
  void worstCase() {
    if (MEASURE_WORST_CASE) {
      printTitleIfItWasFirstTestCase(algorithmName);
      measureRunTime(algorithm, "worstCase", masterArrayWorstCase);
    }
  }

  private void measureRunTime(final Consumer<int[]> algorithm, final String caseUsed, final String masterArrayType) {
    long runTimeSmallArray = -1;
    long runTimeMediumArray = -1;
    long runTimeLargeArray = -1;
    final Map<Integer, MasterArray> arraysBySize = MasterArray.getArraysBySizeForType(masterArrayType);
    // arraysBySize.values().forEach(e -> System.out.println(e.getMasterArray()));

    if (MEASURE_SMALL_ARRAY) {
      runTimeSmallArray = measureRunTime(algorithm, arraysBySize.get(SMALL_ARRAY).getMasterArray());
    }

    if (MEASURE_MEDIUM_ARRAY) {
      runTimeMediumArray = measureRunTime(algorithm, arraysBySize.get(MEDIUM_ARRAY).getMasterArray());
    }

    if (MEASURE_LARGE_ARRAY) {
      runTimeLargeArray = measureRunTime(algorithm, arraysBySize.get(LARGE_ARRAY).getMasterArray());
    }

    super.printResults(caseUsed, runTimeSmallArray, runTimeMediumArray, runTimeLargeArray);
  }

  private long measureRunTime(final Consumer<int[]> algorithm, final int[] input) {
    final int length = input.length;
    int timeUsed = 0;
    for (int i = 0; i < RUNS; i++) {
      // important, to do the array copy -> otherwise, all runs after the first run are made on an already sorted
      // array
      // call for coping the array is excluded from the time measurement
      final int[] testArray = Arrays.copyOf(input, length);

      final long startTime = System.currentTimeMillis();
      algorithm.accept(testArray);
      final long endTime = System.currentTimeMillis();
      timeUsed += (endTime - startTime);
    }
    return timeUsed / RUNS;
  }
}
