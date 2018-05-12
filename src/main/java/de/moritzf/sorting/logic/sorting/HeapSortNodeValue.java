package de.moritzf.sorting.logic.sorting;

import java.util.ArrayList;

public class HeapSortNodeValue {

  private ArrayList<Integer> numbers = new ArrayList<>();

  public HeapSortNodeValue(int initialNumber) {
    numbers.add(initialNumber);
  }

  public int getNumber() {
    return numbers.get(numbers.size() - 1);
  }

  public void replaceNumber(int number) {
    this.numbers.add(number);
  }

  @Override
  public String toString() {
    StringBuilder joiner = new StringBuilder();
    for (int i = 0; i < numbers.size(); i++) {
      if (i == 0 && numbers.size() > 1) {
        joiner.append("\\st{" + Integer.toString(numbers.get(i)) + "}");
        joiner.append("%begin-above-node\n");
      } else if (i == numbers.size() - 1) {
        joiner.append(Integer.toString(numbers.get(numbers.size() - 1)));
        // even if no old numbers are written above the node, insert an empty space
        // so that all node-boxes are aligned next to each other
        // if this is not done, a neighbour node-box WITH numbers above the node would differ in
        // height from the one without numbers above the node.
        joiner.append("%begin-above-node\n");
        joiner.append("\\,");
      } else {
        joiner.append("\\st{" + Integer.toString(numbers.get(i)) + "}, ");
      }
    }

    return joiner.toString();
  }
}
