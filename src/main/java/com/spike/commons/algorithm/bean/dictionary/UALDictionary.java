package com.spike.commons.algorithm.bean.dictionary;

import com.spike.commons.algorithm.bean.list.array.AList;
import com.spike.commons.algorithm.bean.util.Expense;

/**
 * Description: 以未排序数组列表方式实现的字典<br/>
 * Date: 2014-4-27 下午9:35:47
 */
public class UALDictionary<Key, E> implements DictionaryADT<Key, E> {
  private static final int DEFAULT_SIZE = 10;// 字典默认大小
  private AList<KVPair<Key, E>> list;// 内部数组列表

  public UALDictionary() {
    this(DEFAULT_SIZE);
  }

  public UALDictionary(int size) {
    list = new AList<KVPair<Key, E>>(size);
  }

  /* @see dictionary.DictionaryADT#clear() */
  @Override
  public void clear() {
    list.clear();
  }

  /* @see dictionary.DictionaryADT#insert(java.lang.Object, java.lang.Object) */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "1")
  public void insert(Key key, E e) {
    KVPair<Key, E> item = new KVPair<Key, E>(key, e);
    list.append(item);// 在列表末尾添加:未排序
  }

  /* @see dictionary.DictionaryADT#remove(java.lang.Object) */
  @Override
  public E remove(Key key) {
    E temp = find(key);
    if (temp != null) list.remove();
    return temp;
  }

  /**
   * 删除末尾的元素
   * @see dictionary.DictionaryADT#removeAny()
   */
  @Override
  public E removeAny() {
    if (list.length() > 0) {
      list.moveToEnd();
      list.prev();
      KVPair<Key, E> temp = list.remove();
      return temp.value();
    } else {
      return null;
    }

  }

  /* @see dictionary.DictionaryADT#find(java.lang.Object) */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "n")
  public E find(Key key) {
    // 如果找到currPos指向键值对应的元素
    for (list.moveToStart(); list.currPos() < list.length(); list.next()) {
      KVPair<Key, E> temp = list.getValue();
      if (temp.key() == key) {
        return temp.value();
      }
    }
    return null;// 未找到
  }

  /* @see dictionary.DictionaryADT#size() */
  @Override
  public int size() {
    return list.length();
  }

}
