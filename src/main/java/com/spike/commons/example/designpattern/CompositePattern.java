package com.spike.commons.example.designpattern;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * <pre>
 * 意图：将对象组合成树形结构以表示“部分-整体”的层次结构。
 * Composite使得用户对单个对象和组合对象的使用具有一致性。
 * 
 * </pre>
 * @author zhoujiagen
 */
class CompositePattern implements DesignPatternClient {

  /** 图元和图元的容器(container)抽象 */
  private abstract class Graphic {
    public abstract void draw();

    /** 作为容器的方法，提供模式实现，因为这里大部分子类不需要使用 */
    public void add(Graphic graphic) {
    }

    public void remove(Graphic graphic) {
    }

    public Graphic getChild(int index) {
      return null;
    }
  }

  private class Line extends Graphic {
    @Override
    public void draw() {
      System.out.println("draw Line");
    }
  }

  private class Rectangle extends Graphic {
    @Override
    public void draw() {
      System.out.println("draw Rectangle");
    }
  }

  private class Text extends Graphic {
    @Override
    public void draw() {
      System.out.println("draw Text");
    }
  }

  private class Picture extends Graphic {

    private List<Graphic> children = Lists.newArrayList();

    @Override
    public void draw() {
      System.out.println("draw Picture");

      System.out.println("[children: ");
      for (Graphic graphic : children) {
        graphic.draw();
      }

      System.out.println("]");
    }

    @Override
    public void add(Graphic graphic) {
      children.add(graphic);
    }

    @Override
    public void remove(Graphic graphic) {
      // 太粗糙，需要具体实现类的equals, hashCode
      children.remove(graphic);
    }

    @Override
    public Graphic getChild(int index) {
      return children.get(index);
    }

  }

  @Override
  public void usage() {
    Graphic pictureContainer = new Picture();

    Graphic innerPictureContainer = new Picture();
    innerPictureContainer.add(new Text());
    innerPictureContainer.add(new Line());
    innerPictureContainer.add(new Rectangle());

    pictureContainer.add(innerPictureContainer);
    pictureContainer.add(new Line());
    pictureContainer.add(new Rectangle());

    pictureContainer.draw();
    Graphic child = pictureContainer.getChild(1);
    Preconditions.checkState(child instanceof Line);

    pictureContainer.remove(child);
    child = pictureContainer.getChild(1);
    Preconditions.checkState(child instanceof Rectangle);
  }

  public static void main(String[] args) {
    new CompositePattern().usage();
  }

}
