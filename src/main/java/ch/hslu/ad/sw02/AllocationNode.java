package ch.hslu.ad.sw02;

import ch.hslu.ad.sw01.Allocation;

final class AllocationNode {
  private final Allocation allocation;
  private AllocationNode nextNode;

  // todo: könnte nextNode ebenfalls gleich im Konstruktor hinzufügen
  public AllocationNode(final Allocation allocation) {
    this.allocation = allocation;
  }

  Allocation getAllocation() {
    return allocation;
  }

  AllocationNode getNextNode() {
    return nextNode;
  }

  void setNextNode(final AllocationNode allocationNode) {
    nextNode = allocationNode;
  }

  @Override
  public String toString() {
    return "AllocationNode{" + "allocation=" + allocation + ", nextNode=" + nextNode + '}';
  }
}
