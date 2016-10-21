package com.spike.commons.example.designpattern;

import com.spike.commons.annotation.designpattern.DesignPattern;
import com.spike.commons.annotation.designpattern.DesignPatternContants.Pattern;

/**
 * <pre>
 * 意图：定义一系列的算法 ,把它们一个个封装起来 , 并且使它们可相互替换。本模式使得算法可独
 * 立于使用它的客户而变化。
 * </pre>
 * @author zhoujiagen
 */
@DesignPattern(value = Pattern.Strategy, description = "策略")
class StrategyPattern implements DesignPatternClient {

  private class Composition {
    /** 策略对象应用 */
    private Compositor compositor;

    public Composition(Compositor compositor) {
      this.compositor = compositor;
    }

    public void repair() {
      compositor.compose();
    }
  }

  /** 策略抽象 */
  private abstract class Compositor {
    public abstract void compose();
  }

  private class SimpleCompositor extends Compositor {
    @Override
    public void compose() {
      System.out.println("SimpleCompositor compose");
    }
  }

  private class TexCompositor extends Compositor {
    @Override
    public void compose() {
      System.out.println("TexCompositor compose");
    }
  }

  private class ArrayCompositor extends Compositor {
    @Override
    public void compose() {
      System.out.println("ArrayCompositor compose");
    }
  }

  @Override
  public void usage() {
    Compositor compositor = null;
    Composition composition = null;

    compositor = new SimpleCompositor();
    composition = new Composition(compositor);
    composition.repair();

    compositor = new TexCompositor();
    composition = new Composition(compositor);
    composition.repair();

    compositor = new ArrayCompositor();
    composition = new Composition(compositor);
    composition.repair();

  }

  public static void main(String[] args) {
    new StrategyPattern().usage();
  }

}
