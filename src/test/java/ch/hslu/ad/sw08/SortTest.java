package ch.hslu.ad.sw08;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;

import static ch.hslu.ad.exceptionHandling.ExceptionTestHelpers.assertThrowsExactly;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SortTest {

  @Nested
  class FunctionalityTest {
    private final Comparator<String> nullSafeStringComparator = (e1, e2) -> e2 == null ? -1 : e1.compareTo(e2);

    @Test
    void insertionSortIntArrayOnly_null_throwsNullPointerException() {
      assertThrowsExactly(NullPointerException.class, //
                          () -> Sort.insertionSortIntArrayOnly(null), //
                          "Cannot read the array length because \"array\" is null");
    }

    @Test
    void insertionSortIntArrayOnly_emptyArrayLength0_arrayIsSorted() {
      final int[] testArray = new int[0];
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortIntArrayOnly(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortIntArrayOnly_initializedArrayLengthX_arrayIsSorted() {
      final int[] testArray = new int[10];
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortIntArrayOnly(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortIntArrayOnly_sortedArrayAkaBestCase_arrayIsSorted() {
      final int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortIntArrayOnly(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortIntArrayOnly_contains1Element_arrayIsSorted() {
      final int[] testArray = {10};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortIntArrayOnly(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortIntArrayOnly_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
      final int[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortIntArrayOnly(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortIntArrayOnly_unsortedArrayAkaAverageCase_arrayIsSorted() {
      final int[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortIntArrayOnly(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSort_null_throwsNullPointerException() {
      assertThrowsExactly(NullPointerException.class, //
                          () -> Sort.insertionSort(null), //
                          "Cannot read the array length because \"array\" is null");
    }

    @Test
    void insertionSort_differentTypesUsedInArray_throwsClassCastException() {
      final ClassCastException comparisonException = assertThrows(ClassCastException.class, //
                                                                  () -> Sort.insertionSort(new Comparable[]{1,
                                                                                                            "Test"}));
      assertThat(comparisonException.getMessage()).contains("class").contains("cannot be cast to class");
    }

    @Test
    void insertionSort_initializedWithNullArrayLengthX_throwsRuntimeException() {
      final String[] testArray = new String[10];
      assertThrows(RuntimeException.class, //
                   () -> Sort.insertionSort(testArray));
    }

    @Test
    void insertionSort_initializedWithNullsBeside1ItemArrayLengthX_throwsRuntimeException() {
      final String[] testArray = new String[10];
      testArray[5] = "hello";
      assertThrows(RuntimeException.class, //
                   () -> Sort.insertionSort(testArray));
    }

    @Test
    void insertionSort_initializedWithSomeValuesOnly_throwsRuntimeException() {
      final String[] testArray = new String[10];
      testArray[5] = "hello";
      testArray[7] = "hi";
      assertThrows(RuntimeException.class, //
                   () -> Sort.insertionSort(testArray));
    }

    @Test
    void insertionSort_emptyArrayLength0_arrayIsSorted() {
      final String[] testArray = new String[0];
      final String[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSort_sortedArrayAkaBestCase_arrayIsSorted() {
      final Integer[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSort_contains1Element_arrayIsSorted() {
      final Integer[] testArray = {10};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSort_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
      final Integer[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSort_unsortedArrayAkaAverageCase_arrayIsSorted() {
      final Integer[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortNullSafe_null_throwsNullPointerException() {
      assertThrowsExactly(NullPointerException.class, //
                          () -> Sort.insertionSortNullSafe(null), //
                          "Cannot read the array length because \"array\" is null");
    }

    @Test
    void insertionSortNullSafe_differentTypesUsedInArray_throwsClassCastException() {
      final ClassCastException comparisonException = assertThrows(ClassCastException.class, //
                                                                  () -> Sort.insertionSortNullSafe(new Comparable[]{1
                                                                    , "Test"}));
      assertThat(comparisonException.getMessage()).contains("class").contains("cannot be cast to class");
    }

    @Test
    void insertionSortNullSafe_emptyArrayLength0_arrayIsSorted() {
      final String[] testArray = new String[0];
      final String[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortNullSafe(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortNullSafe_initializedWithNullArrayLengthX_insertionSortCanBeCalled() {
      final String[] testArray = new String[10];
      final String[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortNullSafe(testArray);
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortNullSafe_initializedWithNullsBeside1ItemArrayLengthX_itemFirstAndNullItemsAreAtTheEnd() {
      final String[] testArray = new String[10];
      testArray[5] = "hello";
      final String[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortNullSafe(testArray);
      assertThat(testArray).isSortedAccordingTo(nullSafeStringComparator);
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortNullSafe_initializedWithSomeValuesOnly_itemsSortedAndNullItemsAreAtTheEnd() {
      final String[] testArray = new String[10];
      testArray[5] = "hello";
      testArray[7] = "hi";
      final String[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortNullSafe(testArray);
      assertThat(testArray).isSortedAccordingTo(nullSafeStringComparator);
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortNullSafe_sortedArrayAkaBestCase_arrayIsSorted() {
      final Integer[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortNullSafe(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortNullSafe_contains1Element_arrayIsSorted() {
      final Integer[] testArray = {10};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortNullSafe(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortNullSafe_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
      final Integer[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortNullSafe(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortNullSafe_unsortedArrayAkaAverageCase_arrayIsSorted() {
      final Integer[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortNullSafe(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }
  }

  @Nested
  class PerformanceTest {
    private final static Logger LOG = LogManager.getLogger(PerformanceTest.class);

    // final static int SMALL_ARRAY = 4_123;
    // final static int MEDIUM_ARRAY = 8_246;
    // final static int LARGE_ARRAY = 16_492;
    final static int SMALL_ARRAY = 2_123;
    final static int MEDIUM_ARRAY = 4_246;
    final static int LARGE_ARRAY = 8_492;

    final static boolean MEASURE_SMALL_ARRAY = true;
    final static boolean MEASURE_MEDIUM_ARRAY = true;
    final static boolean MEASURE_LARGE_ARRAY = true;
    final static boolean PRINT_ARRAY_SIZES = false;

    final static int RUNS = 100;

    @Nested
    class InsertionSortIntArrayOnly {
      final static String ALGORITHM_NAME = "Sort::insertionSortIntArrayOnly(int[])";
      final Consumer<int[]> ALGORITHM = Sort::insertionSortIntArrayOnly;

      @Test
      void insertionSort_bestCase_aka_sorted() {
        measureRunTimeUnboxed(ALGORITHM, this::setupMasterArrayBestCase, ALGORITHM_NAME, "bestCase");
      }

      private int[] setupMasterArrayBestCase(final int arraySize) {
        return Arrays.stream(PerformanceTest.setupMasterArrayBestCase(arraySize)).mapToInt(Integer::intValue).toArray();
      }

      @Test
      void insertionSort_averageCase_aka_random() {
        measureRunTimeUnboxed(ALGORITHM, this::setupMasterArrayAverageCase, ALGORITHM_NAME, "random");
      }

      private int[] setupMasterArrayAverageCase(final int arraySize) {
        return Arrays.stream(PerformanceTest.setupMasterArrayAverageCase(arraySize)).mapToInt(Integer::intValue).toArray();
      }

      @Test
      void insertionSort_worstCase_aka_ReverseSorted() {
        measureRunTimeUnboxed(ALGORITHM, this::setupMasterArrayWorstCase, ALGORITHM_NAME, "worstCase");
      }

      private int[] setupMasterArrayWorstCase(final int arraySize) {
        return Arrays.stream(PerformanceTest.setupMasterArrayWorstCase(arraySize)).mapToInt(Integer::intValue).toArray();
      }
    }

    @Nested
    class InsertionSort {
      final static String ALGORITHM_NAME = "Sort::insertionSort(Comparable<E>[])";
      final Consumer<Integer[]> ALGORITHM = Sort::insertionSort;

      @Test
      void insertionSort_bestCase_aka_sorted() {
        measureRunTime(ALGORITHM, PerformanceTest::setupMasterArrayBestCase, ALGORITHM_NAME, "bestCase");
      }

      @Test
      void insertionSort_averageCase_aka_random() {
        measureRunTime(ALGORITHM, PerformanceTest::setupMasterArrayAverageCase, ALGORITHM_NAME, "random");
      }

      @Test
      void insertionSort_worstCase_aka_ReverseSorted() {
        measureRunTime(ALGORITHM, PerformanceTest::setupMasterArrayWorstCase, ALGORITHM_NAME, "worstCase");
      }
    }

    @Nested
    class InsertionSortNullSafe {
      final static String ALGORITHM_NAME = "Sort::insertionSortNullSafe(Comparable<E>[])";
      final Consumer<Integer[]> ALGORITHM = Sort::insertionSortNullSafe;

      @Test
      void insertionSort_bestCase_aka_sorted() {
        measureRunTime(ALGORITHM, PerformanceTest::setupMasterArrayBestCase, ALGORITHM_NAME, "bestCase");
      }

      @Test
      void insertionSort_averageCase_aka_random() {
        measureRunTime(ALGORITHM, PerformanceTest::setupMasterArrayAverageCase, ALGORITHM_NAME, "random");
      }

      @Test
      void insertionSort_worstCase_aka_ReverseSorted() {
        measureRunTime(ALGORITHM, PerformanceTest::setupMasterArrayWorstCase, ALGORITHM_NAME, "worstCase");
      }
    }

    private static Integer[] setupMasterArrayBestCase(final int arraySize) {
      final Integer[] values = new Integer[arraySize];
      for (int i = 0; i < arraySize; i++) {
        values[i] = i;
      }
      return values;
    }

    private static Integer[] setupMasterArrayAverageCase(final int arraySize) {
      final Integer[] values = new Integer[arraySize];
      final Random random = new Random(); //instance of random class
      for (int i = 0; i < arraySize; i++) {
        values[i] = random.nextInt();
      }
      return values;
    }

    private static Integer[] setupMasterArrayWorstCase(final int arraySize) {
      final Integer[] values = new Integer[arraySize];
      for (int i = 0, value = arraySize; i < arraySize; i++, value--) {
        values[i] = value;
      }
      return values;
    }

    private void measureRunTime(final Consumer<Integer[]> algorithm, //
                                final Function<Integer, Integer[]> arrayCreationFunction,
                                final String algorithmName, final String caseUsed) {
      long runTimeSmallArray = -1;
      long runTimeMediumArray = -1;
      long runTimeLargeArray = -1;

      if (MEASURE_SMALL_ARRAY) {
        runTimeSmallArray = measureRunTime(algorithm, arrayCreationFunction.apply(SMALL_ARRAY));
        LOG.trace("measure small master array done");
      }

      if (MEASURE_MEDIUM_ARRAY) {
        runTimeMediumArray = measureRunTime(algorithm, arrayCreationFunction.apply(MEDIUM_ARRAY));
        LOG.trace("measure medium master array done");
      }

      if (MEASURE_LARGE_ARRAY) {
        runTimeLargeArray = measureRunTime(algorithm, arrayCreationFunction.apply(LARGE_ARRAY));
        LOG.trace("measure large master array done");
      }
      LOG.trace("");

      printResults(algorithmName, caseUsed, runTimeSmallArray, runTimeMediumArray, runTimeLargeArray);
    }

    private long measureRunTime(final Consumer<Integer[]> algorithm, final Integer[] input) {
      final int length = input.length;
      int timeUsed = 0;
      for (int i = 0; i < RUNS; i++) {
        LOG.trace(i);

        // important, to do the array copy -> otherwise, all runs after the first run are made on an already sorted
        // array
        // call for coping the array is excluded from the time measurement
        final Integer[] testArray = Arrays.copyOf(input, length);

        final long startTime = System.currentTimeMillis();
        algorithm.accept(testArray);
        final long endTime = System.currentTimeMillis();
        timeUsed += (endTime - startTime);

        LOG.trace(timeUsed);
      }
      return timeUsed / RUNS;
    }

    private void measureRunTimeUnboxed(final Consumer<int[]> algorithm, //
                                       final Function<Integer, int[]> arrayCreationFunction, final String algorithmName,
                                       final String caseUsed) {
      long runTimeSmallArray = -1;
      long runTimeMediumArray = -1;
      long runTimeLargeArray = -1;

      if (MEASURE_SMALL_ARRAY) {
        runTimeSmallArray = measureRunTimeUnboxed(algorithm, arrayCreationFunction.apply(SMALL_ARRAY));
        LOG.trace("measure small master array done");
      }

      if (MEASURE_MEDIUM_ARRAY) {
        runTimeMediumArray = measureRunTimeUnboxed(algorithm, arrayCreationFunction.apply(MEDIUM_ARRAY));
        LOG.trace("measure medium master array done");
      }

      if (MEASURE_LARGE_ARRAY) {
        runTimeLargeArray = measureRunTimeUnboxed(algorithm, arrayCreationFunction.apply(LARGE_ARRAY));
        LOG.trace("measure large master array done");
      }
      LOG.trace("");

      printResults(algorithmName, caseUsed, runTimeSmallArray, runTimeMediumArray, runTimeLargeArray);
    }

    private long measureRunTimeUnboxed(final Consumer<int[]> algorithm, final int[] input) {
      final int length = input.length;
      int timeUsed = 0;
      for (int i = 0; i < RUNS; i++) {
        LOG.trace(i);

        // important, to do the array copy -> otherwise, all runs after the first run are made on an already sorted
        // array
        // call for coping the array is excluded from the time measurement
        final int[] testArray = Arrays.copyOf(input, length);

        final long startTime = System.currentTimeMillis();
        algorithm.accept(testArray);
        final long endTime = System.currentTimeMillis();
        timeUsed += (endTime - startTime);

        LOG.trace(timeUsed);
      }
      return timeUsed / RUNS;
    }

    private void printResults(final String algorithm, final String caseUsed, //
                              final long runTimeSmallArray, final long runTimeMediumArray,
                              final long runTimeLargeArray) {
      LOG.info("Runtime Measures for:               " + algorithm);
      LOG.info("Case:                               " + caseUsed);
      LOG.info("Time on small array (ms):           " + runTimeSmallArray);
      LOG.info("Time on medium array (ms):          " + runTimeMediumArray);
      LOG.info("Time on large array (ms):           " + runTimeLargeArray);
      if (PRINT_ARRAY_SIZES) {
        LOG.info("Amount of items in small array:     " + SMALL_ARRAY);
        LOG.info("Amount of items in medium array:    " + MEDIUM_ARRAY);
        LOG.info("Amount of items in large array:     " + LARGE_ARRAY);
      }
      LOG.info("");
    }
  }
}
