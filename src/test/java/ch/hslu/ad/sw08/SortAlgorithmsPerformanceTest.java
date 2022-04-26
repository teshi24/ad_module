package ch.hslu.ad.sw08;

import ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest;
import ch.hslu.ad.performanceTesting.PerformanceTestCasePrimitive;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestClassOrder;

import java.util.function.Consumer;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class SortAlgorithmsPerformanceTest extends AlgorithmPerformanceTest {

  final static String SORTED = "sorted";
  final static String RANDOM = "random";
  final static String REVERSE_SORTED = "reverseSorted";

  @Nested
  @Order(15)
  class InsertionSort extends PerformanceTestCasePrimitive {
    final static String ALGORITHM_NAME = "SortAlgorithms::insertionSort(int[])";
    final static Consumer<int[]> ALGORITHM = SortAlgorithms::insertionSort;

    private InsertionSort() {
      super(ALGORITHM_NAME, ALGORITHM, SORTED, RANDOM, REVERSE_SORTED);
    }
  }

  //@Nested
  @Order(15)
  class InsertionSortOptimized extends PerformanceTestCasePrimitive {
    final static String ALGORITHM_NAME = "SortAlgorithms::insertionSortOptimized(int[])";
    final static Consumer<int[]> ALGORITHM = SortAlgorithms::insertionSortOptimized;

    private InsertionSortOptimized() {
      super(ALGORITHM_NAME, ALGORITHM, SORTED, RANDOM, REVERSE_SORTED);
    }
  }

  @Nested
  @Order(10)
  class InsertionSortOptimizedWithBinarySearch extends PerformanceTestCasePrimitive {
    final static String ALGORITHM_NAME = "SortAlgorithms::insertionSortOptimizedWithBinarySearch(int[])";
    final static Consumer<int[]> ALGORITHM = SortAlgorithms::insertionSortOptimizedWithBinarySearch;

    private InsertionSortOptimizedWithBinarySearch() {
      super(ALGORITHM_NAME, ALGORITHM, SORTED, RANDOM, REVERSE_SORTED);
    }
  }

  @Nested
  @Order(0)
  class ShellSort extends PerformanceTestCasePrimitive {
    final static String ALGORITHM_NAME = "SortAlgorithms::shellSort(int[])";
    final static Consumer<int[]> ALGORITHM = SortAlgorithms::shellSort;

    private ShellSort() {
      super(ALGORITHM_NAME, ALGORITHM, SORTED, RANDOM, REVERSE_SORTED);
    }
  }

  @Nested
  @Order(40)
  class SelectionSort extends PerformanceTestCasePrimitive {
    final static String ALGORITHM_NAME = "SortAlgorithms::selectionSort(int[])";
    final static Consumer<int[]> ALGORITHM = SortAlgorithms::selectionSort;

    private SelectionSort() {
      super(ALGORITHM_NAME, ALGORITHM, SORTED, RANDOM, REVERSE_SORTED);
    }
  }

  @Nested
  @Order(50)
  class BubbleSort extends PerformanceTestCasePrimitive {
    final static String ALGORITHM_NAME = "SortAlgorithms::bubbleSort(int[])";
    final static Consumer<int[]> ALGORITHM = SortAlgorithms::bubbleSort;

    private BubbleSort() {
      super(ALGORITHM_NAME, ALGORITHM, SORTED, RANDOM, REVERSE_SORTED);
    }
  }

  //@Nested
  @Order(55)
  class BubbleSortBestCaseOptimized extends PerformanceTestCasePrimitive {
    final static String ALGORITHM_NAME = "SortAlgorithms::bubbleSortBestCaseOptimized(int[])";
    final static Consumer<int[]> ALGORITHM = SortAlgorithms::bubbleSortBestCaseOptimized;

    private BubbleSortBestCaseOptimized() {
      super(ALGORITHM_NAME, ALGORITHM, SORTED, RANDOM, REVERSE_SORTED);
    }
  }
}
