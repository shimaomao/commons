package com.spike.commons.algorithm.bean.list;

/**
 * Description: 列表ADT<br/>
 * Date: 2014-4-26 下午3:51:50
 */
public interface ListADT<E> {
  /**
   * Description: 清空<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  void clear();

  /**
   * Description: 插入元素<br/>
   * PRE: 在当前位置插入元素<br/>
   * POST: <br/>
   * @param item 插入的元素
   */
  void insert(E item);

  /**
   * Description: 在列表末尾追加元素<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  void append(E item);

  /**
   * Description: 删除并返回当前位置的元素<br/>
   * PRE: <br/>
   * POST: <br/>
   * @return 当前位置元素
   */
  E remove();

  /**
   * Description: 将当前位置移动到列表头<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  void moveToStart();

  /**
   * Description:将当前位置移动到列表尾 <br/>
   * PRE: <br/>
   * POST: <br/>
   */
  void moveToEnd();

  /**
   * Description: 将当前位置向前移动一步<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  void prev();

  /**
   * Description: 将当前位置向后移动一步<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  void next();

  /**
   * Description: 列表中元素数量<br/>
   * PRE: <br/>
   * POST: <br/>
   * @return 列表中元素回溯两
   */
  int length();

  /**
   * Description: 获取当前位置<br/>
   * PRE: <br/>
   * POST: <br/>
   * @return 当前位置
   */
  int currPos();

  /**
   * Description:将当前位置移动到pos处 <br/>
   * PRE: <br/>
   * POST: <br/>
   * @param pos 期望的当前位置
   */
  void moveToPos(int pos);

  /**
   * Description: 获取当前位置处的元素<br/>
   * PRE: <br/>
   * POST: <br/>
   * @return 当前位置处的元素
   */
  E getValue();
}
