package com.spike.commons.algorithm.bean.tree.heap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Description: min heap unit test<br/>
 * Date: 2014-4-28 上午10:00:57
 */
public class MinHeapTest {

  public MinHeapTest() {
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
    // self organize min heap
    Integer[] heap = new Integer[] { 7, 6, 5, 4, 3, 2, 1 };
    MinHeap<Integer> minHeap = new MinHeap<Integer>(heap, heap.length, 10);
    System.out.println(minHeap);
    System.out.println();

    // predefined min heap 1
    Integer[] heap2 = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
    MinHeap<Integer> minHeap2 = new MinHeap<Integer>(heap2, heap2.length, 10);
    System.out.println(minHeap2);
    minHeap2.remove(4);
    System.out.println(minHeap2);
    System.out.println();
  }

  @Test
  public void testRemoveMin() {
    Integer[] heap = new Integer[] { 7, 6, 5, 4, 3, 2, 1 };
    MinHeap<Integer> minHeap = new MinHeap<Integer>(heap, heap.length, 10);
    System.out.println(minHeap);
    System.out.println(minHeap.removemin());
    System.out.println(minHeap);
  }

  @Test
  public void testRemoveMin2() {
    Integer[] heap = new Integer[] { 32, 42, 120, 7, 42, 24, 37, 2 };
    MinHeap<Integer> minHeap = new MinHeap<Integer>(heap, heap.length, heap.length);
    System.out.println(minHeap);
    while (minHeap.heapsize() > 0) {
      System.out.println(minHeap.removemin());
    }
    System.out.println(minHeap);
  }
}
