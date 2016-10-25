package com.spike.commons.algorithm.bean.tree.heap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Description: max heap unit test<br/>
 * Date: 2014-4-28 上午10:00:57
 */
public class MaxHeapTest {

  public MaxHeapTest() {
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
    // self organize max heap
    Integer[] heap = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
    MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(heap, heap.length, 10);
    System.out.println(maxHeap);
    System.out.println();

    // predefined max heap 1
    Integer[] heap2 = new Integer[] { 7, 3, 6, 2, 1, 5, 4 };
    MaxHeap<Integer> maxHeap2 = new MaxHeap<Integer>(heap2, heap2.length, 10);
    System.out.println(maxHeap2);
    maxHeap2.remove(4);
    System.out.println(maxHeap2);
    System.out.println();

    // predefined max heap 2
    Integer[] heap3 = new Integer[] { 7, 6, 3, 5, 4, 2, 1 };
    MaxHeap<Integer> maxHeap3 = new MaxHeap<Integer>(heap3, heap3.length, 10);
    System.out.println(maxHeap3);
    maxHeap3.remove(1);
    System.out.println(maxHeap3);
  }

  @Test
  public void testRemoveMax() {
    Integer[] heap = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
    MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(heap, heap.length, 10);
    System.out.println(maxHeap);
    System.out.println(maxHeap.removemax());
    System.out.println(maxHeap);

  }
}
