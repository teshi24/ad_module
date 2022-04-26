package ch.hslu.ad.sw08;

import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;

public final class SortAlgorithms {

  private SortAlgorithms() {
  }

  /**
   * Sorts the given int array using insertion sort {@see
   * <a href="https://www.youtube.com/watch?v=JU767SDMDvA&ab_channel=MichaelSambol">explanation</a}
   *
   * @param array int[] to be sorted
   * @throws NullPointerException if {@param inputArray} is null
   */
  public static void insertionSort(final int[] array) {
    //insertionSort(array, 1);
    insertionSortOptimized(array);
  }

  private static void insertionSortOptimized(final int[] array) {
    // T ~ a
    if (array.length <= 0) {
      return;
    }
    int firstElement = array[0];
    int element;
    int iSortedArrayPart;

    // T ~ n * b
    for (int i = 2; i < array.length; i++) {
      element = array[i];

      array[0] = element;

      iSortedArrayPart = i; // array[0]..array[iSortedArrayPart - 1] is already sorted
      // Tb = 1; Ta ~ (i+1)/2 ~ n/2; Tw = n
      while (array[iSortedArrayPart - 1] > element) {
        array[iSortedArrayPart] = array[iSortedArrayPart - 1]; // shift element to the right
        iSortedArrayPart--; // go further left
      }
      array[iSortedArrayPart] = element; // insertElement
    }

    // T ~ n * d
    for (int i = 1; i < array.length; i++) {
      if (array[i] < firstElement) {
        array[i - 1] = array[i];
      } else {
        array[i - 1] = firstElement;
        return;
      }
    }
    // T ~ e
    array[array.length - 1] = firstElement;
  }
  // Tb ~ a + n * b + n * 1 * c + n * d
  //    ~ n + n + n
  //    ~ n
  //
  // Ta ~ a + n * b + n * n / 2 * c + n * d
  //    ~ n + n^2 + n
  //    ~ n^2
  //
  // Tw ~ a + n * b + n * n * c + n * d
  //    ~ n + n^2 + n
  //    ~ n^2

  static void insertionSortOptimizedWithBinarySearch(final int[] array) {
    if (array.length < 2) {
      return;
    }
    int element;
    int lastSortedIndex = 0;

    for (int i = 1; i < array.length; i++) {
      element = array[i];

      lastSortedIndex = i; // array[0]..array[lastSortedIndex - 1] is already sorted
      final int insertionPosition = findIndexUsingBinarySearch(array, element, 0, lastSortedIndex - 1) + 1;
      for (int iToBeShifted = lastSortedIndex; iToBeShifted > insertionPosition; iToBeShifted--) {
        array[iToBeShifted] = array[iToBeShifted - 1];
      }
      array[insertionPosition] = element; // insertElement
    }
  }

  private static void soutArray(final int[] array) {
    System.out.println(String.join(",", Arrays.stream(array).mapToObj(String::valueOf).toArray(String[]::new)));
  }

  static int findIndexUsingBinarySearch(int[] arr, int elementToBeFound, final int sortedStartIndex,
                                        int sortedEndIndex) {
    int start = sortedStartIndex;
    int end = sortedEndIndex;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid] == elementToBeFound) return mid;
      else if (arr[mid] < elementToBeFound) start = mid + 1;
      else end = mid - 1;
    }
    return end;
  }

  public static void selectionSort(final int[] array) {
    // T ~ n
    for (int iFirstUnsortedElement = 0; iFirstUnsortedElement < array.length; iFirstUnsortedElement++) {
      int smallestElement = MAX_VALUE;
      int iSmallestElement = -1;

      // T ~ n
      for (int i = iFirstUnsortedElement; i < array.length; i++) {
        final int currentElement = array[i];
        if (currentElement < smallestElement) {
          smallestElement = currentElement;
          iSmallestElement = i;
        }
      }

      array[iSmallestElement] = array[iFirstUnsortedElement];
      array[iFirstUnsortedElement] = smallestElement;
    }
  }
  // T ~ n * n ~ n^2

  public static void bubbleSort(final int[] array) {
    for (int iLastUnsortedElement = array.length - 1; iLastUnsortedElement > 0; iLastUnsortedElement--) {
      for (int i = 0; i < iLastUnsortedElement; i++) {
        final int firstElement = array[i];
        if (firstElement > array[i + 1]) {
          array[i] = array[i + 1];
          array[i + 1] = firstElement;
        }
      }
    }
  }

  /**
   * optimal für eine bereits sortierte liste
   * @param array
   */
  public static void bubbleSortBestCaseOptimized(final int[] array) {
    for (int iLastUnsortedElement = array.length - 1; iLastUnsortedElement > 0; iLastUnsortedElement--) {
      boolean exchangeMade = false;
      for (int i = 0; i < iLastUnsortedElement; i++) {
        final int firstElement = array[i];
        if (firstElement > array[i + 1]) {
          array[i] = array[i + 1];
          array[i + 1] = firstElement;
          exchangeMade = true;
        }
      }
      if (!exchangeMade) {
        return;
      }
    }
  }

  private static final int[] hibbardNrs = initializeHibbardNrs();

  private static int[] initializeHibbardNrs() {
    final int[] hibbardNrs = new int[31]; // hibbardNr nr 32 = 2147483647, biggest hibbardNr in int range
    hibbardNrs[0] = 1;
    for (int i = 1; i < hibbardNrs.length; i++) {
      hibbardNrs[i] = hibbardNrs[i - 1] * 2 + 1;
    }
    return hibbardNrs;
  }

  private static void insertionSort(final int[] array, final int stepSize) {
    if (array.length <= 0) {
      return;
    }
    int element;
    int iSortedArrayPart;

    for (int i = stepSize; i < array.length; i++) {
      element = array[i];

      iSortedArrayPart = i; // array[0]..array[iSortedArrayPart - 1] is already sorted
      while (iSortedArrayPart >= stepSize && array[iSortedArrayPart - stepSize] > element) {
        array[iSortedArrayPart] = array[iSortedArrayPart - stepSize]; // shift element to the right
        iSortedArrayPart -= stepSize; // go further left
      }
      array[iSortedArrayPart] = element; // insertElement
    }
  }

  /**
   * shellSort using HibbardFolge --> 2^k-1
   *
   * @param array
   */
  public static void shellSort(final int[] array) {
    if (array.length <= 0) {
      return;
    }

    int hibbardNrIndex = -1;
    for (int i = 0; i < SortAlgorithms.hibbardNrs.length; i++) {
      if (SortAlgorithms.hibbardNrs[i] >= array.length) {
        break;
      }
      hibbardNrIndex = i;
    }

    for (; hibbardNrIndex > -1; hibbardNrIndex--) {
      int hibbardNr = SortAlgorithms.hibbardNrs[hibbardNrIndex];
      insertionSort(array, hibbardNr);
    }
  }
}
