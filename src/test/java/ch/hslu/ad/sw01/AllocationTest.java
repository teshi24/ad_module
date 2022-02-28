package ch.hslu.ad.sw01;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AllocationTest {
  private Allocation allocation;
  final int DEFAULT_ADDRESS = 1;
  final int DEFAULT_SIZE_IN_BYTES = 10;

  @BeforeEach
  void allocation_canBeCreated() {
    allocation = new Allocation(DEFAULT_ADDRESS, DEFAULT_SIZE_IN_BYTES);
  }

  @Test
  void compareTo_sameObject_return0() {
    assertThat(allocation.compareTo(allocation)).isZero();
  }

  @Test
  void compareTo_sameAddress_return0() {
    assertThat(allocation.compareTo(new Allocation(DEFAULT_ADDRESS, DEFAULT_SIZE_IN_BYTES))).isZero();
    assertThat(allocation.compareTo(new Allocation(DEFAULT_ADDRESS, DEFAULT_SIZE_IN_BYTES + 1))).isZero();
    assertThat(allocation.compareTo(new Allocation(DEFAULT_ADDRESS, DEFAULT_SIZE_IN_BYTES - 1))).isZero();
  }

  @Test
  void compareTo_biggerAddress_returnMinus1() {
    assertThat(allocation.compareTo(new Allocation(DEFAULT_ADDRESS + 1, DEFAULT_SIZE_IN_BYTES))).isEqualTo(-1);
    assertThat(allocation.compareTo(new Allocation(DEFAULT_ADDRESS + 1, DEFAULT_SIZE_IN_BYTES + 1))).isEqualTo(-1);
    assertThat(allocation.compareTo(new Allocation(DEFAULT_ADDRESS + 1, DEFAULT_SIZE_IN_BYTES - 1))).isEqualTo(-1);
  }

  @Test
  void compareTo_smallerAddress_return1() {
    assertThat(allocation.compareTo(new Allocation(DEFAULT_ADDRESS - 1, DEFAULT_SIZE_IN_BYTES))).isOne();
    assertThat(allocation.compareTo(new Allocation(DEFAULT_ADDRESS - 1, DEFAULT_SIZE_IN_BYTES + 1))).isOne();
    assertThat(allocation.compareTo(new Allocation(DEFAULT_ADDRESS - 1, DEFAULT_SIZE_IN_BYTES - 1))).isOne();
  }

  @Test
  void equals_followsEqualsContract() {
    EqualsVerifier.forClass(Allocation.class).withIgnoredFields("sizeInBytes").verify();
  }

  @Test
  void toString_containsInformationAboutTheFields() {
    assertThat(allocation.toString()).contains(Allocation.class.getSimpleName()).contains(DEFAULT_ADDRESS + "").contains(DEFAULT_SIZE_IN_BYTES + "");
  }
}