package ch.hslu.ad.sw01;

import org.junit.jupiter.api.Test;

import static ch.hslu.ad.sw01.SymmetricalNumbers.padLeftZeros;
import static org.assertj.core.api.Assertions.assertThat;

class SymmetricalNumbersTest {

  @Test
  void isNumberSymmetrical_testAllGivenNrs() {
    assertTrueNumberIsSymmetrical(242);
    assertTrueNumberIsSymmetrical(7);
    assertTrueNumberIsSymmetrical(1234321);
    assertFalseNumberIsSymmetrical(1234);
    assertTrueNumberIsSymmetrical(8227228);
    assertFalseNumberIsSymmetrical(8227227);
    assertTrueNumberIsSymmetrical(110, 4);
    assertTrueNumberIsSymmetrical(5555, 4);
    assertFalseNumberIsSymmetrical(242, 4);
  }

  @Test
  void isNumberSymmetrical_oneDigit_returnTrue() {
    final int n = 10;
    int i = 0;
    for (; i < n; i++) {
      assertTrueNumberIsSymmetrical(i);
    }
  }

  @Test
  void isNumberSymmetrical_twoDigitsSameNrs_returnTrue() {
    final int n = 10;
    int i = 1;
    for (; i < n; i++) {
      assertTrueNumberIsSymmetrical(i * 11);
    }
  }

  @Test
  void isNumberSymmetrical_twoDigitsDifferentNrs_returnFalse() {
    final int n = 100;
    int i = 10;
    for (; i < n; i++) {
      if (i % 11 != 0) {
        assertFalseNumberIsSymmetrical(i);
      }
    }
  }

  @Test
  void isNumberSymmetrical_threeDigitsSameNrs_returnTrue() {
    final int n = 10;
    int i = 1;
    for (; i < n; i++) {
      assertTrueNumberIsSymmetrical(i * 111);
    }
  }

  @Test
  void isNumberSymmetrical_fourDigitsSameNrs_returnTrue() {
    final int n = 10;
    int i = 1;
    for (; i < n; i++) {
      assertTrueNumberIsSymmetrical(i * 1111);
    }
  }

  @Test
  void isNumberSymmetrical_threeDigitsAllDifferentNrs_returnFalse() {
    final int n = 10;
    int i = 1;
    for (; i < n; i++) {
      assertFalseNumberIsSymmetrical((i * 300 + i * 20 + i) % 1000);
    }
  }

  @Test
  void isNumberSymmetrical_fourDigitsAllDifferentNrs_returnFalse() {
    final int n = 10;
    int i = 1;
    for (; i < n; i++) {
      assertFalseNumberIsSymmetrical((i * 400 + i * 300 + i * 20 + i) % 10000);
    }
  }

  @Test
  void isNumberSymmetrical_threeDigitsPalindromeNrsUsingDifferentDigits_returnTwo() {
    final int n = 10;
    int innerNr = 0;
    int outerNr = 1;
    for (; outerNr < n; outerNr++, innerNr = 1) {
      for (; innerNr < n; innerNr++) {
        assertTrueNumberIsSymmetrical((outerNr * 100 + innerNr * 10 + outerNr));
      }
    }
  }

  @Test
  void isNumberSymmetrical_iterateThroughAllNrsVisualOutput() {
    final int n = 9999;
    int i = 1;
    for (; i < n; i++) {
      System.out.print(i);
      if (SymmetricalNumbers.isNumberSymmetrical(i)) {
        System.out.print(" Palindrom Nr");
      }
      System.out.println();
    }
  }

  @Test
  void isNumberSymmetrical_withSpecificAmountOfDigits_iterateThroughAllNrsVisualOutput() {
    final int n = 9999;
    int i = 1;
    for (; i < n; i++) {
      System.out.print(padLeftZeros(i + "", 4));
      if (SymmetricalNumbers.isNumberSymmetrical(i, 4)) {
        System.out.print(" Palindrom Nr");
      }
      System.out.println();
    }
  }

  private void assertTrueNumberIsSymmetrical(final int nrToTest) {
    final boolean result = SymmetricalNumbers.isNumberSymmetrical(nrToTest);
    assertThat(result).withFailMessage("%d was not detected as symmetrical number", nrToTest).isTrue();
  }

  private void assertFalseNumberIsSymmetrical(final int nrToTest) {
    final boolean result = SymmetricalNumbers.isNumberSymmetrical(nrToTest);
    assertThat(result).withFailMessage("%d was misinterpreted as symmetrical number", nrToTest).isFalse();
  }

  private void assertTrueNumberIsSymmetrical(final int nrToTest, final int digits) {
    final boolean result = SymmetricalNumbers.isNumberSymmetrical(nrToTest, digits);
    assertThat(result).withFailMessage("%d was not detected as symmetrical number", nrToTest).isTrue();
  }

  private void assertFalseNumberIsSymmetrical(final int nrToTest, final int digits) {
    final boolean result = SymmetricalNumbers.isNumberSymmetrical(nrToTest, digits);
    assertThat(result).withFailMessage("%d was misinterpreted as symmetrical number", nrToTest).isFalse();
  }
}
