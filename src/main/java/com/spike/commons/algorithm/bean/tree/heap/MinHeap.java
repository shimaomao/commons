package com.spike.commons.algorithm.bean.tree.heap;

import com.google.common.base.Preconditions;
import com.spike.commons.algorithm.bean.util.Expense;

/**
 * Description: 最小堆<br/>
 * 性质：父节点值<= 左、右节点值 Date: 2014-4-27 下午11:34:32
 */
public class MinHeap<E extends Comparable<? super E>> {
  private E[] heap;// 内部数组
  private int size;// 最大容量
  private int n;// 当前容量

  public MinHeap(E[] heap, int currentSize, int maxSize) {
    this.heap = heap;
    this.n = currentSize;
    this.size = maxSize;
    buildheap();
  }

  /**
   * Description: 构建堆<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  @Expense(tag = Expense.TAG.Θ, value = "n")
  private void buildheap() {
    // 将每个内部节点放置到正确的位置
    for (int i = n / 2 - 1; i >= 0; i--)
      siftdown(i);
  }

  /**
   * Description: 将元素放置在正确的位置：与其子节点值最大者交换位置，一直向下处理<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  private void siftdown(int pos) {
    Preconditions.checkArgument(pos >= 0 && pos < n, "Heap postion out of range");
    while (!isLeaf(pos)) {
      int childPos = leftChild(pos);// 先选择左子节点位置
      if (childPos < (n - 1) && heap[childPos].compareTo(heap[childPos + 1]) > 0) {// 若右子节点值较小，选择右子节点
        childPos++;
      }
      if (heap[pos].compareTo(heap[childPos]) < 0) {// 若该位置值小于其子节点的值，直接返回
        return;
      } else {// 否则交换两者的值，继续
        swap(heap, pos, childPos);
        pos = childPos;
      }
    }
  }

  /**
   * Description: 删除堆顶元素<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  @Expense(tag = Expense.TAG.Θ, value = "logn")
  public E removemin() {
    Preconditions.checkArgument(n > 0, "Removing from empty heap");
    swap(heap, 0, --n);// 将最大值(root)与最后一位交换
    if (n != 0) {
      siftdown(0);// 将新堆的root放置到正确的位置
    }
    return heap[n];// 返回新堆的最后一个值
  }

  /**
   * Description: 删除堆中位置pos处的值<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  public E remove(int pos) {
    Preconditions.checkArgument(pos >= 0 && pos < n, "Heap position out of range");
    if (pos == (n - 1)) {// 直接将堆最后一个值返回
      n--;
    } else {
      swap(heap, pos, --n);// 将该位置值与堆中最后一个值交换
      // 如果交换的值是一个小值，向上推, example 7362154 =(1)=> 746235，按层次输出
      while ((pos > 0) && heap[pos].compareTo(heap[parent(pos)]) < 0) {
        swap(heap, pos, parent(pos));
        pos = parent(pos);
      }
      if (n != 0) {
        siftdown(pos);// 如果交换的值是一个大值，向下推, example 7635432 =(6)=>753412
      }
    }
    return heap[n];
  }

  /**
   * Description:当前堆容量<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  public int heapsize() {
    return n;
  }

  /**
   * Description: 若该位置是叶子的位置返回true<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  public boolean isLeaf(int pos) {
    return (pos >= n / 2) && (pos < n);
  }

  public int leftChild(int pos) {
    Preconditions.checkArgument(pos < n / 2, "Position has no left child");
    return 2 * pos + 1;
  }

  public int rightChild(int pos) {
    Preconditions.checkArgument(pos < (n - 1) / 2, "Position has no right child");
    return 2 * pos + 2;
  }

  public int parent(int pos) {
    Preconditions.checkArgument(pos > 0, "Position has no parent");
    return (pos - 1) / 2;
  }

  /**
   * Description: 插入值<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  @Expense(tag = Expense.TAG.Θ, value = "logn")
  public void insert(E e) {
    Preconditions.checkArgument(n < size, "Heap is full");
    int curr = n++;
    heap[curr] = e;
    // 若curr的值小于其父节点的值，交换两者的位置
    while ((curr != 0) && heap[curr].compareTo(heap[parent(curr)]) < 0) {
      swap(heap, curr, parent(curr));
      curr = parent(curr);
    }
  }

  // 交换数组中两个位置的值
  private void swap(E[] array, int pos1, int pos2) {
    E temp = array[pos1];
    array[pos1] = array[pos2];
    array[pos2] = temp;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(heap[i] + " ");
    }
    return sb.toString();
  }
}
