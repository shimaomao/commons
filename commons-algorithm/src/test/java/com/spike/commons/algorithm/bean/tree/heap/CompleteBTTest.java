package com.spike.commons.algorithm.bean.tree.heap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Description: Complete Binary Tree Unit Test<br/>
 * Date: 2014-4-27 下午6:27:09
 */
public class CompleteBTTest {

  public CompleteBTTest() {
  }

  /**
   * Description: <br/>
   * PRE: <br/>
   * POST: <br/>
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  /**
   * Description: <br/>
   * PRE: <br/>
   * POST: <br/>
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  /**
   * Description: <br/>
   * PRE: <br/>
   * POST: <br/>
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * Description: <br/>
   * PRE: <br/>
   * POST: <br/>
   */
  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test() {
    int n = 12;
    Integer[] array = new Integer[n];
    for (int i = 0; i < n; i++) {
      array[i] = i;
      System.out.printf("%-4s\t", array[i]);
    }
    System.out.println();

    CompleteBT<Integer> cbt = new CompleteBT<Integer>(array);

    for (int i = 0; i < n; i++) {
      System.out.printf("%-4s\t", cbt.parent(i));
    }
    System.out.println();

    for (int i = 0; i < n; i++) {
      System.out.printf("%-4s\t", cbt.leftChild(i));
    }
    System.out.println();

    for (int i = 0; i < n; i++) {
      System.out.printf("%-4s\t", cbt.rightChild(i));
    }
    System.out.println();

    for (int i = 0; i < n; i++) {
      System.out.printf("%-4s\t", cbt.leftSibling(i));
    }
    System.out.println();

    for (int i = 0; i < n; i++) {
      System.out.printf("%-4s\t", cbt.rightSibling(i));
    }
    System.out.println();

  }
}
