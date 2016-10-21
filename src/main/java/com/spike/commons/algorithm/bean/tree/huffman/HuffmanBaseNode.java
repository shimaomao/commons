package com.spike.commons.algorithm.bean.tree.huffman;

/**
 * Description: Huffman Tree Base Node, speparate leaf and internal node<br/>
 * Date: 2014-4-28 上午10:45:25
 */
public interface HuffmanBaseNode<E> {
  /**
   * Description: return true if is a leaf<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  boolean isLeaf();

  /**
   * Description: return weight of node<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  int weight();
}
