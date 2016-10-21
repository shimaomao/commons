package com.spike.commons.algorithm.bean.internalsort;

import com.spike.commons.algorithm.bean.util.DSUtil;
import com.spike.commons.algorithm.bean.util.Expense;

/**
 * Description: 合并排序<br/>
 * 思想：依然是分治策略，将待排序划分为两个子序列，分别将左右两个子序列排好序后将两个子序列合并<br/>
 * Date: 2014-5-6 下午9:32:14
 */
public class MergeSort implements Sort<Integer> {

  /* @see internalsort.Sort#sort(E[]) */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "nlogn")
  public void sort(Integer[] A) {
    Integer[] deepCopy = new Integer[A.length];
    for (int i = 0; i < A.length; i++) {
      deepCopy[i] = A[i];
    }
    // version 1
    // int n = A.length;
    // Integer[] A2 = new Integer[n];
    // for (int i = 0; i < n; i++) {//注意要初始化
    // A2[i] = 0;
    // }
    // mergeSort(A, A2, 0, n - 1);

    // version 2
    mergeSortV2(A, 0, A.length - 1);
    DSUtil.println(deepCopy);
  }

  @SuppressWarnings("unused")
  private void mergeSort(Integer[] A, Integer[] A2, int l, int r) {
    if (l == r) return;
    int mid = (l + r) / 2;
    mergeSort(A, A2, l, mid);
    mergeSort(A, A2, mid + 1, r);
    for (int i = l; i <= r; i++) {// [l, r]
      A2[i] = A[i];
    }
    int i = l, j = mid + 1;// 左右子列表的索引
    for (int curr = l; curr <= r; curr++) {// [l, r]
      if (i == mid + 1) {// 左子列表空
        A[curr] = A2[j++];
      } else if (j > r) {// 右子列表空
        A[curr] = A2[i++];
      } else if (A2[i] < A2[j]) {// 选择较小的值
        A[curr] = A2[i++];
      } else {
        A[curr] = A2[j++];
      }
    }
  }

  private void mergeSortV2(Integer[] A, int l, int r) {
    if (l == r) return;
    int mid = (l + r) / 2;
    mergeSortV2(A, l, mid);
    mergeSortV2(A, mid + 1, r);
    merge(A, l, r);
  }

  private void merge(Integer[] A, int l, int r) {
    int mid = (l + r) / 2;
    Integer[] A2 = new Integer[r + 1];
    for (int i = l; i <= r; i++) {// [l, r]
      A2[i] = A[i];
    }
    int i = l, j = mid + 1;// 左右子列表的索引
    for (int curr = l; curr <= r; curr++) {// [l, r]
      if (i == mid + 1) {// 左子列表空
        A[curr] = A2[j++];
      } else if (j > r) {// 右子列表空
        A[curr] = A2[i++];
      } else if (A2[i] < A2[j]) {// 选择较小的值
        A[curr] = A2[i++];
      } else {
        A[curr] = A2[j++];
      }
    }
  }

  public static void main(String[] args) {
    MergeSort service = new MergeSort();
    Integer[] A = DSUtil.SORT_TEST_ARRAY;

    DSUtil.println("Before", A);
    service.sort(A);
    DSUtil.println("After", A);
  }
}
