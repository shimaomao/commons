package com.spike.commons.algorithm.bean.tree;

/**
 * Description: Binary Tree node implementation，不区分叶子和内部节点<br/>
 * Date: 2014-4-27 下午4:45:00
 */
class BTNode<Key, E> implements BTNodeADT<E> {
  private Key key;// 节点的键
  private E element;// 节点数据元素
  private BTNode<Key, E> left;// 左子节点
  private BTNode<Key, E> right;// 右子节点

  public BTNode() {
    key = null;
    element = null;
    left = right = null;
  }

  public BTNode(Key key, E element) {
    this.key = key;
    this.element = element;
    left = right = null;
  }

  public BTNode(Key key, E element, BTNode<Key, E> left, BTNode<Key, E> right) {
    this.key = key;
    this.element = element;
    this.left = left;
    this.right = right;
  }

  public Key key() {
    return key;
  }

  public void setKey(Key key) {
    this.key = key;
  }

  /* @see tree.BTNodeADT#element() */
  @Override
  public E element() {
    return element;
  }

  /* @see tree.BTNodeADT#setElement(java.lang.Object) */
  @Override
  public void setElement(E e) {
    this.element = e;
  }

  /* @see tree.BTNodeADT#left() */
  @Override
  public BTNode<Key, E> left() {
    return this.left;
  }

  /* @see tree.BTNodeADT#right() */
  @Override
  public BTNode<Key, E> right() {
    return this.right;
  }

  /* @see tree.BTNodeADT#isLeaft() */
  @Override
  public boolean isLeaft() {
    return ((left == null) && (right == null));
  }

  /**
   * Description: 从该节点开始前序遍历<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  public String preorderTraverse() {
    StringBuilder sb = new StringBuilder();
    sb.append(element());
    if (left != null) {
      sb.append(left.preorderTraverse());
    }
    if (right != null) {
      sb.append(right.preorderTraverse());
    }
    return sb.toString();
  }

  /**
   * Description: 从该节点开始中序遍历<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  public String inorderTraverse() {
    StringBuilder sb = new StringBuilder();
    if (left != null) {
      sb.append(left.inorderTraverse());
    }
    sb.append(element());
    if (right != null) {
      sb.append(right.inorderTraverse());
    }
    return sb.toString();
  }

  /**
   * Description: 从该节点开始后续遍历<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  public String postorderTraverse() {
    StringBuilder sb = new StringBuilder();
    if (left != null) {
      sb.append(left.postorderTraverse());
    }
    if (right != null) {
      sb.append(right.postorderTraverse());
    }
    sb.append(element());
    return sb.toString();
  }

  public BTNode<Key, E> setLeft(BTNode<Key, E> left) {
    return this.left = left;
  }

  public BTNode<Key, E> setRight(BTNode<Key, E> right) {
    return this.right = right;
  }

}
