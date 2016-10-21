package com.spike.commons.algorithm.bean.list.link;

import com.google.common.base.Preconditions;
import com.spike.commons.algorithm.bean.list.ListADT;
import com.spike.commons.algorithm.bean.util.Expense;

/**
 * Description: 基于单向链表的列表实现<br/>
 * Date: 2014-4-26 下午5:37:24<br>
 * pos.0..........1...........2.............3........<br>
 * [/|]-->[20|]-->[23|]-|->[12|]-->[15|/]<br>
 * head...............curr.....currEle.....tail....<br/>
 */
public class LList<E> implements ListADT<E> {
  private LinkNode<E> head;// 元素为null的额外头部节点
  private LinkNode<E> tail;// 尾部节点
  private LinkNode<E> curr;// 当前节点，指向当前元素的前一节点
  private int currentSize;// 列表大小

  /**
   * 头部节点、当前节点和尾部节点均为元素为null、下一节点为null的链接节点
   */
  public LList() {
    head = curr = tail = new LinkNode<E>(null, null);
    currentSize = 0;
  }

  /* @see list.ListADT#clear() */
  @Override
  public void clear() {
    head = curr = tail = new LinkNode<E>(null, null);
    currentSize = 0;
  }

  /**
   * 在当前位置后面插入元素
   * @see list.ListADT#insert(java.lang.Object)
   */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "1")
  public void insert(E item) {
    // new -> getNext -> setNext
    curr.setNext(new LinkNode<E>(item, curr.next()));
    if (curr == tail) tail = curr.next();// 新的tail
    currentSize++;
  }

  /* @see list.ListADT#append(java.lang.Object) */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "1")
  public void append(E item) {
    // setNext -> tail=
    tail = tail.setNext(new LinkNode<E>(item, null));
    currentSize++;
  }

  /* @see list.ListADT#remove() */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "1")
  public E remove() {
    if (curr.next() == null) return null;// 初始状态特殊情况处理
    E result = curr.next().element();// 当前元素
    if (curr.next() == tail) tail = curr;// 当前元素是尾部

    curr.setNext(curr.next().next());// 删除当前元素
    currentSize--;
    return result;
  }

  /* @see list.ListADT#moveToStart() */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "1")
  public void moveToStart() {
    curr = head;
  }

  /* @see list.ListADT#moveToEnd() */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "1")
  public void moveToEnd() {
    curr = tail;
  }

  /* @see list.ListADT#prev() */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "n")
  public void prev() {
    if (curr == head) return;// 头部没有前一元素
    LinkNode<E> temp = head;
    while (temp.next() != curr) {// 从头部开始遍历直到temp的下一节点是curr
      temp = temp.next();
    }
    curr = temp;
  }

  /* @see list.ListADT#next() */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "1")
  public void next() {
    if (curr == tail) return;// 尾部没有下一元素
    curr = curr.next();
  }

  /* @see list.ListADT#length() */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "1")
  public int length() {
    return currentSize;
  }

  /* @see list.ListADT#currPos() */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "n")
  public int currPos() {
    int i;
    LinkNode<E> temp = head;
    for (i = 0; temp != curr; i++) {
      temp = temp.next();
    }
    return i;
  }

  /* @see list.ListADT#moveToPos(int) */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "n")
  public void moveToPos(int pos) {
    Preconditions.checkArgument(pos >= 0 && pos < currentSize, "Out of range");
    curr = head;
    for (int i = 0; i < pos; i++) {
      curr = curr.next();
    }
  }

  /* @see list.ListADT#getValue() */
  @Override
  @Expense(tag = Expense.TAG.Θ, value = "1")
  public E getValue() {
    if (curr.next() == null) return null;
    return curr.next().element();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    LinkNode<E> temp;
    if (currentSize > 0) {
      for (temp = head.next(); temp != tail; temp = temp.next()) {
        sb.append(temp.element() + " ");
      }
      sb.append(tail.element());
      sb.append(" [head=" + head + ", tail=" + tail + ", curr=" + curr + ", pos=" + currPos() + "]");
    }
    return sb.toString();
  }
}
