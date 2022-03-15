package ch.hslu.ad.sw03.exceptionHandling;

public class DuplicateElementException extends IllegalArgumentException {

  /**
   * Constructs an {@code DuplicateElementException} with the
   * specified detail message.
   *
   * @param message the detail message.
   */
  public DuplicateElementException(String message) {
    super(message);
  }
}
