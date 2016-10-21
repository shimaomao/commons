package com.spike.commons.example.designpattern;

import com.google.common.base.Preconditions;
import com.spike.commons.annotation.designpattern.DesignPattern;
import com.spike.commons.annotation.designpattern.DesignPatternContants.Pattern;

/**
 * <pre>
 * 意图：提供一个创建一系列相关或相互依赖对象的接口,而无需指定它们具体的类。
 * 
 * 别名：Kit
 * </pre>
 * @author zhoujiagen
 */
@DesignPattern(value = Pattern.AbstractFactory, description = "抽象工厂")
class AbstractFactoryPattern implements DesignPatternClient {

  /** 抽象工厂 */
  private interface WidgetFactory {
    Window createWindow();

    ScrollBar createScrollBar();
  }

  /** Motif具体工厂 */
  private class MotifWidgetFactory implements WidgetFactory {

    @Override
    public Window createWindow() {
      return new MotifWindow();
    }

    @Override
    public ScrollBar createScrollBar() {
      return new MotifiScrollBar();
    }
  }

  /** PM具体工厂 */
  private class PMWidgetFactory implements WidgetFactory {

    @Override
    public Window createWindow() {
      return new PMWindow();
    }

    @Override
    public ScrollBar createScrollBar() {
      return new PMScrollBar();
    }
  }

  /** 窗体抽象产品 */
  private interface Window {
  }

  private class MotifWindow implements Window {
  }

  private class PMWindow implements Window {
  }

  /** 滚动条抽象产品 */
  private interface ScrollBar {
  }

  private class MotifiScrollBar implements ScrollBar {
  }

  private class PMScrollBar implements ScrollBar {
  }

  /** 只使用抽象工厂和抽象产品 */
  @Override
  public void usage() {
    // 1 Motif
    WidgetFactory motifWidgetFactory = new MotifWidgetFactory();// 注入

    Window motifWindow = motifWidgetFactory.createWindow();
    ScrollBar motifScrollBar = motifWidgetFactory.createScrollBar();
    Preconditions.checkState(motifWindow instanceof MotifWindow);// 检查运行时实例
    Preconditions.checkState(motifScrollBar instanceof MotifiScrollBar);

    // 2 PM
    WidgetFactory pMWidgetFactory = new PMWidgetFactory();
    Window pMwindow = pMWidgetFactory.createWindow();
    ScrollBar pMscrollBar = pMWidgetFactory.createScrollBar();
    Preconditions.checkState(pMwindow instanceof PMWindow);
    Preconditions.checkState(pMscrollBar instanceof PMScrollBar);
  }

  public static void main(String[] args) {
    new AbstractFactoryPattern().usage();
  }

}
