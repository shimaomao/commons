package com.spike.commons.algorithm.bean.internalsort;

import com.spike.commons.algorithm.bean.util.DSUtil;
import com.spike.commons.algorithm.bean.util.Expense;

/**
 * Description: 快速排序<br/>
 * 思想：将待排序列表按中心点pivot划分为两个子列表，将两个子列表分别排序后再合并<br/>
 * Date: 2014-5-6 下午9:03:56
 */
public class QuickSort {
  static Integer[] A = new Integer[] { 72, 6, 57, 88, 85, 42, 83, 73, 48, 60 };

  public static void main(String[] args) {
    DSUtil.println(A);

    // 测试partition
    // System.out.println(partition(A, -1, A.length - 1, 60));

    // 测试quickSort
    quickSort(A, 0, A.length - 1);
    DSUtil.println(A);
  }

  /**
   * 根据pivot划分A中[l, r]标识的子序列，返回pivot应该放置的位置索引<br/>
   * 此时左边的元素小于pivot，右边的元素大于pivot
   */
  @Expense(tag = Expense.TAG.Θ, value = "r-l+1")
  static int partition(Integer[] A, int l, int r, int pivotValue) {
    do {
      // 从小索引开始找值大于pivotValue的
      while (A[++l] < pivotValue)
        ;
      // 从大索引开始找值小于pivotValue的
      while ((r != 0) && A[--r] > pivotValue)
        ;
      // System.out.println("l=" + l + ", r=" + r);
      DSUtil.swap(A, l, r);
      // DSUtil.println(A);
    } while (l < r);
    // System.out.println("l=" + l + ", r=" + r);
    DSUtil.swap(A, l, r);
    // DSUtil.println(A);
    return l;
  }

  @Expense(tag = Expense.TAG.Θ, value = "nlogn")
  static void quickSort(Integer[] A, int i, int j) {
    int pivotIndex = findpivot(i, j);
    DSUtil.swap(A, pivotIndex, j);// 将中心点值放于数组末尾
    int pivotValue = A[j];
    int k = partition(A, i - 1, j, pivotValue);

    DSUtil.swap(A, k, j);// 将中心点值放在正确的位置

    // 递归处理左右子序列
    if ((k - i) > 1) {
      quickSort(A, i, k - 1);
    }
    if ((j - k) > 1) {
      quickSort(A, k + 1, j);
    }
  }

  // 定位中心点，方法1：中间点
  @Expense(tag = Expense.TAG.Θ, value = "1")
  static int findpivot(int i, int j) {
    return (i + j) / 2;
  }
}
