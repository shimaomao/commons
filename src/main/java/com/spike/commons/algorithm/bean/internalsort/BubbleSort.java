package com.spike.commons.algorithm.bean.internalsort;

import com.spike.commons.algorithm.bean.util.DSUtil;
import com.spike.commons.algorithm.bean.util.Expense;

/**
 * Description: 冒泡排序<br/>
 * 思想：第i遍将第i小值排好序<br/>
 * Date: 2014-5-5 下午11:01:56
 */
public class BubbleSort implements Sort<Integer> {

  /* @see internalsort.Sort#sort(E[]) */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "n^2")
  public void sort(Integer[] A) {
    int n = A.length;
    for (int i = 0; i < n - 1; i++) {// 遍数标识，共需n-1遍
      for (int j = n - 1; j > i; j--) {// 内部循环从列表尾部开始
        if (A[j] < A[j - 1]) {// 小元素上升
          DSUtil.swap(A, j, j - 1);
        }
      }
    }
  }

  public static void main(String[] args) {
    BubbleSort service = new BubbleSort();
    Integer[] A = DSUtil.SORT_TEST_ARRAY;

    DSUtil.println(A);
    service.sort(A);
    DSUtil.println(A);
  }
}
