package com.spike.commons.algorithm.bean.dictionary;

/**
 * Description: 键值对容器<br/>
 * Date: 2014-4-27 下午9:33:29
 */
public class KVPair<Key, E> {
  private Key key;
  private E value;

  KVPair() {
    this.key = null;
    this.value = null;
  }

  public KVPair(Key key, E e) {
    this.key = key;
    this.value = e;
  }

  public Key key() {
    return this.key;
  }

  public E value() {
    return this.value;
  }
}
