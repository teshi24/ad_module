package ch.hslu.ad.sw08;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static ch.hslu.ad.exceptionHandling.ExceptionTestHelpers.assertThrowsExactly;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SortAlgorithmsComparableFunctionalityTest {

  private final Comparator<String> nullSafeStringComparator = (e1, e2) -> e2 == null ? -1 : e1.compareTo(e2);

  @Test
  void insertionSortComparable_null_throwsNullPointerException() {
    assertThrowsExactly(NullPointerException.class, //
                        () -> SortAlgorithmsComparable.insertionSort(null), //
                        "Cannot read the array length because \"array\" is null");
  }

  @Test
  void insertionSortComparable_differentTypesUsedInArray_throwsClassCastException() {
    final ClassCastException comparisonException = assertThrows(ClassCastException.class, //
                                                                () -> SortAlgorithmsComparable.insertionSort(new Comparable[]{1, "Test"}));
    assertThat(comparisonException.getMessage()).contains("class").contains("cannot be cast to class");
  }

  @Test
  void insertionSortComparable_initializedWithNullArrayLengthX_throwsRuntimeException() {
    final String[] testArray = new String[10];
    assertThrows(RuntimeException.class, //
                 () -> SortAlgorithmsComparable.insertionSort(testArray));
  }

  @Test
  void insertionSortComparable_initializedWithNullsBeside1ItemArrayLengthX_throwsRuntimeException() {
    final String[] testArray = new String[10];
    testArray[5] = "hello";
    assertThrows(RuntimeException.class, //
                 () -> SortAlgorithmsComparable.insertionSort(testArray));
  }

  @Test
  void insertionSortComparable_initializedWithSomeValuesOnly_throwsRuntimeException() {
    final String[] testArray = new String[10];
    testArray[5] = "hello";
    testArray[7] = "hi";
    assertThrows(RuntimeException.class, //
                 () -> SortAlgorithmsComparable.insertionSort(testArray));
  }

  @Test
  void insertionSortComparable_emptyArrayLength0_arrayIsSorted() {
    final String[] testArray = new String[0];
    final String[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithmsComparable.insertionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortComparable_sortedArrayAkaBestCase_arrayIsSorted() {
    final Integer[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final Integer[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithmsComparable.insertionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortComparable_contains1Element_arrayIsSorted() {
    final Integer[] testArray = {10};
    final Integer[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithmsComparable.insertionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortComparable_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
    final Integer[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    final Integer[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithmsComparable.insertionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortComparable_unsortedArrayAkaAverageCase_arrayIsSorted() {
    final Integer[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
    final Integer[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithmsComparable.insertionSort(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortComparableNullSafe_null_throwsNullPointerException() {
    assertThrowsExactly(NullPointerException.class, //
                        () -> SortAlgorithmsComparable.insertionSortNullSafe(null), //
                        "Cannot read the array length because \"array\" is null");
  }

  @Test
  void insertionSortComparableNullSafe_differentTypesUsedInArray_throwsClassCastException() {
    final ClassCastException comparisonException = assertThrows(ClassCastException.class, //
                                                                () -> SortAlgorithmsComparable.insertionSortNullSafe(new Comparable[]{1, "Test"}));
    assertThat(comparisonException.getMessage()).contains("class").contains("cannot be cast to class");
  }

  @Test
  void insertionSortComparableNullSafe_emptyArrayLength0_arrayIsSorted() {
    final String[] testArray = new String[0];
    final String[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithmsComparable.insertionSortNullSafe(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortComparableNullSafe_initializedWithNullArrayLengthX_insertionSortCanBeCalled() {
    final String[] testArray = new String[10];
    final String[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithmsComparable.insertionSortNullSafe(testArray);
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortComparableNullSafe_initializedWithNullsBeside1ItemArrayLengthX_itemFirstAndNullItemsAreAtTheEnd() {
    final String[] testArray = new String[10];
    testArray[5] = "hello";
    final String[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithmsComparable.insertionSortNullSafe(testArray);
    assertThat(testArray).isSortedAccordingTo(nullSafeStringComparator);
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortComparableNullSafe_initializedWithSomeValuesOnly_itemsSortedAndNullItemsAreAtTheEnd() {
    final String[] testArray = new String[10];
    testArray[5] = "hello";
    testArray[7] = "hi";
    final String[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithmsComparable.insertionSortNullSafe(testArray);
    assertThat(testArray).isSortedAccordingTo(nullSafeStringComparator);
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortComparableNullSafe_sortedArrayAkaBestCase_arrayIsSorted() {
    final Integer[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final Integer[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithmsComparable.insertionSortNullSafe(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortComparableNullSafe_contains1Element_arrayIsSorted() {
    final Integer[] testArray = {10};
    final Integer[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithmsComparable.insertionSortNullSafe(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortComparableNullSafe_reverseSortedArrayAkaWorstCase_arrayIsSorted() {
    final Integer[] testArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    final Integer[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithmsComparable.insertionSortNullSafe(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }

  @Test
  void insertionSortComparableNullSafe_unsortedArrayAkaAverageCase_arrayIsSorted() {
    final Integer[] testArray = {8, 10, 3, 5, 6, 4, 7, 9, 1};
    final Integer[] arrayCopyForConvenience = testArray.clone();
    SortAlgorithmsComparable.insertionSortNullSafe(testArray);
    assertThat(testArray).isSorted();
    assertThat(testArray).containsExactlyInAnyOrder(arrayCopyForConvenience);
  }
}
