package com.spike.commons.algorithm.bean.tree.separate;

/**
 * Description: Binary Tree Leaf<br/>
 * Date: 2014-4-27 下午5:48:30
 */
public class BTLeaf implements BTNodeADT {
  private String value;// 叶子特定元素

  public BTLeaf(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

  /* @see tree.separate.BTNodeADT#isLeaf() */
  @Override
  public boolean isLeaf() {
    return true;
  }

  /* @see tree.separate.BTNodeADT#preorderTraverse() */
  @Override
  public String traverse() {
    return value;
  }

}
