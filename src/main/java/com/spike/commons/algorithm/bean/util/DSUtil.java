package com.spike.commons.algorithm.bean.util;

/**
 * <ul>
 * <li>Author: zhoujg | Date: 2014-4-7 上午10:37:47</li>
 * <li>Description: 工具类</li>
 * </ul>
 */
public class DSUtil {
  // 单元测试
  public static void main(String[] args) {
    Integer[] A = { 1, 2, 3, 4, 5 };
    println(A);
    swap(A, 1, 3);
    println(A);
  }

  public static Integer[] SORT_TEST_ARRAY = new Integer[] { 42, 20, 17, 13, 28, 14, 23, 15 };

  public static <E> void swap(E[] A, int i, int j) {
    E temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

  public static <E> void println(E[] A) {
    for (E a : A) {
      System.out.print(a + " ");
    }
    System.out.println();
  }

  public static <E> void println(String comment, E[] A) {
    System.out.print(comment + ": ");
    for (E a : A) {
      System.out.print(a + " ");
    }
    System.out.println();
  }
}
