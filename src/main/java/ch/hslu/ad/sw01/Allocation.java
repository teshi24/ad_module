package ch.hslu.ad.sw01;

import java.util.Objects;

public final class Allocation implements Comparable<Allocation> {
  private final int address;
  private final int sizeInBytes;

  public Allocation(final int address, final int sizeInBytes) {
    this.address = address;
    this.sizeInBytes = sizeInBytes;
  }

  @Override
  public int compareTo(final Allocation allocation) {
    if (this == allocation) {
      return 0;
    }
    return Integer.compare(address, allocation.address);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o instanceof Allocation allocation) {
      return address == allocation.address;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(address);
  }

  @Override
  public String toString() {
    return "Allocation[" + "address=" + address + "; sizeInBytes=" + sizeInBytes + ']';
  }
}
