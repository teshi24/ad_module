package ch.hslu.ad.exceptionHandling;

import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class ExceptionTestHelpers {
  private ExceptionTestHelpers() {
  }

  public static void assertThrowsExactly(final Class<? extends Throwable> expectedType, final Executable executable,
                                         final String expectedMessage) {
    final Throwable comparisonException = assertThrows(expectedType, executable);
    assertEquals(expectedMessage, comparisonException.getMessage());
  }
}
