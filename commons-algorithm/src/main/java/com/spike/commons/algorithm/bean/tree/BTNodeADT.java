package com.spike.commons.algorithm.bean.tree;

/**
 * Description: Binary Tree Node ADT<br/>
 * Date: 2014-4-27 下午12:35:45
 */
public interface BTNodeADT<E> {
  /**
   * Description: get node's element<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  public E element();

  /**
   * Description: set node's element<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  public void setElement(E e);

  /**
   * Description: get left child node<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  public BTNodeADT<E> left();

  /**
   * Description: get right child node<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  public BTNodeADT<E> right();

  /**
   * Description: return true if this node is a leaf<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  public boolean isLeaft();

}
