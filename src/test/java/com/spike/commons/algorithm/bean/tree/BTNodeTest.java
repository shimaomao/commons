package com.spike.commons.algorithm.bean.tree;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Description: Binary Node Unit Test<br/>
 * Date: 2014-4-27 下午5:12:12
 */
public class BTNodeTest {

  public BTNodeTest() {
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
    BTNode<String, String> A = new BTNode<String, String>("A", "A");
    BTNode<String, String> B = new BTNode<String, String>("B", "B");
    BTNode<String, String> C = new BTNode<String, String>("C", "C");
    BTNode<String, String> D = new BTNode<String, String>("D", "D");
    BTNode<String, String> E = new BTNode<String, String>("E", "E");
    BTNode<String, String> F = new BTNode<String, String>("F", "F");
    BTNode<String, String> G = new BTNode<String, String>("G", "G");
    BTNode<String, String> H = new BTNode<String, String>("H", "H");
    BTNode<String, String> I = new BTNode<String, String>("I", "I");

    A.setLeft(B);
    A.setRight(C);

    B.setRight(D);

    C.setLeft(E);
    C.setRight(F);

    E.setLeft(G);

    F.setLeft(H);
    F.setRight(I);

    System.out.println(A.preorderTraverse());
    System.out.println(A.inorderTraverse());
    System.out.println(A.postorderTraverse());
  }

}
