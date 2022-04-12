package ch.hslu.ad.sw04;

import ch.hslu.ad.exceptionHandling.DuplicateElementException;
import ch.hslu.ad.sw03.Tree;

/**
 * @param <T>
 */
public interface Set<T> {
  /**
   * Adds item to the {@link Set}.
   *
   * @param item item of type {@link T} to be added to the {@link Set}.
   * @throws NullPointerException      if {@param item} is null
   * @throws DuplicateElementException if {@param item} is already existing in the {@link Set};
   */
  void add(final T item) throws NullPointerException, DuplicateElementException;

  /**
   * removes item from the {@link Set}.
   *
   * @param item item of type {@link T} to be removed
   * @return true if element was removed
   * false if element was not found
   * @throws NullPointerException if {@param item} is null
   */
  boolean remove(final T item);

  /**
   * checks if item is in the {@link Set}.
   *
   * @param item item of {@link T} to be found
   * @return true if item is in collection, else false
   */
  boolean contains(final T item);

  /**
   * Determines size of the {@link Set}
   * @return size of {@link Set}/amount of elements in {@link Set}
   */
  int size();
}


