package ch.hslu.ad.sw02;

import ch.hslu.ad.sw01.Allocation;

// todo: sollte eigentlich noch ein Interface geben
// todo: SW02, D1, A2.4 add implements Collection / List interface
// todo: SW02, D1, A5 use this list for a SpeicherAllokation
public final class AllocationList {
  private AllocationNode root;
  private int size = 0;

  public void push(final Allocation allocation) {
    if (root == null) {
      root = new AllocationNode(allocation);
    } else {
      final AllocationNode newRoot = new AllocationNode(allocation);
      newRoot.setNextNode(root);
      root = newRoot;
    }
    size++;
  }

  public Allocation pop() {
    return removeRoot();
  }

  public void remove(final Allocation allocation) {
    if (size < 1) {
      return;
    }

    AllocationNode node = null;
    AllocationNode nextNode = root;
    while (nextNode != null) {
      if (nextNode.getAllocation() != null && nextNode.getAllocation().equals(allocation)) {
        removeNode(node, nextNode);
        return;
      }
      node = nextNode;
      nextNode = nextNode.getNextNode();
    }
  }

  private void removeNode(final AllocationNode previousNode, final AllocationNode node) {
    if (previousNode != null) {
      previousNode.setNextNode(node.getNextNode());
      size--;
    } else if (node != null) {
      removeRoot();
    }
  }

  private Allocation removeRoot() {
    if (root == null) {
      return null;
    }
    final Allocation allocation = root.getAllocation();
    root = root.getNextNode();
    size--;
    return allocation;
  }

  public boolean contains(final Allocation allocation) {
    AllocationNode currentNode = root;

    while (currentNode != null) {
      if (currentNode.getAllocation().equals(allocation)) {
        return true;
      }
      currentNode = currentNode.getNextNode();
    }

    return false;
  }

  public int size() {
    return size;
  }

  @Override
  public String toString() {
    return "AllocationList{" + "root=" + root + ", size=" + size + '}';
  }
}
