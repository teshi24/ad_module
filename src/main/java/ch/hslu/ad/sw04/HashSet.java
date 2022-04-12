package ch.hslu.ad.sw04;

import ch.hslu.ad.exceptionHandling.DuplicateElementException;

import java.util.Arrays;

public class HashSet implements Set<Integer> {
  private static final int MAX_CAPACITY = 10;
  private final Integer[] values;
  private int size;

  public HashSet() {
    values = new Integer[MAX_CAPACITY];
    size = 0;
  }

  @Override
  public void add(final Integer item) throws NullPointerException, DuplicateElementException {
    ++size;
    values[item.hashCode()] = item;
  }

  @Override
  public boolean remove(final Integer item) {
    // todo: implement functionality
    throw new UnsupportedOperationException("functionality not yet implemented");
  }

  @Override
  public boolean contains(final Integer item) {
    if (size <= 0) {
      return false;
    }

    final Integer value = values[item.hashCode()];
    if (value == null) {
      return false;
    }
    return value.equals(item);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public String toString() {
    return "HashSet[" + "size=" + size + ", values=" + Arrays.toString(values) + ']';
  }
}
