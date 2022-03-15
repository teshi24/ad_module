package ch.hslu.ad.sw03;

import ch.hslu.ad.sw03.exceptionHandling.DuplicateElementException;

public interface Tree<E> {

  /**
   * Adds data to the {@link Tree}.
   *
   * @param data object of type {@link E} to be added to the {@link Tree}
   * @throws NullPointerException      when {@param data} is null
   * @throws DuplicateElementException when {@param data} is already existing in the {@link Tree}
   */
  void add(final E data) throws NullPointerException, DuplicateElementException;

  /**
   * Removes data from the {@link Tree}.
   *
   * @param data object of type {@link E} to be removed from the {@link Tree}
   */
  void remove(final E data);

  /**
   * To check if data is available in the {@link Tree}.
   *
   * @param data object of type {@link E} to be found in {@link Tree}
   */
  boolean contains(final E data);

  /**
   * Balances the {@link Tree} to optimize the performance for search queries.
   */
  void balance();
}
