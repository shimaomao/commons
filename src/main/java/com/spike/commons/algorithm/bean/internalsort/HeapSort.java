package com.spike.commons.algorithm.bean.internalsort;

import com.spike.commons.algorithm.bean.tree.heap.MaxHeap;
import com.spike.commons.algorithm.bean.util.DSUtil;
import com.spike.commons.algorithm.bean.util.Expense;

/**
 * Description: 堆排序<br/>
 * 思想：将待排序列表组织成最大堆，依次移除最大元素，因最大堆实现中移除的元素放置于当前堆的末尾位置，故最终得到排好序的列表<br/>
 * Date: 2014-5-9 下午11:17:23
 */
public class HeapSort implements Sort<Integer> {

  /* @see internalsort.Sort#sort(E[]) */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "nlogn")
  public void sort(Integer[] A) {
    int n = A.length;
    MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(A, n, n);
    for (int i = 0; i < n; i++) {// 依次移除最大值，放于当前堆的末尾
      maxHeap.removemax();
    }
  }

  public static void main(String[] args) {
    HeapSort service = new HeapSort();
    Integer[] A = DSUtil.SORT_TEST_ARRAY;

    DSUtil.println(A);
    service.sort(A);
    DSUtil.println(A);
  }
}
