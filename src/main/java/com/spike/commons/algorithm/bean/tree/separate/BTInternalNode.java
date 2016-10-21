package com.spike.commons.algorithm.bean.tree.separate;

/**
 * Description: Binary Tree Internal Node<br/>
 * Date: 2014-4-27 下午5:49:28
 */
public class BTInternalNode implements BTNodeADT {
  private char value;// 内部节点特定元素
  private BTNodeADT left;// 左子节点
  private BTNodeADT right;// 右子节点

  public BTInternalNode(char value, BTNodeADT left, BTNodeADT right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  /* @see tree.separate.BTNodeADT#isLeaf() */
  @Override
  public boolean isLeaf() {
    return false;
  }

  /* @see tree.separate.BTNodeADT#preorderTraverse() */
  @Override
  public String traverse() {
    StringBuilder sb = new StringBuilder();

    if (left != null) sb.append(left.traverse());
    sb.append(value);
    if (right != null) sb.append(right.traverse());

    return sb.toString();
  }
}
