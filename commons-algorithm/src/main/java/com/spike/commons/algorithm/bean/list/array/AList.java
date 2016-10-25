package com.spike.commons.algorithm.bean.list.array;

import com.google.common.base.Preconditions;
import com.spike.commons.algorithm.bean.list.ListADT;
import com.spike.commons.algorithm.bean.util.Expense;

/**
 * Description: 基于数组的列表实现<br/>
 * Date: 2014-4-26 下午4:08:27
 */
public class AList<E> implements ListADT<E> {
  private static final int DEFAULT_SIZE = 10;// 列表默认大小
  private int maxSize;// 列表的最大容量
  private int listSize;// 当前列表元素数量
  private int curr;// 当前元素的位置
  private E[] listArray;// 持有列表元素的数组

  /**
	 * 
	 */
  public AList() {
    this(DEFAULT_SIZE);
  }

  /**
   * @param maxSize 列表最大容量
   */
  @SuppressWarnings("unchecked")
  public AList(int maxSize) {
    this.maxSize = maxSize;
    listSize = curr = 0;
    listArray = (E[]) new Object[maxSize];
  }

  /* Θ(1)@see list.ListADT#clear() */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "1")
  public void clear() {
    listSize = curr = 0;
  }

  /* @see list.ListADT#insert(java.lang.Object) */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "n")
  public void insert(E item) {
    Preconditions.checkArgument(listSize < maxSize, "List capacity exceeded!");
    for (int i = listSize; i > curr; i--) {// 将[curr, listSize-1]向后移动一位
      listArray[i] = listArray[i - 1];
    }
    listArray[curr] = item;
    listSize++;
  }

  /**
   * 对当前位置curr没有影响
   * @see list.ListADT#append(java.lang.Object)
   */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "1")
  public void append(E item) {
    Preconditions.checkArgument(listSize < maxSize, "List capacity exceeded!");
    listArray[listSize++] = item;
  }

  /* @see list.ListADT#remove() */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "n")
  public E remove() {
    if (curr < 0 || curr >= listSize) {
      return null;
    } else {
      E result = listArray[curr];
      for (int i = curr; i < listSize - 1; i++) {// 将[curr+1,
        // listSize-1]向前移动一位
        listArray[i] = listArray[i + 1];
      }
      listSize--;
      return result;
    }
  }

  /* @see list.ListADT#moveToStart() */
  @Override
  public void moveToStart() {
    curr = 0;
  }

  /**
   * 这里末尾超出实际元素一位
   * @see list.ListADT#moveToEnd()
   */
  @Override
  public void moveToEnd() {
    curr = listSize;
  }

  /* @see list.ListADT#prev() */
  @Override
  public void prev() {
    if (curr != 0) curr--;
  }

  /* @see list.ListADT#next() */
  @Override
  public void next() {
    if (curr < listSize) curr++;
  }

  /* @see list.ListADT#length() */
  @Override
  public int length() {
    return listSize;
  }

  /* @see list.ListADT#currPos() */
  @Override
  public int currPos() {
    return curr;
  }

  /* @see list.ListADT#moveToPos(int) */
  @Override
  public void moveToPos(int pos) {
    Preconditions.checkArgument((pos >= 0) && (pos <= listSize), "Pos out of range");
    curr = pos;
  }

  /* @see list.ListADT#getValue() */
  @Override
  public E getValue() {
    Preconditions.checkArgument((curr >= 0) && (curr < listSize), "No current element");
    return listArray[curr];
  }
}
