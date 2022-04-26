package ch.hslu.ad.performanceTesting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

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

public abstract class PerformanceTestCaseComparable extends AlgorithmPerformanceTest.PerformanceTestCase {
  final String algorithmName;
  final Consumer<Integer[]> algorithm;
  final Function<Integer, Integer[]> setupMasterArrayBestCase;
  final Function<Integer, Integer[]> setupMasterArrayAverageCase;
  final Function<Integer, Integer[]> setupMasterArrayWorstCase;

  public PerformanceTestCaseComparable(final String algorithmName, final Consumer<Integer[]> algorithm, //
                                       final Function<Integer, Integer[]> setupMasterArrayBestCase, //
                                       final Function<Integer, Integer[]> setupMasterArrayAverageCase, //
                                       final Function<Integer, Integer[]> setupMasterArrayWorstCase) {
    this.algorithmName = algorithmName;
    this.algorithm = algorithm;
    this.setupMasterArrayBestCase = setupMasterArrayBestCase;
    this.setupMasterArrayAverageCase = setupMasterArrayAverageCase;
    this.setupMasterArrayWorstCase = setupMasterArrayWorstCase;
  }

  @Test
  void bestCase() {
    if (MEASURE_BEST_CASE) {
      printTitleIfItWasFirstTestCase(algorithmName);
      measureRunTimeBoxed(algorithm, setupMasterArrayBestCase, "bestCase");
    }
  }

  @Test
  void averageCase() {
    if (MEASURE_AVERAGE_CASE) {
      printTitleIfItWasFirstTestCase(algorithmName);
      measureRunTimeBoxed(algorithm, setupMasterArrayAverageCase, "random");
    }
  }

  @Test
  void worstCase() {
    if (MEASURE_WORST_CASE) {
      printTitleIfItWasFirstTestCase(algorithmName);
      measureRunTimeBoxed(algorithm, setupMasterArrayWorstCase, "worstCase");
    }
  }

  private void measureRunTimeBoxed(final Consumer<Integer[]> algorithm,
                                   final Function<Integer, Integer[]> arrayCreationFunction, final String caseUsed) {
    long runTimeSmallArray = -1;
    long runTimeMediumArray = -1;
    long runTimeLargeArray = -1;

    if (MEASURE_SMALL_ARRAY) {
      runTimeSmallArray = measureRunTimeBoxed(algorithm, arrayCreationFunction.apply(SMALL_ARRAY));
    }

    if (MEASURE_MEDIUM_ARRAY) {
      runTimeMediumArray = measureRunTimeBoxed(algorithm, arrayCreationFunction.apply(MEDIUM_ARRAY));
    }

    if (MEASURE_LARGE_ARRAY) {
      runTimeLargeArray = measureRunTimeBoxed(algorithm, arrayCreationFunction.apply(LARGE_ARRAY));
    }

    super.printResults(caseUsed, runTimeSmallArray, runTimeMediumArray, runTimeLargeArray);
  }

  private long measureRunTimeBoxed(final Consumer<Integer[]> algorithm, final Integer[] input) {
    final int length = input.length;
    int timeUsed = 0;
    for (int i = 0; i < RUNS; i++) {

      // important, to do the array copy -> otherwise, all runs after the first run are made on an already sorted
      // array
      // call for coping the array is excluded from the time measurement
      final Integer[] testArray = Arrays.copyOf(input, length);

      final long startTime = System.currentTimeMillis();
      algorithm.accept(testArray);
      final long endTime = System.currentTimeMillis();
      timeUsed += (endTime - startTime);
    }
    return timeUsed / RUNS;
  }
}
