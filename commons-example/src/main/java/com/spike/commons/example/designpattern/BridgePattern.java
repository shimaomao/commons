package com.spike.commons.example.designpattern;

import com.spike.commons.annotation.designpattern.DesignPattern;
import com.spike.commons.annotation.designpattern.DesignPatternContants.Pattern;

/**
 * <pre>
 * 意图：将抽象部分与它的实现部分分离,使它们都可以独立地变化。
 * 
 * 别名：Handle/Body
 * </pre>
 * @author zhoujiagen
 */
@DesignPattern(value = Pattern.Bridge, description = "桥接")
class BridgePattern implements DesignPatternClient {

  /** 抽象部分 */
  private abstract class Window {
    /** 聚合实现部分 */
    private WindowImpl impl;

    public Window(WindowImpl impl) {
      this.impl = impl;
    }

    public void drawText() {
      impl._drawText();
    }

    public void drawRect() {
      impl._drawLine();
      impl._drawLine();
      impl._drawLine();
      impl._drawLine();
    }
  }

  private class IconWindow extends Window {
    public IconWindow(WindowImpl impl) {
      super(impl);
    }

    public void drawBorder() {
      this.drawRect();
      this.drawText();
    }

  }

  private class TransientWindow extends Window {

    public TransientWindow(WindowImpl impl) {
      super(impl);
    }

    public void drawCloseBox() {
      this.drawRect();
    }
  }

  /** 实现部分 */
  private abstract class WindowImpl {
    public abstract void _drawText();

    public abstract void _drawLine();
  }

  private class XWindowImpl extends WindowImpl {

    private void __XdrawLine() {
    }

    private void __XdrawString() {
    }

    @Override
    public void _drawText() {
      this.__XdrawString();
    }

    @Override
    public void _drawLine() {
      this.__XdrawLine();
    }
  }

  private class PMWindowImpl extends WindowImpl {

    private void __PMdrawLine() {
    }

    private void __PMdrawString() {
    }

    @Override
    public void _drawText() {
      this.__PMdrawString();
    }

    @Override
    public void _drawLine() {
      this.__PMdrawLine();
    }

  }

  @Override
  public void usage() {
    WindowImpl xWindowImpl = new XWindowImpl();
    IconWindow iconWindow = new IconWindow(xWindowImpl);
    iconWindow.drawRect();// 父类方法
    iconWindow.drawText();
    iconWindow.drawBorder();// 扩展方法

    WindowImpl pmWindowImpl = new PMWindowImpl();
    TransientWindow transientWindow = new TransientWindow(pmWindowImpl);
    transientWindow.drawRect();// 父类方法
    transientWindow.drawText();
    transientWindow.drawCloseBox();// 扩展方法
  }

  public static void main(String[] args) {
    new BridgePattern().usage();
  }

}
