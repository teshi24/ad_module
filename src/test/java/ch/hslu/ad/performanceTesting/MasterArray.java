package ch.hslu.ad.performanceTesting;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest.LARGE_ARRAY;
import static ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest.MEDIUM_ARRAY;
import static ch.hslu.ad.performanceTesting.AlgorithmPerformanceTest.SMALL_ARRAY;

public enum MasterArray {
  SORTED_SMALL("sorted", SMALL_ARRAY, TestArrays.setupMasterArraySorted(SMALL_ARRAY)), //
  SORTED_MEDIUM("sorted", MEDIUM_ARRAY, TestArrays.setupMasterArraySorted(MEDIUM_ARRAY)), //
  SORTED_LARGE("sorted", LARGE_ARRAY, TestArrays.setupMasterArraySorted(LARGE_ARRAY)),

  RANDOM_SMALL("random", SMALL_ARRAY, TestArrays.setupMasterArrayRandom(SMALL_ARRAY)), //
  RANDOM_MEDIUM("random", MEDIUM_ARRAY, TestArrays.setupMasterArrayRandom(MEDIUM_ARRAY)), //
  RANDOM_LARGE("random", LARGE_ARRAY, TestArrays.setupMasterArrayRandom(LARGE_ARRAY)),

  REVERSE_SORTED_SMALL("reverseSorted", SMALL_ARRAY, TestArrays.setupMasterArrayReverseSorted(SMALL_ARRAY)), //
  REVERSE_SORTED_MEDIUM("reverseSorted", MEDIUM_ARRAY, TestArrays.setupMasterArrayReverseSorted(MEDIUM_ARRAY)), //
  REVERSE_SORTED_LARGE("reverseSorted", LARGE_ARRAY, TestArrays.setupMasterArrayReverseSorted(LARGE_ARRAY));

  private final String type;
  private final int size;
  private final int[] masterArray;

  MasterArray(final String type, final int size, final int[] masterArray) {
    this.type = type;
    this.size = size;
    this.masterArray = masterArray;
  }

  public int[] getMasterArray() {
    return masterArray;
  }

  static Map<Integer, MasterArray> getArraysBySizeForType(final String type) {
    final Map<Integer, MasterArray> map = new HashMap<>();
    EnumSet.allOf(MasterArray.class).stream() //
           .filter(e -> e.type.equals(type)) //
           .forEach(e -> map.put(e.size, e));
    return map;
  }
}
