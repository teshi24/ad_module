package ch.hslu.ad.sw08;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
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
    void insertionSort_null_throwsNullPointerException() {
      assertThrowsExactly(NullPointerException.class, //
                          () -> Sort.insertionSort(null), //
                          "Cannot read the array length because \"array\" is null");
    }

    @Test
    void insertionSort_emptyArrayLength0_arrayIsSorted() {
      final int[] testArray = new int[0];
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSort_initializedArrayLengthX_arrayIsSorted() {
      final int[] testArray = new int[10];
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSort_sortedArrayAkaBestCase_arrayIsSorted() {
      final int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSort_contains1Element_arrayIsSorted() {
      final int[] testArray = {10};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSort_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
      final int[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSort_unsortedArrayAkaAverageCase_arrayIsSorted() {
      final int[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void selectionSort_null_throwsNullPointerException() {
      assertThrowsExactly(NullPointerException.class, //
                          () -> Sort.selectionSort(null), //
                          "Cannot read the array length because \"array\" is null");
    }

    @Test
    void selectionSort_emptyArrayLength0_arrayIsSorted() {
      final int[] testArray = new int[0];
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.selectionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void selectionSort_initializedArrayLengthX_arrayIsSorted() {
      final int[] testArray = new int[10];
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.selectionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void selectionSort_sortedArrayAkaBestCase_arrayIsSorted() {
      final int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.selectionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void selectionSort_contains1Element_arrayIsSorted() {
      final int[] testArray = {10};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.selectionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void selectionSort_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
      final int[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.selectionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void selectionSort_unsortedArrayAkaAverageCase_arrayIsSorted() {
      final int[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.selectionSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void bubbleSort_null_throwsNullPointerException() {
      assertThrowsExactly(NullPointerException.class, //
                          () -> Sort.bubbleSort(null), //
                          "Cannot read the array length because \"array\" is null");
    }

    @Test
    void bubbleSort_emptyArrayLength0_arrayIsSorted() {
      final int[] testArray = new int[0];
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.bubbleSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void bubbleSort_initializedArrayLengthX_arrayIsSorted() {
      final int[] testArray = new int[10];
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.bubbleSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void bubbleSort_sortedArrayAkaBestCase_arrayIsSorted() {
      final int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.bubbleSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void bubbleSort_contains1Element_arrayIsSorted() {
      final int[] testArray = {10};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.bubbleSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void bubbleSort_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
      final int[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.bubbleSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void bubbleSort_unsortedArrayAkaAverageCase_arrayIsSorted() {
      final int[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.bubbleSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void bubbleSortBestCaseOptimized_null_throwsNullPointerException() {
      assertThrowsExactly(NullPointerException.class, //
                          () -> Sort.bubbleSortBestCaseOptimized(null), //
                          "Cannot read the array length because \"array\" is null");
    }

    @Test
    void bubbleSortBestCaseOptimized_emptyArrayLength0_arrayIsSorted() {
      final int[] testArray = new int[0];
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.bubbleSortBestCaseOptimized(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void bubbleSortBestCaseOptimized_initializedArrayLengthX_arrayIsSorted() {
      final int[] testArray = new int[10];
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.bubbleSortBestCaseOptimized(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void bubbleSortBestCaseOptimized_sortedArrayAkaBestCase_arrayIsSorted() {
      final int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.bubbleSortBestCaseOptimized(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void bubbleSortBestCaseOptimized_contains1Element_arrayIsSorted() {
      final int[] testArray = {10};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.bubbleSortBestCaseOptimized(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void bubbleSortBestCaseOptimized_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
      final int[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.bubbleSortBestCaseOptimized(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void bubbleSortBestCaseOptimized_unsortedArrayAkaAverageCase_arrayIsSorted() {
      final int[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.bubbleSortBestCaseOptimized(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void shellSort_null_throwsNullPointerException() {
      assertThrowsExactly(NullPointerException.class, //
                          () -> Sort.shellSort(null), //
                          "Cannot read the array length because \"array\" is null");
    }

    @Test
    void shellSort_emptyArrayLength0_arrayIsSorted() {
      final int[] testArray = new int[0];
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.shellSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void shellSort_initializedArrayLengthX_arrayIsSorted() {
      final int[] testArray = new int[10];
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.shellSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void shellSort_sortedArrayAkaBestCase_arrayIsSorted() {
      final int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.shellSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void shellSort_contains1Element_arrayIsSorted() {
      final int[] testArray = {10};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.shellSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void shellSort_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
      final int[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.shellSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void shellSort_unsortedArrayAkaAverageCase_arrayIsSorted() {
      final int[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
      final int[] arrayCopyForConvenience = testArray.clone();
      Sort.shellSort(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortComparable_null_throwsNullPointerException() {
      assertThrowsExactly(NullPointerException.class, //
                          () -> Sort.insertionSortComparable(null), //
                          "Cannot read the array length because \"array\" is null");
    }

    @Test
    void insertionSortComparable_differentTypesUsedInArray_throwsClassCastException() {
      final ClassCastException comparisonException = assertThrows(ClassCastException.class, //
                                                                  () -> Sort.insertionSortComparable(new Comparable[]{1, "Test"}));
      assertThat(comparisonException.getMessage()).contains("class").contains("cannot be cast to class");
    }

    @Test
    void insertionSortComparable_initializedWithNullArrayLengthX_throwsRuntimeException() {
      final String[] testArray = new String[10];
      assertThrows(RuntimeException.class, //
                   () -> Sort.insertionSortComparable(testArray));
    }

    @Test
    void insertionSortComparable_initializedWithNullsBeside1ItemArrayLengthX_throwsRuntimeException() {
      final String[] testArray = new String[10];
      testArray[5] = "hello";
      assertThrows(RuntimeException.class, //
                   () -> Sort.insertionSortComparable(testArray));
    }

    @Test
    void insertionSortComparable_initializedWithSomeValuesOnly_throwsRuntimeException() {
      final String[] testArray = new String[10];
      testArray[5] = "hello";
      testArray[7] = "hi";
      assertThrows(RuntimeException.class, //
                   () -> Sort.insertionSortComparable(testArray));
    }

    @Test
    void insertionSortComparable_emptyArrayLength0_arrayIsSorted() {
      final String[] testArray = new String[0];
      final String[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortComparable(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortComparable_sortedArrayAkaBestCase_arrayIsSorted() {
      final Integer[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortComparable(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortComparable_contains1Element_arrayIsSorted() {
      final Integer[] testArray = {10};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortComparable(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortComparable_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
      final Integer[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortComparable(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortComparable_unsortedArrayAkaAverageCase_arrayIsSorted() {
      final Integer[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortComparable(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortComparableNullSafe_null_throwsNullPointerException() {
      assertThrowsExactly(NullPointerException.class, //
                          () -> Sort.insertionSortComparableNullSafe(null), //
                          "Cannot read the array length because \"array\" is null");
    }

    @Test
    void insertionSortComparableNullSafe_differentTypesUsedInArray_throwsClassCastException() {
      final ClassCastException comparisonException = assertThrows(ClassCastException.class, //
                                                                  () -> Sort.insertionSortComparableNullSafe(new Comparable[]{1, "Test"}));
      assertThat(comparisonException.getMessage()).contains("class").contains("cannot be cast to class");
    }

    @Test
    void insertionSortComparableNullSafe_emptyArrayLength0_arrayIsSorted() {
      final String[] testArray = new String[0];
      final String[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortComparableNullSafe(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortComparableNullSafe_initializedWithNullArrayLengthX_insertionSortCanBeCalled() {
      final String[] testArray = new String[10];
      final String[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortComparableNullSafe(testArray);
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortComparableNullSafe_initializedWithNullsBeside1ItemArrayLengthX_itemFirstAndNullItemsAreAtTheEnd() {
      final String[] testArray = new String[10];
      testArray[5] = "hello";
      final String[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortComparableNullSafe(testArray);
      assertThat(testArray).isSortedAccordingTo(nullSafeStringComparator);
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortComparableNullSafe_initializedWithSomeValuesOnly_itemsSortedAndNullItemsAreAtTheEnd() {
      final String[] testArray = new String[10];
      testArray[5] = "hello";
      testArray[7] = "hi";
      final String[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortComparableNullSafe(testArray);
      assertThat(testArray).isSortedAccordingTo(nullSafeStringComparator);
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortComparableNullSafe_sortedArrayAkaBestCase_arrayIsSorted() {
      final Integer[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortComparableNullSafe(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortComparableNullSafe_contains1Element_arrayIsSorted() {
      final Integer[] testArray = {10};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortComparableNullSafe(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortComparableNullSafe_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
      final Integer[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortComparableNullSafe(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }

    @Test
    void insertionSortComparableNullSafe_unsortedArrayAkaAverageCase_arrayIsSorted() {
      final Integer[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
      final Integer[] arrayCopyForConvenience = testArray.clone();
      Sort.insertionSortComparableNullSafe(testArray);
      assertThat(testArray).isSorted();
      assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
    }
  }

  @Nested
  class PerformanceTest {
    private final static Logger LOG = LogManager.getLogger(PerformanceTest.class);

    final static int SMALL_ARRAY = 5_123;
    final static int MEDIUM_ARRAY = 10_246;
    final static int LARGE_ARRAY = 20_492;

    final static boolean MEASURE_SMALL_ARRAY = false;
    final static boolean MEASURE_MEDIUM_ARRAY = false;
    final static boolean MEASURE_LARGE_ARRAY = true;

    final static boolean MEASURE_BEST_CASE = true;
    final static boolean MEASURE_WORST_CASE = true;
    final static boolean MEASURE_AVERAGE_CASE = true;

    final static int RUNS = 100;

    @BeforeAll
    static void beforeAll() {
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

    @Nested
    class InsertionSort extends PerformanceTestCase {
      final static String ALGORITHM_NAME = "Sort::insertionSort(int[])";
      final static Consumer<int[]> ALGORITHM = Sort::insertionSort;

      private InsertionSort() {
        super(ALGORITHM_NAME, ALGORITHM);
      }
    }

    @Nested
    class SelectionSort extends PerformanceTestCase {
      final static String ALGORITHM_NAME = "Sort::selectionSort(int[])";
      final static Consumer<int[]> ALGORITHM = Sort::selectionSort;

      private SelectionSort() {
        super(ALGORITHM_NAME, ALGORITHM);
      }
    }

    // @Nested
    class BubbleSort extends PerformanceTestCase {
      final static String ALGORITHM_NAME = "Sort::bubbleSort(int[])";
      final static Consumer<int[]> ALGORITHM = Sort::bubbleSort;

      private BubbleSort() {
        super(ALGORITHM_NAME, ALGORITHM);
      }
    }

    // @Nested
    class BubbleSortBestCaseOptimized extends PerformanceTestCase {
      final static String ALGORITHM_NAME = "Sort::bubbleSortBestCaseOptimized(int[])";
      final static Consumer<int[]> ALGORITHM = Sort::bubbleSortBestCaseOptimized;

      private BubbleSortBestCaseOptimized() {
        super(ALGORITHM_NAME, ALGORITHM);
      }
    }

    @Nested
    class ShellSort extends PerformanceTestCase {
      final static String ALGORITHM_NAME = "Sort::shellSort(int[])";
      final static Consumer<int[]> ALGORITHM = Sort::shellSort;

      private ShellSort() {
        super(ALGORITHM_NAME, ALGORITHM);
      }
    }

    private static int[] setupMasterArrayBestCase(final int arraySize) {
      final int[] values = new int[arraySize];
      for (int i = 0; i < arraySize; i++) {
        values[i] = i;
      }
      return values;
    }

    private static int[] setupMasterArrayAverageCase(final int arraySize) {
      final int[] values = new int[arraySize];
      final Random random = new Random();
      for (int i = 0; i < arraySize; i++) {
        values[i] = random.nextInt();
      }
      return values;
    }

    private static int[] setupMasterArrayWorstCase(final int arraySize) {
      final int[] values = new int[arraySize];
      for (int i = 0, value = arraySize; i < arraySize; i++, value--) {
        values[i] = value;
      }
      return values;
    }

    private void measureRunTime(final Consumer<int[]> algorithm, //
                                final Function<Integer, int[]> arrayCreationFunction, final String algorithmName,
                                final String caseUsed) {
      long runTimeSmallArray = -1;
      long runTimeMediumArray = -1;
      long runTimeLargeArray = -1;

      if (MEASURE_SMALL_ARRAY) {
        runTimeSmallArray = measureRunTime(algorithm, arrayCreationFunction.apply(SMALL_ARRAY));
      }

      if (MEASURE_MEDIUM_ARRAY) {
        runTimeMediumArray = measureRunTime(algorithm, arrayCreationFunction.apply(MEDIUM_ARRAY));
      }

      if (MEASURE_LARGE_ARRAY) {
        runTimeLargeArray = measureRunTime(algorithm, arrayCreationFunction.apply(LARGE_ARRAY));
      }

      printResults(algorithmName, caseUsed, runTimeSmallArray, runTimeMediumArray, runTimeLargeArray);
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

    private void printResults(final String algorithm, final String caseUsed, //
                              final long runTimeSmallArray, final long runTimeMediumArray,
                              final long runTimeLargeArray) {
      LOG.info("Runtime Measures for:               " + algorithm);
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
      LOG.info("");
    }

    class PerformanceTestCase {
      final String ALGORITHM_NAME;
      final Consumer<int[]> ALGORITHM;

      public PerformanceTestCase(final String algorithmName, final Consumer<int[]> algorithm) {
        ALGORITHM_NAME = algorithmName;
        ALGORITHM = algorithm;
      }

      @Test
      void bestCase_aka_sorted() {
        if (MEASURE_BEST_CASE) {
          measureRunTime(ALGORITHM, PerformanceTest::setupMasterArrayBestCase, ALGORITHM_NAME, "bestCase");
        }
      }

      @Test
      void averageCase_aka_random() {
        if (MEASURE_AVERAGE_CASE) {
          measureRunTime(ALGORITHM, PerformanceTest::setupMasterArrayAverageCase, ALGORITHM_NAME, "random");
        }
      }

      @Test
      void worstCase_aka_reverseSorted() {
        if (MEASURE_WORST_CASE) {
          measureRunTime(ALGORITHM, PerformanceTest::setupMasterArrayWorstCase, ALGORITHM_NAME, "worstCase");
        }
      }
    }

    // @Nested
    class ComparableAlgorithms {

      @Nested
      class InsertionSortComparable extends PerformanceTestCaseComparable {
        final static String ALGORITHM_NAME = "Sort::insertionSortComparable(Comparable<E>[])";
        final static Consumer<Integer[]> ALGORITHM = Sort::insertionSortComparable;

        private InsertionSortComparable() {
          super(ALGORITHM_NAME, ALGORITHM);
        }
      }

      @Nested
      class InsertionSortComparableNullSafe extends PerformanceTestCaseComparable {
        final static String ALGORITHM_NAME = "Sort::insertionSortComparableNullSafe(Comparable<E>[])";
        final static Consumer<Integer[]> ALGORITHM = Sort::insertionSortComparableNullSafe;

        private InsertionSortComparableNullSafe() {
          super(ALGORITHM_NAME, ALGORITHM);
        }
      }

      class PerformanceTestCaseComparable {
        final String ALGORITHM_NAME;
        final Consumer<Integer[]> ALGORITHM;

        public PerformanceTestCaseComparable(final String algorithmName, final Consumer<Integer[]> algorithm) {
          ALGORITHM_NAME = algorithmName;
          ALGORITHM = algorithm;
        }

        @Test
        void bestCase_aka_sorted() {
          if (MEASURE_BEST_CASE) {
            measureRunTimeBoxed(ALGORITHM, ComparableAlgorithms::setupMasterArrayBestCaseBoxed, ALGORITHM_NAME,
                                "bestCase");
          }
        }

        @Test
        void averageCase_aka_random() {
          if (MEASURE_AVERAGE_CASE) {
            measureRunTimeBoxed(ALGORITHM, ComparableAlgorithms::setupMasterArrayAverageCaseBoxed, ALGORITHM_NAME,
                                "random");
          }
        }

        @Test
        void worstCase_aka_reverseSorted() {
          if (MEASURE_WORST_CASE) {
            measureRunTimeBoxed(ALGORITHM, ComparableAlgorithms::setupMasterArrayWorstCaseBoxed, ALGORITHM_NAME,
                                "worstCase");
          }
        }
      }

      private static Integer[] setupMasterArrayBestCaseBoxed(final int arraySize) {
        return Arrays.stream(PerformanceTest.setupMasterArrayBestCase(arraySize)).boxed().toArray(Integer[]::new);
      }

      private static Integer[] setupMasterArrayAverageCaseBoxed(final int arraySize) {
        return Arrays.stream(PerformanceTest.setupMasterArrayAverageCase(arraySize)).boxed().toArray(Integer[]::new);
      }

      private static Integer[] setupMasterArrayWorstCaseBoxed(final int arraySize) {
        return Arrays.stream(PerformanceTest.setupMasterArrayWorstCase(arraySize)).boxed().toArray(Integer[]::new);
      }

      private void measureRunTimeBoxed(final Consumer<Integer[]> algorithm, //
                                       final Function<Integer, Integer[]> arrayCreationFunction,
                                       final String algorithmName, final String caseUsed) {
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

        printResults(algorithmName, caseUsed, runTimeSmallArray, runTimeMediumArray, runTimeLargeArray);
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
  }
}
