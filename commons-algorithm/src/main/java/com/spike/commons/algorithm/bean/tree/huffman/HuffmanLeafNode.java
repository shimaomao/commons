package com.spike.commons.algorithm.bean.tree.huffman;

/**
 * Description: Huffman Leaf Node<br/>
 * Date: 2014-4-28 上午10:47:13
 */
public class HuffmanLeafNode<E> implements HuffmanBaseNode<E> {
  private E element;
  private int weight;

  /**
   * @param element 节点元素
   * @param weight 节点权重
   */
  public HuffmanLeafNode(E element, int weight) {
    this.element = element;
    this.weight = weight;
  }

  public E element() {
    return this.element;
  }

  /* @see tree.huffman.HuffmanBaseNode#isLeaf() */
  @Override
  public boolean isLeaf() {
    return true;
  }

  /* @see tree.huffman.HuffmanBaseNode#weight() */
  @Override
  public int weight() {
    return weight;
  }

  @Override
  public String toString() {
    return "<" + element + "," + weight + ">";
  }
}
