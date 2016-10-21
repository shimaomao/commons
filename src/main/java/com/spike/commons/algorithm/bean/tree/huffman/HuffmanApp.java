package com.spike.commons.algorithm.bean.tree.huffman;

import com.spike.commons.algorithm.bean.tree.heap.MinHeap;

/**
 * Description: <br/>
 * Date: 2014-4-28 下午1:47:04
 */
public class HuffmanApp<E> {

  public HuffmanTree<Character> buildHuffmanTree(HuffmanTree<Character>[] elements) {
    HuffmanTree<Character> temp1, temp2, temp3 = null;
    MinHeap<HuffmanTree<Character>> minHeap =
        new MinHeap<HuffmanTree<Character>>(elements, elements.length, elements.length);
    while (minHeap.heapsize() >= 2) {
      // 删除并获取最小堆中两个最小的元素
      temp1 = minHeap.removemin();
      temp2 = minHeap.removemin();
      temp3 =
          new HuffmanTree<Character>(temp1.root(), temp2.root(), temp1.weight() + temp2.weight());
      // System.out.println(temp1.weight() + "+" + temp2.weight() + "=>" +
      // temp3.weight());
      minHeap.insert(temp3);
    }
    return temp3;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static void main(String[] args) {
    HuffmanApp<Character> app = new HuffmanApp<Character>();

    HuffmanTree<Character> C = new HuffmanTree<Character>('C', 32);
    HuffmanTree<Character> D = new HuffmanTree<Character>('D', 42);
    HuffmanTree<Character> EE = new HuffmanTree<Character>('E', 120);
    HuffmanTree<Character> K = new HuffmanTree<Character>('K', 7);
    HuffmanTree<Character> L = new HuffmanTree<Character>('L', 42);
    HuffmanTree<Character> M = new HuffmanTree<Character>('M', 24);
    HuffmanTree<Character> U = new HuffmanTree<Character>('U', 37);
    HuffmanTree<Character> Z = new HuffmanTree<Character>('Z', 2);

    HuffmanTree[] array = new HuffmanTree[] { C, D, EE, K, L, M, U, Z };
    HuffmanTree<Character> root = app.buildHuffmanTree(array);
    System.out.println(root.root());
    System.out.println(root);

    System.out.println(root.showCoding());
  }
}
