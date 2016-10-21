package com.spike.commons.algorithm.bean.tree.btree;

/**
 * Description: B+叶子节点：B+只在叶子节点中存储数据<br/>
 * Date: 2014-4-29 上午11:31:03
 */
public class BPLeaf<Key, E> implements BPNodeADT<Key, E> {
  private int numrecs;
  private Key keys[];
  private E records[];

  public E record(int r) {
    return records[r];
  }

  public boolean delete(int which) {
    return false;
  }

  /* @see tree.btree.BPNode#isLeaf() */
  @Override
  public boolean isLeaf() {
    return true;
  }

  /* @see tree.btree.BPNode#numrecs() */
  @Override
  public int numrecs() {
    return numrecs;
  }

  /* @see tree.btree.BPNode#keys() */
  @Override
  public Key[] keys() {
    return keys;
  }

}
