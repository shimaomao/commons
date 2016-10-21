package com.spike.commons.algorithm.bean.dictionary;

/**
 * Description: 字典ADT<br/>
 * Date: 2014-4-27 下午6:41:36
 */
public interface DictionaryADT<Key, E> {
  /**
   * Description: 清空字典<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  void clear();

  /**
   * Description: 插入(键,值)记录<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  void insert(Key key, E e);

  /**
   * Description: 按指定键删除<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  E remove(Key key);

  /**
   * Description: 删除任意一个记录，不需指定键的删除<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  E removeAny();

  /**
   * Description: 按指定键查找<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  E find(Key key);

  /**
   * Description: 获取字典中记录数大小<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  int size();
}
