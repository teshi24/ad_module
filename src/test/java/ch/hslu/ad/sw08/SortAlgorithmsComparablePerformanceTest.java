package ch.hslu.ad.sw08;

import ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest;
import ch.hslu.ad.performanceTesting.PerformanceTestCaseComparable;
import ch.hslu.ad.performanceTesting.TestArrays;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestClassOrder;

import java.util.function.Consumer;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class SortAlgorithmsComparablePerformanceTest extends AlgorithmPerformanceTest {

  @Order(1)
  @Nested
  class InsertionSortComparable extends PerformanceTestCaseComparable {
    final static String ALGORITHM_NAME = "SortAlgorithmsComparable::insertionSort(Comparable<E>[])";
    final static Consumer<Integer[]> ALGORITHM = SortAlgorithmsComparable::insertionSort;

    private InsertionSortComparable() {
      super(ALGORITHM_NAME, ALGORITHM, //
            TestArrays::setupMasterArraySortedBoxed, //
            TestArrays::setupMasterArrayRandomBoxed, //
            TestArrays::setupMasterArrayReverseSortedBoxed);
    }
  }

  @Order(2)
  @Nested
  class InsertionSortComparableNullSafe extends PerformanceTestCaseComparable {
    final static String ALGORITHM_NAME = "SortAlgorithmsComparable::insertionSortNullSafe(Comparable<E>[])";
    final static Consumer<Integer[]> ALGORITHM = SortAlgorithmsComparable::insertionSortNullSafe;

    private InsertionSortComparableNullSafe() {
      super(ALGORITHM_NAME, ALGORITHM, //
            TestArrays::setupMasterArraySortedBoxed, //
            TestArrays::setupMasterArrayRandomBoxed, //
            TestArrays::setupMasterArrayReverseSortedBoxed);
    }
  }
}
