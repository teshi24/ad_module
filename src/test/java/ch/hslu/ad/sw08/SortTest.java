package ch.hslu.ad.sw08;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static ch.hslu.ad.exceptionHandling.ExceptionTestHelpers.assertThrowsExactly;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SortTest {

  private final Comparator<String> nullSafeStringComparator = (e1, e2) -> e2 == null ? -1 : e1.compareTo(e2);

  @Test
  void insertionSortIntArrayOnly_null_throwsNullPointerException() {
    assertThrowsExactly(NullPointerException.class, //
                        () -> Sort.insertionSortIntArrayOnly(null), //
                        "Cannot read the array length because \"inputArray\" is null");
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
                        "Cannot read the array length because \"inputArray\" is null");
  }

  @Test
  void insertionSort_differentTypesUsedInArray_throwsClassCastException() {
    final ClassCastException comparisonException = assertThrows(ClassCastException.class, //
                                                                () -> Sort.insertionSort(new Comparable[]{1, "Test"}));
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
                        "Cannot read the array length because \"inputArray\" is null");
  }

  @Test
  void insertionSortNullSafe_differentTypesUsedInArray_throwsClassCastException() {
    final ClassCastException comparisonException = assertThrows(ClassCastException.class, //
                                                                () -> Sort.insertionSortNullSafe(new Comparable[]{1,
                                                                                                                  "Test"}));
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
