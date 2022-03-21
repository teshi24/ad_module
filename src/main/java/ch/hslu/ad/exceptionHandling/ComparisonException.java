package ch.hslu.ad.exceptionHandling;

public class ComparisonException extends IllegalArgumentException {

  static String getComparisonErrorMessage(final int baseValue, final String baseValueName, final int comparisonValue,
                                          final String comparisonValueName, final String expectedComparison) {
    final String MESSAGE_TEMPLATE_COMPARISON_ERROR = "%2$s must be %5$s %4$s. " + //
                                                     "Provided values: %2$s='%1$d' %4$s='%3$d'.";
    return String.format(MESSAGE_TEMPLATE_COMPARISON_ERROR, //
                         baseValue, baseValueName, comparisonValue, comparisonValueName, expectedComparison);
  }

  /**
   * Constructs an {@link ComparisonException} with the
   * specified detail message.
   */
  public ComparisonException(final int baseValue, final String baseValueName, final int comparisonValue,
                             final String comparisonValueName, final String expectedComparison) {
    super(getComparisonErrorMessage(baseValue, baseValueName, comparisonValue, comparisonValueName,
                                    expectedComparison));
  }
}
