package ch.hslu.ad.sw02;

import java.util.NoSuchElementException;

public interface Stack {

  /**
   * Adds a {@link String} on top of the {@link Stack}.
   *
   * @param string A {@link String} which will be added to the {@link Stack}
   * @throws StackOverflowError if the stack is already full
   */
  void push(String string) throws StackOverflowError;

  /**
   * Removes the {@link String} on top of the {@link Stack} and return it.
   *
   * @return the removed {@link String}
   * @throws NoSuchElementException if the stack is already empty
   */
  String pop() throws NoSuchElementException;

  /**
   * Indicates whether the {@link Stack} is empty.
   *
   * @return true if the {@link Stack} contains no elements, otherwise returns false
   */
  boolean isEmpty();

  /**
   * Indicates whether the {@link Stack} is full
   *
   * @return true if the {@link Stack} contains the max amount of elements {@link Stack#size()}, otherwise returns false
   */
  boolean isFull();

  /**
   * Indicates the size of the {@link Stack}
   *
   * @return max amount of elements which can be added to the {@link Stack}
   */
  int size();

  /**
   * Indicates the amount of used places of the {@link Stack}
   *
   * @return amount of elements which are in the {@link Stack}
   */
  int getAmountOfUsedPlaces();
}
