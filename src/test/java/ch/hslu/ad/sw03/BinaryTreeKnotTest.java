package ch.hslu.ad.sw03;

import ch.hslu.ad.sw03.exceptionHandling.ComparisonException;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static ch.hslu.ad.exceptionHandling.ExceptionTestHelpers.assertThrowsExactly;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryTreeKnotTest {
  final int middleValue = 5;
  final int smallValue = 1;
  final int bigValue = 9;
  final BinaryTreeKnot validRootNoChildren = new BinaryTreeKnot(middleValue, null, null);
  final BinaryTreeKnot validLeftChild = new BinaryTreeKnot(smallValue, null, null);
  final BinaryTreeKnot validRightChild = new BinaryTreeKnot(bigValue, null, null);
  final BinaryTreeKnot validRootWithChildren = new BinaryTreeKnot(middleValue, validLeftChild, validRightChild);

  @Test
  void hasLeftChild_noLeftChild_false() {
    assertFalse(validRootNoChildren.hasLeftChild());
  }

  @Test
  void hasLeftChild_withLeftChild_true() {
    assertTrue(validRootWithChildren.hasLeftChild());
  }

  @Test
  void hasRightChild_noRightChild_false() {
    assertFalse(validRootNoChildren.hasRightChild());
  }

  @Test
  void hasRightChild_withRightChild_true() {
    assertTrue(validRootWithChildren.hasRightChild());
  }

  @Test
  void setLeftChild_hadNoLeftChildSetToNull_leftChildIsNull() {
    assertNull(validRootNoChildren.getLeftChild());
    validRootNoChildren.setLeftChild(null);
    assertNull(validRootNoChildren.getLeftChild());
  }

  @Test
  void setLeftChild_hadLeftChildSetToNull_leftChildIsNull() {
    assertNotNull(validRootWithChildren.getLeftChild());
    validRootWithChildren.setLeftChild(null);
    assertNull(validRootWithChildren.getLeftChild());
  }

  @Test
  void setLeftChild_setSameNodeAsLeftChild_throwsComparisonException() {
    final BinaryTreeKnot initializedLeftChild = validRootWithChildren.getLeftChild();
    assertThrowsExactly(ComparisonException.class, //
                        () -> validRootWithChildren.setLeftChild(validRootWithChildren), //
                        "leftChild.data must be smaller than data. Provided values: leftChild.data='5' data='5'.");
    assertEquals(initializedLeftChild, validRootWithChildren.getLeftChild());
  }

  @Test
  void setLeftChild_setBiggerNodeAsLeftChild_throwsComparisonException() {
    final BinaryTreeKnot initializedLeftChild = validRootWithChildren.getLeftChild();
    assertThrowsExactly(ComparisonException.class, //
                        () -> validRootWithChildren.setLeftChild(validRightChild), //
                        "leftChild.data must be smaller than data. Provided values: leftChild.data='9' data='5'.");
    assertEquals(initializedLeftChild, validRootWithChildren.getLeftChild());
  }

  @Test
  void setLeftChild_setSmallerNodeAsLeftChild_overwriteLeftChild() {
    final BinaryTreeKnot newLeftChild = new BinaryTreeKnot(smallValue - 1, null, null);
    validRootWithChildren.setLeftChild(newLeftChild);
    assertEquals(newLeftChild, validRootWithChildren.getLeftChild());
  }

  @Test
  void setRightChild_hadNoRightChildSetToNull_rightChildIsNull() {
    assertNull(validRootNoChildren.getRightChild());
    validRootNoChildren.setRightChild(null);
    assertNull(validRootNoChildren.getRightChild());
  }

  @Test
  void setRightChild_hadRightChildSetToNull_rightChildIsNull() {
    assertNotNull(validRootWithChildren.getRightChild());
    validRootWithChildren.setRightChild(null);
    assertNull(validRootWithChildren.getRightChild());
  }

  @Test
  void setRightChild_setSameNodeAsRightChild_throwsComparisonException() {
    final BinaryTreeKnot initializedRightChild = validRootWithChildren.getRightChild();
    assertThrowsExactly(ComparisonException.class, //
                        () -> validRootWithChildren.setRightChild(validRootWithChildren), //
                        "rightChild.data must be bigger than data. Provided values: rightChild.data='5' data='5'.");
    assertEquals(initializedRightChild, validRootWithChildren.getRightChild());
  }

  @Test
  void setRightChild_setSmallerNodeAsRightChild_throwsComparisonException() {
    final BinaryTreeKnot initializedRightChild = validRootWithChildren.getRightChild();
    assertThrowsExactly(ComparisonException.class, //
                        () -> validRootWithChildren.setRightChild(validLeftChild), //
                        "rightChild.data must be bigger than data. Provided values: rightChild.data='1' data='5'.");

    assertEquals(initializedRightChild, validRootWithChildren.getRightChild());
  }

  @Test
  void setRightChild_setBiggerNodeAsRightChild_overwriteRightChild() {
    final BinaryTreeKnot newRightChild = new BinaryTreeKnot(bigValue + 1, null, null);
    validRootWithChildren.setRightChild(newRightChild);
    assertEquals(newRightChild, validRootWithChildren.getRightChild());
  }

  @Test
  void compareTo_sameObject_0() {
    assertThat(validRootNoChildren.compareTo(validRootNoChildren)).isZero();
  }

  @Test
  void compareTo_differentObjectsWithSameValues_0() {
    assertThat(validRootNoChildren.compareTo(new BinaryTreeKnot(middleValue, null, null))).isZero();
  }

  @Test
  void compareTo_differentObjectsWithSameDataValueButOtherValuesDifferent_0() {
    assertThat(validRootNoChildren.compareTo(validRootWithChildren)).isZero();
  }

  @Test
  void compareTo_biggerDataValue_minus1() {
    assertThat(validRootNoChildren.compareTo(validRightChild)).isEqualTo(-1);
    assertThat(validRootWithChildren.compareTo(validRightChild)).isEqualTo(-1);
  }

  @Test
  void compareTo_smallerDataValue_1() {
    assertThat(validRootNoChildren.compareTo(validLeftChild)).isOne();
    assertThat(validRootWithChildren.compareTo(validLeftChild)).isOne();
  }

  @Test
  void equalContract() {
    EqualsVerifier.forClass(BinaryTreeKnot.class);
  }

  @Test
  void testToString() {
    assertThat(validRootWithChildren.toString()).startsWith("BinaryTreeKnot[") //
                                                .contains("data=" + validRootWithChildren.getData()) //
                                                .contains("leftChild=" + validRootWithChildren.getLeftChild()) //
                                                .contains("rightChild=" + validRootWithChildren.getRightChild()) //
                                                .endsWith("]");
  }
}