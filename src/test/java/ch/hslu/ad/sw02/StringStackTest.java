package ch.hslu.ad.sw02;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringStackTest {
  private static final int DEFAULT_MAX_SIZE = 10;

  @Test
  void createStack_createsEmptyStackWithInitializedValues() {
    final StringStack stack = new StringStack(DEFAULT_MAX_SIZE);
    assertTrue(stack.isEmpty());
    assertFalse(stack.isFull());
    assertThat(stack.size()).isEqualTo(DEFAULT_MAX_SIZE);
    assertThat(stack.getAmountOfUsedPlaces()).isEqualTo(0);
  }

  @Test
  void push_addElement_stackIsNotEmpty() {
    final StringStack stack = new StringStack(DEFAULT_MAX_SIZE);
    stack.push("Test");
    assertFalse(stack.isEmpty());
  }

  @Test
  void push_addElement_usedPlacesValueIncreases() {
    final StringStack stack = new StringStack(DEFAULT_MAX_SIZE);
    final int usedPlacesBeforeOperation = stack.getAmountOfUsedPlaces();
    stack.push("Test");
    assertThat(stack.getAmountOfUsedPlaces()).isEqualTo(usedPlacesBeforeOperation + 1);
  }

  @Test
  void push_addElementToStackOfSizeOneAddElement_stackIsFull() {
    final StringStack stack = new StringStack(1);
    assertThat(stack.size()).isOne();
    stack.push("Fill Stack");
    assertTrue(stack.isFull());
  }

  @Test
  void push_addElementToFullStack_throwsStackOverflowException() {
    final StringStack stack = new StringStack(1);
    stack.push("Fill Stack");
    assertTrue(stack.isFull());
    assertThrowsExactly(StackOverflowError.class, //
                        () -> stack.push("Overfill Stack"), //
                        "Stack is full, requested element cannot be added.");
  }

  @Test
  void pop_emptyArray_throwsNoSuchElementException() {
    final StringStack stack = new StringStack(DEFAULT_MAX_SIZE);
    assertThrowsExactly(NoSuchElementException.class, stack::pop, "Stack is empty, no element can be retrieved.");
  }

  @Test
  void pop_filledArray_usedPlacesValueDecreases() {
    final StringStack stack = new StringStack(DEFAULT_MAX_SIZE);
    stack.push("Test");
    final int usedPlacesBeforeOperation = stack.getAmountOfUsedPlaces();
    stack.pop();
    assertThat(stack.getAmountOfUsedPlaces()).isEqualTo(usedPlacesBeforeOperation - 1);
  }

  @Test
  void pop_filledStack_returnsElement() {
    final String testString = "Test";
    final StringStack stack = new StringStack(DEFAULT_MAX_SIZE);
    stack.push(testString);
    assertThat(stack.pop()).isEqualTo(testString);
  }

  @Test
  void pop_removeOnlyElementFromStack_stackIsEmpty() {
    final String testString = "Test";
    final StringStack stack = new StringStack(DEFAULT_MAX_SIZE);
    stack.push(testString);
    stack.pop();
    assertTrue(stack.isEmpty());
  }

  @Test
  void stack_addAndRemoveMultipleElements_noElementLostElementsReturnedInReversedOrder() {
    final String testString1 = "Test 1";
    final String testString2 = "Test 2";
    final String testString3 = "Test 3";
    final StringStack stack = new StringStack(3);
    stack.push(testString1);
    stack.push(testString2);
    stack.push(testString3);
    assertTrue(stack.isFull());
    assertThat(stack.pop()).isEqualTo(testString3);
    assertThat(stack.pop()).isEqualTo(testString2);
    assertThat(stack.pop()).isEqualTo(testString1);
    assertTrue(stack.isEmpty());
  }
}
