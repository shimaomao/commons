package com.spike.commons.algorithm.bean.list.link;

/**
 * Description: (单向)链接节点<br/>
 * Date: 2014-4-26 下午5:27:23
 */
public class LinkNode<E> {
  private E element;// 节点中元素
  private LinkNode<E> next;// 下一节点

  /**
   * @param element 节点中元素
   * @param nextNode 下一节点
   */
  public LinkNode(E element, LinkNode<E> nextNode) {
    this.element = element;
    this.next = nextNode;
  }

  public E element() {
    return element;
  }

  /**
   * Description: 设置节点的元素<br/>
   * PRE: <br/>
   * POST: <br/>
   * @return 设置的节点元素
   */
  public E setElement(E element) {
    return this.element = element;
  }

  public LinkNode<E> next() {
    return next;
  }

  /**
   * Description:设置下一节点 <br/>
   * PRE: <br/>
   * POST: <br/>
   * @return 设置的下一节点
   */
  public LinkNode<E> setNext(LinkNode<E> next) {
    return this.next = next;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("(");
    sb.append(element == null ? "/" : element.toString());
    sb.append(",");
    sb.append(next == null ? "/" : (next.element == null ? "/" : next.element.toString()));
    sb.append(")");
    return sb.toString();
  }
}
