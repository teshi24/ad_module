package ch.hslu.ad.sw08;

import org.junit.jupiter.api.Test;

import static ch.hslu.ad.exceptionHandling.ExceptionTestHelpers.assertThrowsExactly;
import static org.assertj.core.api.Assertions.assertThat;

class SortAlgorithmsFunctionalityTest {

  @Test
  void insertionSort_null_throwsNullPointerException() {
    assertThrowsExactly(NullPointerException.class, //
                        () -> SortAlgorithms.insertionSort(null), //
                        "Cannot read the array length because \"array\" is null");
  }

  @Test
  void insertionSort_emptyArrayLength0_arrayIsSorted() {
    final int[] testArray = new int[0];
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.insertionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSort_initializedArrayLengthX_arrayIsSorted() {
    final int[] testArray = new int[10];
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.insertionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSort_sortedArrayAkaBestCase_arrayIsSorted() {
    final int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.insertionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSort_contains1Element_arrayIsSorted() {
    final int[] testArray = {10};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.insertionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSort_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
    final int[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.insertionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSort_unsortedArrayAkaAverageCase_arrayIsSorted() {
    final int[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.insertionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void findIndexUsingBinarySearch_elementToBeInsertedInMiddleOfArray_findsIndexForElementToBeInserted() {
    final int result = SortAlgorithms.findIndexUsingBinarySearch(new int[]{1, 2, 3, 5, 6, 7, 8, 9}, 4, 0, 7);
    assertThat(result).isEqualTo(2);
  }

  @Test
  void findIndexUsingBinarySearch_elementToBeInsertedAtStartOfArray_findsIndexForElementToBeInserted() {
    final int result = SortAlgorithms.findIndexUsingBinarySearch(new int[]{5, 6, 7, 8, 9}, 4, 0, 5);
    assertThat(result).isEqualTo(-1);
  }

  @Test
  void findIndexUsingBinarySearch_elementToBeInsertedAtEndOfSortedArray_findsIndexForElementToBeInserted() {
    final int result = SortAlgorithms.findIndexUsingBinarySearch(new int[]{1, 2, 3, 10, 9, 5, 6}, 4, 0, 3);
    assertThat(result).isEqualTo(2);
  }

  @Test
  void insertionSortOptimizedWithBinarySearch_null_throwsNullPointerException() {
    assertThrowsExactly(NullPointerException.class, //
                        () -> SortAlgorithms.insertionSortOptimizedWithBinarySearch(null), //
                        "Cannot read the array length because \"array\" is null");
  }

  @Test
  void insertionSortOptimizedWithBinarySearch_emptyArrayLength0_arrayIsSorted() {
    final int[] testArray = new int[0];
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.insertionSortOptimizedWithBinarySearch(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortOptimizedWithBinarySearch_initializedArrayLengthX_arrayIsSorted() {
    final int[] testArray = new int[10];
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.insertionSortOptimizedWithBinarySearch(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortOptimizedWithBinarySearch_sortedArrayAkaBestCase_arrayIsSorted() {
    final int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.insertionSortOptimizedWithBinarySearch(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortOptimizedWithBinarySearch_contains1Element_arrayIsSorted() {
    final int[] testArray = {10};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.insertionSortOptimizedWithBinarySearch(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortOptimizedWithBinarySearch_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
    final int[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.insertionSortOptimizedWithBinarySearch(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortOptimizedWithBinarySearch_unsortedArrayAkaAverageCase_arrayIsSorted() {
    final int[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.insertionSortOptimizedWithBinarySearch(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }
  
  @Test
  void selectionSort_null_throwsNullPointerException() {
    assertThrowsExactly(NullPointerException.class, //
                        () -> SortAlgorithms.selectionSort(null), //
                        "Cannot read the array length because \"array\" is null");
  }

  @Test
  void selectionSort_emptyArrayLength0_arrayIsSorted() {
    final int[] testArray = new int[0];
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.selectionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void selectionSort_initializedArrayLengthX_arrayIsSorted() {
    final int[] testArray = new int[10];
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.selectionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void selectionSort_sortedArrayAkaBestCase_arrayIsSorted() {
    final int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.selectionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void selectionSort_contains1Element_arrayIsSorted() {
    final int[] testArray = {10};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.selectionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void selectionSort_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
    final int[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.selectionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void selectionSort_unsortedArrayAkaAverageCase_arrayIsSorted() {
    final int[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.selectionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void bubbleSort_null_throwsNullPointerException() {
    assertThrowsExactly(NullPointerException.class, //
                        () -> SortAlgorithms.bubbleSort(null), //
                        "Cannot read the array length because \"array\" is null");
  }

  @Test
  void bubbleSort_emptyArrayLength0_arrayIsSorted() {
    final int[] testArray = new int[0];
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.bubbleSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void bubbleSort_initializedArrayLengthX_arrayIsSorted() {
    final int[] testArray = new int[10];
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.bubbleSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void bubbleSort_sortedArrayAkaBestCase_arrayIsSorted() {
    final int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.bubbleSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void bubbleSort_contains1Element_arrayIsSorted() {
    final int[] testArray = {10};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.bubbleSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void bubbleSort_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
    final int[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.bubbleSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void bubbleSort_unsortedArrayAkaAverageCase_arrayIsSorted() {
    final int[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.bubbleSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void bubbleSortBestCaseOptimized_null_throwsNullPointerException() {
    assertThrowsExactly(NullPointerException.class, //
                        () -> SortAlgorithms.bubbleSortBestCaseOptimized(null), //
                        "Cannot read the array length because \"array\" is null");
  }

  @Test
  void bubbleSortBestCaseOptimized_emptyArrayLength0_arrayIsSorted() {
    final int[] testArray = new int[0];
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.bubbleSortBestCaseOptimized(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void bubbleSortBestCaseOptimized_initializedArrayLengthX_arrayIsSorted() {
    final int[] testArray = new int[10];
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.bubbleSortBestCaseOptimized(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void bubbleSortBestCaseOptimized_sortedArrayAkaBestCase_arrayIsSorted() {
    final int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.bubbleSortBestCaseOptimized(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void bubbleSortBestCaseOptimized_contains1Element_arrayIsSorted() {
    final int[] testArray = {10};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.bubbleSortBestCaseOptimized(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void bubbleSortBestCaseOptimized_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
    final int[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.bubbleSortBestCaseOptimized(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void bubbleSortBestCaseOptimized_unsortedArrayAkaAverageCase_arrayIsSorted() {
    final int[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.bubbleSortBestCaseOptimized(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void shellSort_null_throwsNullPointerException() {
    assertThrowsExactly(NullPointerException.class, //
                        () -> SortAlgorithms.shellSort(null), //
                        "Cannot read the array length because \"array\" is null");
  }

  @Test
  void shellSort_emptyArrayLength0_arrayIsSorted() {
    final int[] testArray = new int[0];
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.shellSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void shellSort_initializedArrayLengthX_arrayIsSorted() {
    final int[] testArray = new int[10];
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.shellSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void shellSort_sortedArrayAkaBestCase_arrayIsSorted() {
    final int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.shellSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void shellSort_contains1Element_arrayIsSorted() {
    final int[] testArray = {10};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.shellSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void shellSort_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
    final int[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.shellSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void shellSort_unsortedArrayAkaAverageCase_arrayIsSorted() {
    final int[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
    final int[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithms.shellSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }
}
