package com.spike.commons.algorithm.bean.tree.huffman;

/**
 * Description: Huffman Internal Node<br/>
 * Date: 2014-4-28 上午10:47:43
 */
public class HuffmanInternalNode<E> implements HuffmanBaseNode<E> {
  private HuffmanBaseNode<E> left;// 左子节点
  private HuffmanBaseNode<E> right;// 右子节点
  private int weight;// 权重

  /**
   * @param left 左子节点
   * @param right 右子节点
   * @param weight 权重
   */
  public HuffmanInternalNode(HuffmanBaseNode<E> left, HuffmanBaseNode<E> right, int weight) {
    super();
    this.left = left;
    this.right = right;
    this.weight = weight;
  }

  /* @see tree.huffman.HuffmanBaseNode#isLeaf() */
  @Override
  public boolean isLeaf() {
    return false;
  }

  /* @see tree.huffman.HuffmanBaseNode#weight() */
  @Override
  public int weight() {
    return weight;
  }

  public HuffmanBaseNode<E> left() {
    return this.left;
  }

  public HuffmanBaseNode<E> right() {
    return this.right;
  }

  @Override
  public String toString() {
    return "([" + weight + "] L" + left.toString() + " R" + right.toString() + ")";// 左0右1
  }

}
