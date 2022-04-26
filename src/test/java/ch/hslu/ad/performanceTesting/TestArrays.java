package ch.hslu.ad.performanceTesting;

import java.util.Arrays;
import java.util.Random;

public final class TestArrays {
  private TestArrays() {
  }

  public static int[] setupMasterArraySorted(final int arraySize) {
    final int[] values = new int[arraySize];
    for (int i = 0; i < arraySize; i++) {
      values[i] = i;
    }
    return values;
  }

  public static Integer[] setupMasterArraySortedBoxed(final int arraySize) {
    return Arrays.stream(setupMasterArraySorted(arraySize)).boxed().toArray(Integer[]::new);
  }

  public static int[] setupMasterArrayRandom(final int arraySize) {
    final int[] values = new int[arraySize];
    final Random random = new Random();
    for (int i = 0; i < arraySize; i++) {
      values[i] = random.nextInt();
    }
    return values;
  }

  public static Integer[] setupMasterArrayRandomBoxed(final int arraySize) {
    return Arrays.stream(setupMasterArrayRandom(arraySize)).boxed().toArray(Integer[]::new);
  }

  public static int[] setupMasterArrayReverseSorted(final int arraySize) {
    final int[] values = new int[arraySize];
    for (int i = 0, value = arraySize; i < arraySize; i++, value--) {
      values[i] = value;
    }
    return values;
  }

  public static Integer[] setupMasterArrayReverseSortedBoxed(final int arraySize) {
    return Arrays.stream(setupMasterArrayReverseSorted(arraySize)).boxed().toArray(Integer[]::new);
  }
}
