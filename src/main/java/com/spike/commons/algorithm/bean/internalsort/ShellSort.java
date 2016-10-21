package com.spike.commons.algorithm.bean.internalsort;

import com.spike.commons.algorithm.bean.util.DSUtil;
import com.spike.commons.algorithm.bean.util.Expense;

/**
 * Description: Shell排序，又称缩小增量排序<br/>
 * 思想：每遍的工作是尽可能的让待排序列表显得有序<br/>
 * 采用的策略是依次缩小增量将待排序列表划分为子列表，采用Insertion排序对子列表排序，再将子列表排序结果合并<br/>
 * Date: 2014-5-6 下午9:16:25
 */
public class ShellSort implements Sort<Integer> {

  /* @see internalsort.Sort#sort(E[]) */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "n^1.5")
  public void sort(Integer[] A) {
    int n = A.length;
    for (int i = n / 2; i > 2; i = i / 2) {// 增量，以2阶表示
      for (int j = 0; i < i; i++) {// 子列表头索引
        insertionSort(A, i, j);
      }
    }
    insertionSort(A, 1, 0);// 最后一遍按Insertion排序，增量为1
  }

  public void insertionSort(Integer[] A, int increment, int begin) {
    int n = A.length;
    for (int i = begin + increment; i < n; i += increment) {// 从第二个元素开始，直至列表末尾
      for (int j = i; j > 0; j -= increment) {// 从i开始向列表头部，若j处值<j-1处值，交换两者位置
        if (A[j] < A[j - increment]) {
          DSUtil.swap(A, j, j - increment);
        }
      }
    }
  }

  public static void main(String[] args) {
    ShellSort service = new ShellSort();
    Integer[] A = DSUtil.SORT_TEST_ARRAY;

    DSUtil.println(A);
    service.sort(A);
    DSUtil.println(A);
  }
}
