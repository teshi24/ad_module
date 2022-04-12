package ch.hslu.ad.sw04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HashSetTest {
  private HashSet testee;

  @BeforeEach
  void setUp() {
    testee = new HashSet();
  }

  @Test
  void size_initializedSet_zero() {
    assertThat(testee.size()).isZero();
  }

  @Test
  void contains_null_false() {
    assertFalse(testee.contains(null));
  }

  @Test
  void contains_initializedSet_false() {
    assertFalse(testee.contains(1));
  }

  @Test
  void contains_itemNotInFilledSet_false() {
    testee.add(1);
    assertFalse(testee.contains(0));
  }

  @Test
  void contains_itemNotInFilledSetMultipleEntries_false() {
    testee.add(1);
    testee.add(2);
    assertFalse(testee.contains(0));
  }

  @Test
  void contains_itemInFilledSet_true() {
    testee.add(2);
    assertTrue(testee.contains(2));
  }

  @Test
  void add_multipleItems_allContainedInList() {
    final List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, 5);
    for (final Integer integer : ints) {
      testee.add(integer);
    }

    for (final Integer integer : ints) {
      assertThat(testee.contains(integer)).withFailMessage("Integer %d not contained in testee %s", //
                                                           integer, testee) //
                                          .isTrue();
    }
  }

  // todo: add duplicated elements - exception
  // todo: add null elements - exception
  // todo: add more elements which have bigger hashCodes than the MAX_SIZE of the HashSet - exception

  @Test
  void add_int_sizeIncreasedBy1() {
    final int sizeBeforeCall = testee.size();
    testee.add(1);
    assertThat(testee.size()).isEqualTo(sizeBeforeCall + 1);
  }

  @Test
  void add_int_intContainedInSet() {
    final int itemToBeAdded = 1;
    testee.add(itemToBeAdded);
    assertTrue(testee.contains(itemToBeAdded));
  }

  @Test
  void remove_input_output() {
    testee.remove(1);
    Assertions.fail();
  }
}