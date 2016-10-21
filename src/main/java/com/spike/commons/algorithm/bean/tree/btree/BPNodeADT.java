package com.spike.commons.algorithm.bean.tree.btree;

/**
 * Description: B+ Node<br/>
 * Date: 2014-4-29 上午11:28:10
 */
// TODO B+ Tree
public interface BPNodeADT<Key, E> {
  boolean isLeaf();

  int numrecs();

  Key[] keys();
}
