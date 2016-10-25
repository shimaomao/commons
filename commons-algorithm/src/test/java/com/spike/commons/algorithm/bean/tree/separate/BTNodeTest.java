package com.spike.commons.algorithm.bean.tree.separate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Description: Binary Tree Node separate leaf and internal node Unit Test<br/>
 * Date: 2014-4-27 下午5:55:02
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
    BTInternalNode root =
        new BTInternalNode('-', new BTInternalNode('*', new BTInternalNode('*', new BTLeaf("4"),
            new BTLeaf("x")), new BTInternalNode('+', new BTInternalNode('*', new BTLeaf("2"),
            new BTLeaf("x")), new BTLeaf("a"))), new BTLeaf("c"));
    System.out.println(root.traverse());
  }
}
