package com.spike.commons.algorithm.bean.list.link;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.spike.commons.algorithm.bean.list.ListADT;

/**
 * Description: 链表实现单元测试<br/>
 * Date: 2014-4-27 上午11:41:50
 */
public class LListTest {
  static ListADT<Integer> list = new LList<Integer>();

  public LListTest() {
  }

  /**
   * Description: <br/>
   * PRE: <br/>
   * POST: <br/>
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    System.out.println("---init begin");
    list.append(20);
    list.append(23);
    list.append(12);
    list.append(15);
    System.out.println(list);
    System.out.println(list.currPos());
    System.out.println(list.getValue());
    System.out.println("---init done");
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
  public void testMoveToPos() {
    list.moveToPos(1);
    System.out.println(list.currPos());
    System.out.println(list.getValue());

    list.moveToPos(list.length() - 1);
    System.out.println(list.currPos());
    System.out.println(list.getValue());
  }

  @Test
  public void testInsert() {
    list.moveToPos(2);
    list.insert(10);
    System.out.println(list);
  }

}
