package com.spike.commons.algorithm.bean.tree.btree;

/**
 * Description: B+内部节点<br/>
 * Date: 2014-4-29 下午12:18:28
 */
public class BPInternal<Key, E> implements BPNodeADT<Key, E> {
  private int numrecs;
  private Key keys[];
  private BPNodeADT<Key, E> pointers[];

  /* @see tree.btree.BPNode#isLeaf() */
  @Override
  public boolean isLeaf() {
    return false;
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

  public BPInternal<Key, E> add(BPInternal<Key, E> ptr) {
    return null;
  }

  public boolean underflow(int which) {
    return false;
  }

  public BPNodeADT<Key, E> pointers(int which) {
    return pointers[which];
  }

}
