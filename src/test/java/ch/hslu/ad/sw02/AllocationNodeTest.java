package ch.hslu.ad.sw02;

import ch.hslu.ad.sw01.Allocation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AllocationNodeTest {

  @Test
  void createAllocationNode_allocationSetNextNodeNull() {
    final Allocation allocation = new Allocation(0, 1);
    final AllocationNode node = new AllocationNode(allocation);
    assertThat(node.getAllocation()).isEqualTo(allocation);
    assertThat(node.getNextNode()).isEqualTo(null);
  }

  @Test
  void setNextNode_null_nextNodeSetToNull() {
    final Allocation allocation = new Allocation(0, 1);
    final AllocationNode node = new AllocationNode(allocation);
    node.setNextNode(null);
    assertThat(node.getNextNode()).isEqualTo(null);
  }

  @Test
  void setNextNode_nodeGiven_nextNodeSetToGivenNode() {
    final Allocation allocation = new Allocation(0, 1);
    final AllocationNode node = new AllocationNode(allocation);
    node.setNextNode(node);
    assertThat(node.getNextNode()).isEqualTo(node);
  }

  @Test
  void setNextNode_nullNodeWasGiven_nextNodeSetToNull() {
    final Allocation allocation = new Allocation(0, 1);
    final AllocationNode node = new AllocationNode(allocation);
    node.setNextNode(node);
    node.setNextNode(null);
    assertThat(node.getNextNode()).isEqualTo(null);
  }
}