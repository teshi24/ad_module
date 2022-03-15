package ch.hslu.ad.sw03;

import ch.hslu.ad.sw03.exceptionHandling.ComparisonException;

final class BinaryTreeKnot implements Comparable<BinaryTreeKnot> {
  private final Integer data;
  private BinaryTreeKnot leftChild;
  private BinaryTreeKnot rightChild;

  /**
   * New knot of the {@link BinaryTree}
   *
   * @param data       value
   * @param leftChild  smaller value than {@param data} or null
   * @param rightChild bigger value than {@param data} or null
   * @throws NullPointerException     if data is null
   * @throws IllegalArgumentException if {@param leftChild} has bigger value than {@param data}
   *                                  if {@param rightChild} has smaller value than {@param data}
   */
  BinaryTreeKnot(final Integer data, final BinaryTreeKnot leftChild, final BinaryTreeKnot rightChild) throws NullPointerException, //
                                                                                                             IllegalArgumentException {
    if (data == null) {
      throw new NullPointerException("Data must not be null.");
    }
    this.data = data;
    setLeftChild(leftChild);
    setRightChild(rightChild);
  }

  boolean hasLeftChild() {
    return leftChild != null;
  }

  boolean hasRightChild() {
    return rightChild != null;
  }

  @Override
  public int compareTo(final BinaryTreeKnot knot) throws NullPointerException {
    if (knot == null) {
      throw new NullPointerException("Knot must not be null.");
    }
    if (this == knot) {
      return 0;
    }
    return data.compareTo(knot.data);
  }

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }
    if (object instanceof BinaryTreeKnot knot) {
      return data.equals(knot.data);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return data;
  }

  @Override
  public String toString() {
    return "BinaryTreeKnot[" + "data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + ']';
  }

  Integer getData() {
    return data;
  }

  BinaryTreeKnot getLeftChild() {
    return leftChild;
  }

  void setLeftChild(final BinaryTreeKnot leftChild) {
    if (leftChild != null && leftChild.compareTo(this) >= 0) {
      throw new ComparisonException(leftChild.data, "leftChild.data", data, "data", "smaller than");
    }
    this.leftChild = leftChild;
  }

  BinaryTreeKnot getRightChild() {
    return rightChild;
  }

  void setRightChild(final BinaryTreeKnot rightChild) {
    if (rightChild != null && rightChild.compareTo(this) <= 0) {
      throw new ComparisonException(rightChild.data, "rightChild.data", data, "data", "bigger than");
    }

    this.rightChild = rightChild;
  }
}
