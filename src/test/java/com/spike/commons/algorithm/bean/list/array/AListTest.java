package com.spike.commons.algorithm.bean.list.array;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.spike.commons.algorithm.bean.list.ListADT;

/**
 * Description: 基于数组的列表实现单元测试<br/>
 * Date: 2014-4-26 下午4:31:43
 */
public class AListTest {

  public AListTest() {
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
    ListADT<Integer> list = new AList<Integer>(10);
    list.append(1);
    list.append(2);
    list.append(3);
    list.append(4);
    assertEquals(4, list.length());// curr=0
    assertEquals(1, list.getValue().intValue());
  }
  // public static void main(String[] args) {
  // //开启-ea开关：java -ea
  // int i = 2, j = 1;
  // assert i < j : "2 < 1 is wrong!";
  //
  // Assert.assertTrue("2 < 1 is wrong", i < j);
  // }
}
