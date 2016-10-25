package com.spike.commons.algorithm.bean.internalsort;

import com.spike.commons.algorithm.bean.util.DSUtil;
import com.spike.commons.algorithm.bean.util.Expense;

/**
 * Description: 插入排序<br/>
 * 思想：从列表第二个元素开始直到列表末尾，一次将每个元素放置到正确的位置<br/>
 * Date: 2014-5-5 下午10:43:54
 */
public class InsertionSort implements Sort<Integer> {

  /* @see internalsort.Sort#sort(E[]) */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "n^2")
  public void sort(Integer[] A) {
    int n = A.length;
    for (int i = 1; i < n; i++) {// 从第二个元素开始，直至列表末尾
      for (int j = i; j > 0; j--) {// 从i开始向列表头部，若j处值<j-1处值，交换两者位置
        if (A[j] < A[j - 1]) {
          DSUtil.swap(A, j, j - 1);
        }
      }
    }
  }

  public static void main(String[] args) {
    InsertionSort service = new InsertionSort();
    Integer[] A = DSUtil.SORT_TEST_ARRAY;

    DSUtil.println(A);
    service.sort(A);
    DSUtil.println(A);
  }
}
