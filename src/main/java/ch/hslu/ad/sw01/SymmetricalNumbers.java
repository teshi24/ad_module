package ch.hslu.ad.sw01;

public class SymmetricalNumbers {

  public static boolean isNumberSymmetrical(final int number, final int digits) {
    if (digits < 0) {
      throw new IllegalArgumentException();
    }
    final String numberAsString = number + "";
    if (numberAsString.length() <= digits) {
      return isNumberSymmetrical(padLeftZeros(numberAsString, digits));
    }
    throw new IllegalArgumentException();
  }

  static String padLeftZeros(final String inputString, final int length) {
    return String.format("%1$" + length + "s", inputString).replace(' ', '0');
  }

  public static boolean isNumberSymmetrical(final int number) {
    return isNumberSymmetrical(number + "");
  }

  private static boolean isNumberSymmetrical(final String number) {
    final char[] numberAsCharArray = number.toCharArray();

    int countFromStart = 0;
    int countFromEnd = numberAsCharArray.length - 1;

    for (; countFromStart < countFromEnd; countFromStart++, countFromEnd--) {
      if (numberAsCharArray[countFromStart] != numberAsCharArray[countFromEnd]) {
        return false;
      }
    }
    return true;
  }
}
