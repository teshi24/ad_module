package ch.hslu.ad.sw08;

import ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest;
import ch.hslu.ad.performanceTesting.PerformanceTestCasePrimitive;
import ch.hslu.ad.performanceTesting.TestArrays;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestClassOrder;

import java.util.function.Consumer;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class SortAlgorithmsPerformanceTest extends AlgorithmPerformanceTest {

  @Nested
  @Order(1)
  class InsertionSort extends PerformanceTestCasePrimitive {
    final static String ALGORITHM_NAME = "SortAlgorithms::insertionSort(int[])";
    final static Consumer<int[]> ALGORITHM = SortAlgorithms::insertionSort;

    private InsertionSort() {
      super(ALGORITHM_NAME, ALGORITHM, //
            TestArrays::setupMasterArraySorted, //
            TestArrays::setupMasterArrayRandom, //
            TestArrays::setupMasterArrayReverseSorted);
    }
  }

  @Nested
  @Order(2)
  class ShellSort extends PerformanceTestCasePrimitive {
    final static String ALGORITHM_NAME = "SortAlgorithms::shellSort(int[])";
    final static Consumer<int[]> ALGORITHM = SortAlgorithms::shellSort;

    private ShellSort() {
      super(ALGORITHM_NAME, ALGORITHM, //
            TestArrays::setupMasterArraySorted, //
            TestArrays::setupMasterArrayRandom, //
            TestArrays::setupMasterArrayReverseSorted);
    }
  }

  @Nested
  @Order(3)
  class SelectionSort extends PerformanceTestCasePrimitive {
    final static String ALGORITHM_NAME = "SortAlgorithms::selectionSort(int[])";
    final static Consumer<int[]> ALGORITHM = SortAlgorithms::selectionSort;

    private SelectionSort() {
      super(ALGORITHM_NAME, ALGORITHM, //
            TestArrays::setupMasterArraySorted, //
            TestArrays::setupMasterArrayRandom, //
            TestArrays::setupMasterArrayReverseSorted);
    }
  }

  @Nested
  @Order(4)
  class BubbleSort extends PerformanceTestCasePrimitive {
    final static String ALGORITHM_NAME = "SortAlgorithms::bubbleSort(int[])";
    final static Consumer<int[]> ALGORITHM = SortAlgorithms::bubbleSort;

    private BubbleSort() {
      super(ALGORITHM_NAME, ALGORITHM, //
            TestArrays::setupMasterArraySorted, //
            TestArrays::setupMasterArrayRandom, //
            TestArrays::setupMasterArrayReverseSorted);
    }
  }

  // @Nested
  @Order(5)
  class BubbleSortBestCaseOptimized extends PerformanceTestCasePrimitive {
    final static String ALGORITHM_NAME = "SortAlgorithms::bubbleSortBestCaseOptimized(int[])";
    final static Consumer<int[]> ALGORITHM = SortAlgorithms::bubbleSortBestCaseOptimized;

    private BubbleSortBestCaseOptimized() {
      super(ALGORITHM_NAME, ALGORITHM, //
            TestArrays::setupMasterArraySorted, //
            TestArrays::setupMasterArrayRandom, //
            TestArrays::setupMasterArrayReverseSorted);
    }
  }
}
