package com.spike.commons.algorithm.bean.tree.heap;

/**
 * Description: Complete Binary Tree/Heap<br/>
 * Date: 2014-4-27 下午6:11:34
 */
public class CompleteBT<E> {
  private E[] array;
  private int n;

  /**
   * @param array 客户负责维护堆
   */
  public CompleteBT(E[] array) {
    this.array = array;
    n = array.length;
  }

  private int parentIndex(int r) {
    if (r == 0) return -1;
    return (r - 1) / 2;
  }

  private int leftChildIndex(int r) {
    int temp = 2 * r + 1;
    if (temp >= n) return -1;
    return temp;
  }

  private int rightChildIndex(int r) {
    int temp = 2 * r + 2;
    if (temp >= n) return -1;
    return temp;
  }

  private int leftSiblingIndex(int r) {
    if (r != 0 && r % 2 == 0) return (r - 1);
    return -1;
  }

  private int rightSiblingIndex(int r) {
    if (r % 2 != 0 && r + 1 < n) return (r + 1);
    return -1;
  }

  public E parent(int r) {
    int index = parentIndex(r);
    if (index != -1) return array[index];
    return null;
  }

  public E leftChild(int r) {
    int index = leftChildIndex(r);
    if (index != -1) return array[index];
    return null;
  }

  public E rightChild(int r) {
    int index = rightChildIndex(r);
    if (index != -1) return array[index];
    return null;
  }

  public E leftSibling(int r) {
    int index = leftSiblingIndex(r);
    if (index != -1) return array[index];
    return null;
  }

  public E rightSibling(int r) {
    int index = rightSiblingIndex(r);
    if (index != -1) return array[index];
    return null;
  }
}
