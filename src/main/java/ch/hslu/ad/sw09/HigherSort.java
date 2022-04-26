package ch.hslu.ad.sw09;

public class HigherSort {



  /**
   * Quicksort: Pivot = Trennelement
   *
   */
  public static void quickSort(final int[] array, final int leftSide, final int rightSide) {
    if (array.length < 2) {
      return;
    }
    int iSeparationElement = rightSide;


    int separationElement = array[iSeparationElement];



    exchange(array, iSeparationElement, rightSide);
    quickSort(array, leftSide, iSeparationElement - 1);
    quickSort(array,  iSeparationElement + 1, rightSide);
  }

  private static void exchange(final int[] array, final int firstIndex, final int secondIndex) {
    final int firstElement = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = firstElement;
  }
}
