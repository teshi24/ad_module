package ch.hslu.ad.sw03;

import ch.hslu.ad.sw03.exceptionHandling.DuplicateElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ch.hslu.ad.exceptionHandling.ExceptionTestHelpers.assertThrowsExactly;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryTreeTest {

  private BinaryTree tree;

  @BeforeEach
  void setUp() {
    tree = new BinaryTree();
  }

  /**
   * creates the data input for this BinaryTree:
   * N0                          8
   * N1                 4                 12
   * N2           2         6        10         14
   * N3             3     5   7              13
   *
   * @return data for {@link #getInitializedTree()}
   */
  private List<Integer> dataOfInitializedTree() {
    return asList(8, 4, 12, 2, 6, 10, 14, 13, 5, 7, 3);
  }

  /**
   * @return {@link BinaryTree} with data from {@link #dataOfInitializedTree()}
   */
  private BinaryTree getInitializedTree() {
    final BinaryTree tree = new BinaryTree();
    dataOfInitializedTree().forEach(tree::add);
    return tree;
  }

  @Test
  void add_null_throwsNullPointerException() {
    assertThrowsExactly(NullPointerException.class, //
                        () -> tree.add(null), //
                        "data must not be null");
  }

  @Test
  void size_emptyTree_treeSizeIsZero() {
    assertThat(tree.size()).isZero();
  }

  @Test
  void size_addValidDataToEmptyTree_treeSizeIsOne() {
    final Integer data = 1;
    tree.add(data);
    assertThat(tree.size()).isOne();
  }

  @Test
  void size_treeWithMultipleDataPoints_treeSizeIsEqualsToAddedData() {
    tree = getInitializedTree();
    assertThat(tree.size()).isEqualTo(dataOfInitializedTree().size());
  }

  @Test
  void add_validDataToEmptyTree_treeSizeIsOne() {
    final Integer data = 1;
    assertThat(tree.size()).isZero();
    tree.add(data);
    assertThat(tree.size()).isOne();
  }

  @Test
  void add_validDataToEmptyTree_treeContainsProvidedData() {
    final Integer data = 1;
    tree.add(data);
    assertTrue(tree.contains(data));
  }

  @Test
  void add_validDataToTreeWithRoot_treeContainsProvidedDataAndInitialDataAsRoot() {
    final Integer initialData = 1;
    final Integer data = 2;
    tree.add(initialData);

    tree.add(data);

    assertTrue(tree.contains(data));
    assertTrue(tree.contains(initialData));
  }

  @Test
  void add_validDataToTreeWithDiverseData_treeContainsProvidedDataAndInitialData() {
    tree = getInitializedTree();
    final List<Integer> dataInTree = dataOfInitializedTree();

    final Integer data = 1;
    assertThat(data).isNotIn(dataInTree);

    tree.add(data);

    assertTrue(tree.contains(data));
    dataInTree.forEach(dataPoint -> assertTrue(tree.contains(dataPoint)));
  }

  @Test
  void add_duplicationToTreeWithRoot_duplicateElementExceptionThrownAndTreeContainsInitialDataAsRoot() {
    final Integer initialData = 1;
    tree.add(initialData);

    assertThrowsExactly(DuplicateElementException.class, //
                        () -> tree.add(initialData), //
                        "data " + initialData + " is already existing in tree, duplicates are not allowed");

    assertTrue(tree.contains(initialData));
  }

  @Test
  void add_duplicationToTreeWithDiverseData_duplicateElementExceptionThrownAndTreeContainsInitialData() {
    tree = getInitializedTree();
    final List<Integer> dataInTree = dataOfInitializedTree();

    final Integer duplicatedData = dataInTree.get(dataInTree.size() - 1);
    assertThrowsExactly(DuplicateElementException.class, //
                        () -> tree.add(duplicatedData), //
                        "data " + duplicatedData + " is already existing in tree, duplicates are not allowed");

    dataInTree.forEach(dataPoint -> assertTrue(tree.contains(dataPoint)));
  }

  @Test
  void search_emptyTree_Null() {
    assertNull(tree.search(1));
  }

  @Test
  void search_nullInTreeWithData_null() {
    tree = getInitializedTree();
    assertNull(tree.search(null));
  }

  @Test
  void search_root_root() {
    final int root = 8;
    tree.add(root);
    assertThat(tree.search(root)).isEqualTo(root);
  }

  @Test
  void search_anyChild_respectiveChild() {
    final int anyChild = 3;
    tree.add(1);
    tree.add(anyChild);
    assertThat(tree.search(anyChild)).isEqualTo(anyChild);
  }

  @Test
  void printItemsWithDifferentTraverses() {
    tree = getInitializedTree();

    tree.printItemsTraverseInOrder();
  }
}