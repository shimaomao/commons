package com.spike.commons.algorithm.bean.tree;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Description: BST Unit Test<br/>
 * Date: 2014-4-27 下午11:20:13
 */
public class BSTTest {

  public BSTTest() {
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
    BST<Integer, String> bst = new BST<Integer, String>();
    // ref P.164
    bst.insert(37, "37");
    bst.insert(24, "24");
    bst.insert(42, "42");
    bst.insert(7, "7");
    bst.insert(2, "2");
    bst.insert(40, "40");
    bst.insert(42, "42");
    bst.insert(32, "32");
    bst.insert(120, "120");
    System.out.println(bst.size());
    System.out.println(bst);
    System.out.println(bst.checkBST());

    bst.clear();
    bst.insert(120, "120");
    bst.insert(42, "42");
    bst.insert(42, "42");
    bst.insert(7, "7");
    bst.insert(2, "2");
    bst.insert(32, "32");
    bst.insert(37, "37");
    bst.insert(24, "24");
    bst.insert(40, "40");
    System.out.println(bst.size());
    System.out.println(bst);
    System.out.println(bst.checkBST());

  }

}
