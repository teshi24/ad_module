package ch.hslu.ad.sw03;

import ch.hslu.ad.exceptionHandling.DuplicateElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class BinaryTree implements Tree<Integer> {
  private static final Logger LOG = LogManager.getLogger(BinaryTree.class);

  private BinaryTreeKnot root;

  private int size;

  BinaryTree() {
    root = null;
    size = 0;
  }

  @Override
  public void add(final Integer data) throws NullPointerException, DuplicateElementException {
    if (data == null) {
      throw new NullPointerException("data must not be null");
    }

    addKnotAtCorrectPosition(new BinaryTreeKnot(data, null, null));
  }

  @Override
  public boolean remove(final Integer data) {
    if (data == null) {
      throw new NullPointerException("data must not be null");
    }

    final BinaryTreeKnot parentKnotOfData = internalSearchForParent(data);
    if (parentKnotOfData == null) {
      return false;
    }

    if (data < parentKnotOfData.getData()) {
      final BinaryTreeKnot leftChild = parentKnotOfData.getLeftChild();
      if (data.equals(leftChild.getData())) {
        if (!leftChild.hasLeftChild() && !leftChild.hasRightChild()) {
          parentKnotOfData.setLeftChild(null);
          return true;
        }
      }
      return false;
    }

    final BinaryTreeKnot rightChild = parentKnotOfData.getRightChild();
    if (data.equals(rightChild.getData())) {
      if (!rightChild.hasLeftChild() && !rightChild.hasRightChild()) {
        parentKnotOfData.setRightChild(null);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean contains(final Integer data) {
    return search(data) != null;
  }

  public void printItemsTraverseInOrder() {
    LOG.info("---------- printItemsTraverseInOrder ----------");
    printItemsTraverseInOrder(root);
  }

  /**
   * Symmetrische Reihenfolge, folgt der Sortierung des Baumes
   */
  private void printItemsTraverseInOrder(final BinaryTreeKnot knot) {
    if (knot == null) {
      LOG.trace("endOfPath");
      return;
    }
    LOG.trace("traverse: " + knot.getData());
    printItemsTraverseInOrder(knot.getLeftChild());
    LOG.trace("handle: " + knot.getData());
    LOG.info(knot);
    printItemsTraverseInOrder(knot.getRightChild());
  }

  public void printItemsTraversePreOrder() {
    LOG.info("---------- printItemsTraversePreOrder ----------");
    printItemsTraversePreOrder(root);
  }

  /**
   * Hauptreihenfolge, zuerst Knoten (wurzel, dann linker Teilbaum, dann rechter Teilbaum
   */
  private void printItemsTraversePreOrder(final BinaryTreeKnot knot) {
    if (knot == null) {
      LOG.trace("endOfPath");
      return;
    }
    LOG.trace("handle: " + knot.getData());
    LOG.info(knot);

    LOG.trace("traverse left child of: " + knot.getData());
    printItemsTraversePreOrder(knot.getLeftChild());
    LOG.trace("traverse right child of: " + knot.getData());
    printItemsTraversePreOrder(knot.getRightChild());
  }

  public void printItemsTraversePostOrder() {
    LOG.info("---------- printItemsTraversePostOrder ----------");
    printItemsTraversePostOrder(root);
  }

  /**
   * Nebenreihenfolge, zuerst linker Teilbaum, dann rechter Teilbaum, dann Knoten (Wurzel)
   */
  private void printItemsTraversePostOrder(final BinaryTreeKnot knot) {
    if (knot == null) {
      LOG.trace("endOfPath");
      return;
    }

    LOG.trace("traverse left child of: " + knot.getData());
    printItemsTraversePostOrder(knot.getLeftChild());
    LOG.trace("traverse right child of: " + knot.getData());
    printItemsTraversePostOrder(knot.getRightChild());

    LOG.trace("handle: " + knot.getData());
    LOG.info(knot);
  }

  public Integer search(final Integer data) {
    if (data == null) {
      LOG.trace("Fast exit since data is null");
      return null;
    }
    final BinaryTreeKnot binaryTreeKnot = internalSearch(data);
    if (binaryTreeKnot == null) {
      return null;
    }
    return binaryTreeKnot.getData();
  }

  private BinaryTreeKnot internalSearch(final Integer data) {
    return internalSearch(new BinaryTreeKnot(data, null, null));
  }

  private BinaryTreeKnot internalSearch(final BinaryTreeKnot data) {
    LOG.trace("Searching for: {} in {}", data, this);
    BinaryTreeKnot knot = root;
    while (knot != null) {
      if (knot.equals(data)) {
        LOG.trace("Knot found: {}", knot);
        return knot;
      }

      if (dataShouldBeLeftChildOf(data, knot)) {
        LOG.trace("Going to the left from knot: {}", knot);
        knot = knot.getLeftChild();
      } else {
        LOG.trace("Going to the right from knot: {}", knot);
        knot = knot.getRightChild();
      }
    }
    LOG.trace("Data not found.");
    return null;
  }

  private BinaryTreeKnot internalSearchForParent(final Integer data) {
    return internalSearchForParent(new BinaryTreeKnot(data, null, null));
  }

  private BinaryTreeKnot internalSearchForParent(final BinaryTreeKnot data) {
    LOG.trace("Find parent of knot: {}", data);
    BinaryTreeKnot parent = null;
    BinaryTreeKnot knot = root;
    while (knot != null) {
      if (knot.equals(data)) {
        return parent;
      }

      parent = knot;

      if (dataShouldBeLeftChildOf(data, knot)) {
        if (!knot.hasLeftChild()) return null;
        knot = knot.getLeftChild();
      } else {
        if (!knot.hasRightChild()) return null;
        knot = knot.getRightChild();
      }
    }
    return parent;
  }

  private void addKnotAtCorrectPosition(final BinaryTreeKnot newKnot) {
    LOG.trace("Add new knot: {}", newKnot);
    BinaryTreeKnot knot = root;
    while (knot != null) {
      if (knot.equals(newKnot)) {
        throw new DuplicateElementException(String.format("data %d is already existing in tree, duplicates are not " + "allowed", knot.getData()));
      }

      if (dataShouldBeLeftChildOf(newKnot, knot)) {
        if (addAsLeftChildIfNotExisting(newKnot, knot)) return;
        knot = knot.getLeftChild();
      } else {
        if (addAsRightChildIfNotExisting(newKnot, knot)) return;
        knot = knot.getRightChild();
      }
    }
    LOG.trace("Added as root, since root was null: {}", this);
    root = newKnot;
    ++size;
  }

  private boolean dataShouldBeLeftChildOf(final BinaryTreeKnot data, final BinaryTreeKnot knot) {
    return knot.compareTo(data) > 0;
  }

  private boolean addAsLeftChildIfNotExisting(final BinaryTreeKnot newKnot, final BinaryTreeKnot knot) {
    LOG.trace("Going to the left from knot: {}", knot);
    if (!knot.hasLeftChild()) {
      knot.setLeftChild(newKnot);
      ++size;
      LOG.trace("Added as leftChild: {}", this);
      return true;
    }
    return false;
  }

  private boolean addAsRightChildIfNotExisting(final BinaryTreeKnot newKnot, final BinaryTreeKnot knot) {
    LOG.trace("Going to the right from knot: {}", knot);
    if (!knot.hasRightChild()) {
      knot.setRightChild(newKnot);
      ++size;
      LOG.trace("Added as rightChild: {}", this);
      return true;
    }
    return false;
  }

  @Override
  public void balance() {
    throw new UnsupportedOperationException("functionality not yet implemented");
  }

  @Override
  public String toString() {
    return "BinaryTree[root=" + root + ']';
  }

  public int size() {
    return size;
  }
}
