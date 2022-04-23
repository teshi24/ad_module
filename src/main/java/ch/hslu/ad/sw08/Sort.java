package ch.hslu.ad.sw08;

import static java.lang.Integer.MAX_VALUE;

public class Sort {

  // todo: Einfügestelle mit binärer Suche suchen (A3 optional d)

  /**
   * Sorts the given int array using insertion sort {@see
   * <a href="https://www.youtube.com/watch?v=JU767SDMDvA&ab_channel=MichaelSambol">explanation</a}
   *
   * @param array int[] to be sorted
   * @throws NullPointerException if {@param inputArray} is null
   */
  public static void insertionSort(final int[] array) {
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

  /**
   * Sorts the given array using insertion sort {@see
   * <a href="https://www.youtube.com/watch?v=JU767SDMDvA&ab_channel=MichaelSambol">explanation</a}
   *
   * If the given array contains null elements, the algorithm moves the null elements to the back of the list.
   * For security reasons, use {@link #insertionSortComparableNullSafe(Comparable[])} if your array possibly contains
   * null
   * elements.
   *
   * @param array {@link Comparable}[] to be sorted
   * @throws NullPointerException if {@param inputArray} is null or if {@param inputArray} contains null elements
   * @throws ClassCastException   if {@param inputArray} contains items which are not comparable
   */
  // suppressing warnings as the possible warnings related to those issues are documented
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void insertionSortComparable(final Comparable[] array) {
    if (array.length <= 0) {
      return;
    }
    Comparable firstElement = array[0];
    Comparable element;
    int iSortedArrayPart;

    for (int i = 2; i < array.length; i++) {
      element = array[i];

      array[0] = element;

      iSortedArrayPart = i; // array[0]..array[iSortedArrayPart - 1] is already sorted
      while (array[iSortedArrayPart - 1].compareTo(element) > 0) {
        array[iSortedArrayPart] = array[iSortedArrayPart - 1]; // shift element to the right
        iSortedArrayPart--; // go further left
      }
      array[iSortedArrayPart] = element; // insertElement
    }

    for (int i = 1; i < array.length; i++) {
      if (array[i] != null && array[i].compareTo(firstElement) < 0) {
        array[i - 1] = array[i];
      } else {
        array[i - 1] = firstElement;
        return;
      }
    }

    array[array.length - 1] = firstElement;
  }

  /**
   * Sorts the given array using insertion sort {@see
   * <a href="https://www.youtube.com/watch?v=JU767SDMDvA&ab_channel=MichaelSambol">explanation</a}
   *
   * If the given array contains null elements, the algorithm moves the null elements to the back of the list.
   * For performance reasons, use {@link #insertionSortComparable(Comparable[])} if you are sure that your array
   * contains no
   * null elements.
   *
   * @param array {@link Comparable}[] to be sorted
   * @throws NullPointerException if {@param inputArray} is null
   * @throws ClassCastException   if {@param inputArray} contains items which are not comparable
   */
  // suppressing warnings as the possible warnings related to those issues are documented
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void insertionSortComparableNullSafe(final Comparable[] array) {
    if (array.length <= 0) {
      return;
    }
    Comparable firstElement = array[0];
    Comparable element;
    int iSortedArrayPart;

    for (int i = 2; i < array.length; i++) {
      element = array[i];

      if (element != null) {
        array[0] = element;

        iSortedArrayPart = i; // array[0]..array[iSortedArrayPart - 1] is already sorted
        while (array[iSortedArrayPart - 1] == null || array[iSortedArrayPart - 1].compareTo(element) > 0) {
          array[iSortedArrayPart] = array[iSortedArrayPart - 1]; // shift element to the right
          iSortedArrayPart--; // go further left
        }
        array[iSortedArrayPart] = element; // insertElement
      }
    }

    if (firstElement != null) {
      for (int i = 1; i < array.length; i++) {
        if (array[i] != null && array[i].compareTo(firstElement) < 0) {
          array[i - 1] = array[i];
        } else {
          array[i - 1] = firstElement;
          return;
        }
      }
    } else {
      int i = 1;
      for (; i < array.length; i++) {
        if (array[i] != null) {
          array[i - 1] = array[i];
        } else {
          array[i - 1] = null;
          return;
        }
      }
    }
    array[array.length - 1] = firstElement;
  }
}
