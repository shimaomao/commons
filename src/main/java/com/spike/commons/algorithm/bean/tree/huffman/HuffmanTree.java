package com.spike.commons.algorithm.bean.tree.huffman;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:Huffman Tree, Full Binary Tree <br/>
 * Date: 2014-4-28 上午10:52:36
 */
public class HuffmanTree<E> implements Comparable<HuffmanTree<E>> {
  private HuffmanBaseNode<E> root;

  /**
   * 叶子节点构造
   * @param element 元素
   * @param weight 权重
   */
  public HuffmanTree(E element, int weight) {
    root = new HuffmanLeafNode<E>(element, weight);
  }

  /**
   * 内部节点构造
   * @param left 左子节点
   * @param right 右子节点
   * @param weight 权重
   */
  public HuffmanTree(HuffmanBaseNode<E> left, HuffmanBaseNode<E> right, int weight) {
    root = new HuffmanInternalNode<E>(left, right, weight);
  }

  /* @see java.lang.Comparable#compareTo(java.lang.Object) */
  @Override
  public int compareTo(HuffmanTree<E> that) {
    if (weight() < that.weight()) return -1;
    else if (weight() == that.weight()) return 0;
    else return 1;
  }

  public int weight() {
    return root.weight();
  }

  public HuffmanBaseNode<E> root() {
    return this.root;
  }

  @Override
  public String toString() {
    // return root.toString();
    return render(root);
  }

  public String render(HuffmanBaseNode<E> root) {
    StringBuilder sb = new StringBuilder();
    if (root instanceof HuffmanLeafNode<?>) {
      HuffmanLeafNode<E> leaf = (HuffmanLeafNode<E>) root;
      sb.append("<" + leaf.element() + "," + root.weight() + ">");
    } else if (root instanceof HuffmanInternalNode<?>) {
      HuffmanInternalNode<E> rt = (HuffmanInternalNode<E>) root;
      sb.append("([" + rt.weight() + "] ");
      sb.append("L" + render(rt.left()) + " ");
      sb.append("R" + render(rt.right()) + ")");
    }

    return sb.toString();
  }

  /**
   * Description: 显示编码方案<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  public String showCoding() {
    StringBuilder sb = new StringBuilder();
    Map<String, String> records = new HashMap<String, String>();// 编码结果记录
    process(root, "", records);
    for (String key : records.keySet()) {
      sb.append(key + "=" + records.get(key) + "\n");
    }
    return sb.toString();
  }

  private void process(HuffmanBaseNode<E> root, String content, Map<String, String> records) {
    if (root.isLeaf()) {
      HuffmanLeafNode<E> leaf = (HuffmanLeafNode<E>) root;
      records.put(leaf.element().toString(), content);
      return;
    } else if (!root.isLeaf()) {
      HuffmanInternalNode<E> rt = (HuffmanInternalNode<E>) root;
      process(rt.left(), content + "0", records);// 左0
      process(rt.right(), content + "1", records);// 右1
    }

  }
}
