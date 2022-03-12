package ch.hslu.ad.sw02;

import ch.hslu.ad.sw01.Allocation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AllocationListTest {

  @Test
  void createAllocationList_listIsInitialized() {
    final AllocationList allocationList = new AllocationList();
    assertThat(allocationList.size()).isZero();
  }

  @Test
  void push_allocationAdded_sizeIncreased() {
    final AllocationList allocationList = new AllocationList();
    final Allocation allocation = new Allocation(0, 8);
    final int sizeBeforeOperation = allocationList.size();
    allocationList.push(allocation);
    assertThat(allocationList.size()).isEqualTo(sizeBeforeOperation + 1);
  }

  @Test
  void push_allocationAdded_allocationCanBeFoundInList() {
    final AllocationList allocationList = new AllocationList();
    final Allocation allocation = new Allocation(0, 8);
    allocationList.push(allocation);
    assertTrue(allocationList.contains(allocation));
  }

  @Test
  void push_secondAllocationAdded_bothAllocationsCanBeFoundInList() {
    final AllocationList allocationList = new AllocationList();
    final Allocation allocation = new Allocation(0, 8);
    allocationList.push(allocation);
    final Allocation secondAllocation = new Allocation(1, 8);
    allocationList.push(secondAllocation);
    assertTrue(allocationList.contains(secondAllocation));
    assertTrue(allocationList.contains(allocation));
  }

  @Test
  void pop_emptyList_returnNullAndSizeRemains0() {
    final AllocationList allocationList = new AllocationList();
    final int sizeBeforeOperation = allocationList.size();
    final Allocation poppedAllocation = allocationList.pop();
    assertNull(poppedAllocation);
    assertThat(allocationList.size()).isEqualTo(sizeBeforeOperation);
  }

  @Test
  void pop_oneAllocationInList_returnAllocationInList() {
    final AllocationList allocationList = new AllocationList();
    final Allocation allocation = new Allocation(2, 8);
    allocationList.push(allocation);
    final Allocation poppedAllocation = allocationList.pop();
    assertThat(poppedAllocation).isEqualTo(allocation);
  }

  @Test
  void pop_oneAllocationInList_removesReturnedAllocationFromList() {
    final AllocationList allocationList = new AllocationList();
    final Allocation allocation = new Allocation(2, 8);
    allocationList.push(allocation);
    final Allocation poppedAllocation = allocationList.pop();
    assertFalse(allocationList.contains(poppedAllocation));
  }

  @Test
  void pop_oneAllocationInList_sizeDecreasesByOne() {
    final AllocationList allocationList = new AllocationList();
    final Allocation allocation = new Allocation(2, 8);
    allocationList.push(allocation);
    final int sizeBeforeOperation = allocationList.size();
    allocationList.pop();
    assertThat(allocationList.size()).isEqualTo(sizeBeforeOperation - 1);
  }

  @Test
  void pop_initializedList_allocationNoLongerContained() {
    final AllocationList allocationList = new AllocationList();
    final Allocation allocation = new Allocation(2, 8);
    allocationList.push(allocation);
    final boolean containsBeforeOperation = allocationList.contains(allocation);
    assertTrue(containsBeforeOperation);
    allocationList.pop();
    assertThat(allocationList.contains(allocation)).isNotEqualTo(containsBeforeOperation);
    assertFalse(allocationList.contains(allocation));
  }

  @Test
  void remove_emptyList_listRemainsEmptySizeRemains0() {
    final AllocationList allocationList = new AllocationList();
    final int sizeBeforeOperation = allocationList.size();
    allocationList.remove(new Allocation(1, 8));
    assertThat(allocationList.size()).isEqualTo(sizeBeforeOperation);
  }

  @Test
  void remove_removeAllocationWhichIsNotInList_sizeRemains() {
    final AllocationList allocationList = new AllocationList();
    allocationList.push(new Allocation(0, 8));
    final int sizeBeforeOperation = allocationList.size();
    allocationList.remove(new Allocation(1, 8));
    assertThat(allocationList.size()).isEqualTo(sizeBeforeOperation);
  }

  @Test
  void remove_removeAllocationWhichIsLastElementInList_elementRemovedAndSizeDecreasesByOne() {
    final AllocationList allocationList = new AllocationList();
    final Allocation lastAllocation = new Allocation(0, 8);
    final Allocation root = new Allocation(1, 8);
    allocationList.push(lastAllocation);
    allocationList.push(root);
    final int sizeBeforeOperation = allocationList.size();
    allocationList.remove(lastAllocation);
    assertFalse(allocationList.contains(lastAllocation));
    assertTrue(allocationList.contains(root));
    assertThat(allocationList.size()).isEqualTo(sizeBeforeOperation - 1);
  }

  @Test
  void remove_removeAllocationWhichIsRoot_elementRemovedAndSizeDecreasedByOne() {
    final AllocationList allocationList = new AllocationList();
    final Allocation root = new Allocation(0, 8);
    final Allocation lastAllocation = new Allocation(1, 8);
    allocationList.push(lastAllocation);
    allocationList.push(root);
    final int sizeBeforeOperation = allocationList.size();
    System.out.println(allocationList);
    allocationList.remove(root);
    System.out.println(allocationList);
    assertFalse(allocationList.contains(root));
    assertTrue(allocationList.contains(lastAllocation));
    assertThat(allocationList.size()).isEqualTo(sizeBeforeOperation - 1);
  }

  @Test
  void remove_removeAllocationWhichIsInTheMiddleOfTheList_allocationNoLongerContained() {
    final AllocationList allocationList = new AllocationList();
    final Allocation middleAllocation = new Allocation(0, 8);
    final Allocation root = new Allocation(2, 8);
    final Allocation lastAllocation = new Allocation(1, 8);
    allocationList.push(lastAllocation);
    allocationList.push(middleAllocation);
    allocationList.push(root);
    final int sizeBeforeOperation = allocationList.size();
    allocationList.remove(middleAllocation);
    assertFalse(allocationList.contains(middleAllocation));
    assertTrue(allocationList.contains(lastAllocation));
    assertTrue(allocationList.contains(root));
    assertThat(allocationList.size()).isEqualTo(sizeBeforeOperation - 1);
  }

  @Test
  void contains_emptyList_returnFalse() {
    final AllocationList allocationList = new AllocationList();
    assertFalse(allocationList.contains(new Allocation(1, 8)));
  }

  @Test
  void contains_allocationWhichIsNotInList_returnFalse() {
    final AllocationList allocationList = new AllocationList();
    allocationList.push(new Allocation(0, 8));
    assertFalse(allocationList.contains(new Allocation(1, 8)));
  }

  @Test
  void contains_allocationWhichIsInList_returnTrue() {
    final AllocationList allocationList = new AllocationList();
    final Allocation allocation = new Allocation(1, 8);
    allocationList.push(allocation);
    assertTrue(allocationList.contains(allocation));
  }

  @Test
  void contains_oneOfMultipleAllocationInList_returnTrue() {
    final AllocationList allocationList = new AllocationList();
    final Allocation allocation = new Allocation(0, 8);
    final Allocation secondAllocation = new Allocation(1, 8);
    final Allocation thirdAllocation = new Allocation(2, 8);
    allocationList.push(allocation);
    allocationList.push(secondAllocation);
    allocationList.push(thirdAllocation);
    assertTrue(allocationList.contains(allocation));
    assertTrue(allocationList.contains(secondAllocation));
    assertTrue(allocationList.contains(thirdAllocation));
  }
}
