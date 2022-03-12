package ch.hslu.ad.sw02;

import java.util.NoSuchElementException;

// todo: SW01, D1, A3.4 Optionale Aufgaben
public final class StringStack implements Stack {
  private final String[] stack;
  private int usedPlacesCounter;

  public StringStack(int maxSize) {
    stack = new String[maxSize];
    usedPlacesCounter = 0;
  }

  @Override
  public void push(final String string) throws StackOverflowError {
    if (isFull()) {
      throw new StackOverflowError("Stack is full, requested element cannot be added.");
    }
    stack[usedPlacesCounter] = string;
    usedPlacesCounter++;
  }

  @Override
  public String pop() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty, no element can be retrieved.");
    }
    usedPlacesCounter--;
    final String elementToBeRemoved = stack[usedPlacesCounter];
    /*
     * Achtung: stack kurz gefüllt und dann wieder verworfen
     * warum kann das dazu führen, das Memory geklaut wird???
     *
     * -> Stack-Referenz bleibt dann im Array liegen sollte jeweils zurückgesetzt werden,
     *    sonst kann der Garbage Collector diese Referenzen nicht aufräumen
     */
    stack[usedPlacesCounter] = null;
    return elementToBeRemoved;
  }

  @Override
  public boolean isEmpty() {
    return usedPlacesCounter == 0;
  }

  @Override
  public boolean isFull() {
    return usedPlacesCounter == size();
  }

  @Override
  public int size() {
    return stack.length;
  }

  @Override
  public int getAmountOfUsedPlaces() {
    return usedPlacesCounter;
  }
}
