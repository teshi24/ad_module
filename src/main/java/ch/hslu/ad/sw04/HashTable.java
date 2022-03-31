package ch.hslu.ad.sw04;

import ch.hslu.ad.exceptionHandling.DuplicateElementException;

/**
 * @param <T>
 */
public interface HashTable<T> {
  /**
   * Adds item to the {@link HashTable}.
   *
   * @param item item of type {@link T} to be added to the {@link HashTable}.
   * @throws NullPointerException      if {@param item} is null
   * @throws DuplicateElementException if {@param item} is already existing in the {@link HashTable};
   */
  void add(final T item) throws NullPointerException, DuplicateElementException;

  /**
   * removes item from the {@link HashTable}.
   *
   * @param item item of type {@link T} to be removed
   * @return true if element was removed
   * false if element was not found
   * @throws NullPointerException if {@param item} is null
   */
  boolean remove(final T item);

  /**
   * checks if item is in the {@link HashTable}.
   *
   * @param item item of {@type T} to be found
   * @return true if item is in collection, else false
   */
  boolean contains(final T item);
}

public class HashSet implements HashTable<Object> {
  Thread
}
