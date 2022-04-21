package ch.hslu.ad.sw08;

public class Sort {

  /**
   * Sorts the given int array using insertion sort {@see
   * <a href="https://www.youtube.com/watch?v=JU767SDMDvA&ab_channel=MichaelSambol">explanation</a}
   *
   * @param inputArray int[] to be sorted
   * @throws NullPointerException if {@param inputArray} is null
   */
  public static void insertionSortIntArrayOnly(final int[] inputArray) {
    int element;
    int iSortedArrayPart;

    int[] array = new int[inputArray.length + 1];
    System.arraycopy(inputArray, 0, array, 1, inputArray.length);

    for (int i = 2; i < array.length; i++) {
      element = array[i];

      array[0] = element;

      iSortedArrayPart = i; // array[0]..array[iSortedArrayPart - 1] is already sorted
      while (array[iSortedArrayPart - 1] > element) {
        array[iSortedArrayPart] = array[iSortedArrayPart - 1]; // shift element to the right
        iSortedArrayPart--; // go further left
      }
      array[iSortedArrayPart] = element; // insertElement
    }

    System.arraycopy(array, 1, inputArray, 0, inputArray.length);
  }

  /**
   * Sorts the given array using insertion sort {@see
   * <a href="https://www.youtube.com/watch?v=JU767SDMDvA&ab_channel=MichaelSambol">explanation</a}
   *
   * If the given array contains null elements, the algorithm moves the null elements to the back of the list.
   * For performance reasons, use {@link #insertionSort(Comparable[])} if you are sure that your array contains no
   * null elements.
   *
   * @param inputArray {@link Comparable}[] to be sorted
   * @throws NullPointerException if {@param inputArray} is null
   * @throws ClassCastException   if {@param inputArray} contains items which are not comparable
   */
  // suppressing warnings as the possible warnings related to those issues are documented
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void insertionSortNullSafe(final Comparable[] inputArray) {
    Comparable element;
    int iSortedArrayPart;

    Comparable[] array = new Comparable[inputArray.length + 1];
    System.arraycopy(inputArray, 0, array, 1, inputArray.length);

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

    System.arraycopy(array, 1, inputArray, 0, inputArray.length);
  }

  /**
   * Sorts the given array using insertion sort {@see
   * <a href="https://www.youtube.com/watch?v=JU767SDMDvA&ab_channel=MichaelSambol">explanation</a}
   *
   * If the given array contains null elements, the algorithm moves the null elements to the back of the list.
   * For security reasons, use {@link #insertionSortNullSafe(Comparable[])} if your array possibly contains null
   * elements.
   *
   * @param inputArray {@link Comparable}[] to be sorted
   * @throws NullPointerException if {@param inputArray} is null or if {@param inputArray} contains null elements
   * @throws ClassCastException   if {@param inputArray} contains items which are not comparable
   */
  // suppressing warnings as the possible warnings related to those issues are documented
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void insertionSort(final Comparable[] inputArray) {
    Comparable element;
    int iSortedArrayPart;

    Comparable[] array = new Comparable[inputArray.length + 1];
    System.arraycopy(inputArray, 0, array, 1, inputArray.length);

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

    System.arraycopy(array, 1, inputArray, 0, inputArray.length);
  }
}
