package com.spike.commons.example.designpattern;

import java.util.ArrayList;
import java.util.LinkedList;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.spike.commons.annotation.comment.WebReferenceUrl;
import com.spike.commons.annotation.designpattern.DesignPattern;
import com.spike.commons.annotation.designpattern.DesignPatternContants.Pattern;
import com.spike.commons.lang.RandomUtils;

/**
 * <pre>
 * 意图：提供一种方法顺序访问一个聚合对象中各个元素 , 而又不需暴露该对象的内部表示。
 * 
 * 别名：游标(Cursor)
 * </pre>
 * @author zhoujiagen
 */
@DesignPattern(value = Pattern.Iterator, description = "迭代器")
class IteratorPattern implements DesignPatternClient {

  private abstract class AbstractList<E> {
    public abstract Iteraor<E> iterator();

    public abstract int count();

    public abstract void add(E element);

    public abstract void remove(int index);

    public abstract E get(int index);
  }

  private class List<E> extends AbstractList<E> {
    /** 方便起见使用的已有实现 */
    private ArrayList<E> delegate = Lists.newArrayList();

    @Override
    public Iteraor<E> iterator() {
      // 知悉相应的迭代器
      return new ListIterator<E>(this);
    }

    @Override
    public int count() {
      return delegate.size();
    }

    @Override
    public void add(E element) {
      delegate.add(element);
    }

    @Override
    public void remove(int index) {
      delegate.remove(index);
    }

    @Override
    public E get(int index) {
      return delegate.get(index);
    }
  }

  @WebReferenceUrl(title = "跳跃列表",
      url = "https://zh.wikipedia.org/wiki/%E8%B7%B3%E8%B7%83%E5%88%97%E8%A1%A8")
  private class SkipList<E> extends AbstractList<E> {

    /** 层数，不包括最底层 */
    private int levels;

    /** 最底层的链表 */
    private LinkedList<E> lowestLinkedList = Lists.newLinkedList();

    private ArrayList<LinkedList<E>> innerList;

    public SkipList(int levels) {
      this.levels = levels;
      innerList = new ArrayList<LinkedList<E>>(levels);
    }

    @Override
    public Iteraor<E> iterator() {
      // 知悉相应的迭代器
      return new SkipListIterator<E>(this);
    }

    @Override
    public int count() {
      return lowestLinkedList.size();
    }

    @Override
    public void add(E element) {
      add(0, element);// 添加到最底层

      int randomLevel = RandomUtils.nextInt(1, levels);
      add(randomLevel, element);// 随机加入上面的某一层
    }

    /** level 从1开始 */
    public void add(int level, E element) {
      Preconditions.checkArgument(level >= 0 && level <= innerList.size());

      lowestLinkedList.add(element);
      if (level != 0) {
        innerList.get(level).add(element);
      }
    }

    @Override
    public void remove(int index) {
      E element = lowestLinkedList.remove(index);

      for (LinkedList<E> linkedList : innerList) {
        linkedList.remove(element);// 这个存在错误
      }
    }

    @Override
    public E get(int index) {
      return lowestLinkedList.get(index);
    }

  }

  /** 迭代器抽象 */
  private abstract class Iteraor<E> {
    protected int index;

    public abstract E first();

    public abstract E next();

    public abstract boolean isDone();

    public abstract E current();
  }

  /** 具体的迭代器实现1 */
  private class ListIterator<E> extends Iteraor<E> {
    /** 对相应列表类的引用 */
    private List<E> list;

    public ListIterator(List<E> list) {
      this.list = list;
    }

    @Override
    public E first() {
      index = 0;
      return list.get(0);
    }

    @Override
    public E next() {
      Preconditions.checkState(index < list.count());

      return list.get(index++);
    }

    @Override
    public boolean isDone() {
      return index == list.count();
    }

    @Override
    public E current() {
      return list.get(index);
    }

  }

  /** 具体的迭代器实现2 */
  private class SkipListIterator<E> extends Iteraor<E> {
    /** 对相应列表类的引用 */
    private SkipList<E> list;

    public SkipListIterator(SkipList<E> list) {
      this.list = list;
    }

    @Override
    public E first() {
      index = 0;
      return list.get(0);
    }

    @Override
    public E next() {
      Preconditions.checkState(index < list.count());

      return list.get(index++);
    }

    @Override
    public boolean isDone() {
      return index == list.count();
    }

    @Override
    public E current() {
      return list.get(index);
    }

  }

  @Override
  public void usage() {
    // 1 List
    AbstractList<Integer> list = new List<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(1);

    Iteraor<Integer> iteraor = list.iterator();
    Preconditions.checkState(iteraor instanceof ListIterator);
    while (!iteraor.isDone()) {
      System.out.print(iteraor.next() + " ");
    }
    System.out.println();

    // 2 SkipList
    list = new SkipList<Integer>(3);
    list.add(11);
    list.add(22);
    list.add(33);
    list.add(11);

    iteraor = list.iterator();
    Preconditions.checkState(iteraor instanceof SkipListIterator);
    while (!iteraor.isDone()) {
      System.out.print(iteraor.next() + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    new IteratorPattern().usage();
  }

}
