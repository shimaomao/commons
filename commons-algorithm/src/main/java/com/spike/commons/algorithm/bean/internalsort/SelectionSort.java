package com.spike.commons.algorithm.bean.internalsort;

import com.spike.commons.algorithm.bean.util.DSUtil;
import com.spike.commons.algorithm.bean.util.Expense;

/**
 * Description: 选择排序<br/>
 * 思想：从列表头部开始，将当前位置的值与后面的最小值交换<br/>
 * Date: 2014-5-5 下午11:15:30
 */
public class SelectionSort implements Sort<Integer> {

  /* @see internalsort.Sort#sort(E[]) */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "n^2")
  public void sort(Integer[] A) {
    int n = A.length;
    for (int i = 0; i < n - 1; i++) {
      int smallestIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (A[smallestIndex] > A[j]) {
          smallestIndex = j;
        }
      }
      DSUtil.swap(A, i, smallestIndex);
    }
  }

  // 方法1：缺陷交换次数过多
  public void sort1(Integer[] A) {
    int n = A.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (A[i] > A[j]) {
          DSUtil.swap(A, i, j);
        }
      }
    }
  }

  public static void main(String[] args) {
    SelectionSort service = new SelectionSort();
    Integer[] A = DSUtil.SORT_TEST_ARRAY;

    DSUtil.println(A);
    service.sort(A);
    DSUtil.println(A);
  }
}
