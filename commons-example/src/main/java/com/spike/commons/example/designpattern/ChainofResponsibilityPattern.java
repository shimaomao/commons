package com.spike.commons.example.designpattern;

import com.spike.commons.annotation.designpattern.DesignPattern;
import com.spike.commons.annotation.designpattern.DesignPatternContants.Pattern;
import com.spike.commons.lang.RandomUtils;

/**
 * <pre>
 * 意图：使多个对象都有机会处理请求,从而避免请求的发送者和接收者之间的耦合关系。
 * 将这些对象连成一条链,并沿着这条链传递该请求,直到有一个对象处理它为止。
 * 
 * </pre>
 * @author zhoujiagen
 */
@DesignPattern(value = Pattern.ChainofResponsibility, description = "职责链")
class ChainofResponsibilityPattern implements DesignPatternClient {

  /** 处理器抽象 */
  private abstract class HandleHelper {
    /** 下一个处理器 */
    protected HandleHelper nextHandler;

    /** 默认将请求转发为下一个处理器 */
    protected void handle() {
      if (nextHandler != null) {
        nextHandler.handle();
      } else {
        System.out.println("处理请求...");
      }
    }

    /** 设置下一个处理器 */
    public void setNextHandler(HandleHelper nextHandler) {
      this.nextHandler = nextHandler;
    }
  }

  /** 提供默认处理器 */
  private class Application extends HandleHelper {
    @Override
    public void handle() {
      System.out.println("使用应用的默认方式处理请求");
    }

  }

  private class Widget extends HandleHelper {
    @Override
    public void handle() {
      if (RandomUtils.nextBoolean()) {
        System.out.println("#Widget处理");
      } else {
        if (nextHandler != null) {// 如果存在后续的处理器，交由它处理
          nextHandler.handle();
        } else {
          System.out.println("到Widget无法处理");
        }
      }
    }
  }

  private class Dialog extends Widget {
    @Override
    public void handle() {
      if (RandomUtils.nextBoolean()) {
        System.out.println("#Dialog处理");
      } else {
        if (nextHandler != null) {// 如果存在后续的处理器，交由它处理
          nextHandler.handle();
        } else {
          System.out.println("到Dialog无法处理");
        }
      }
    }
  }

  private class Button extends Widget {
    @Override
    public void handle() {
      if (RandomUtils.nextBoolean()) {
        System.out.println("#Button处理");
      } else {
        if (nextHandler != null) {// 如果存在后续的处理器，交由它处理
          nextHandler.handle();
        } else {
          System.out.println("到Button无法处理");
        }
      }
    }
  }

  @Override
  public void usage() {
    Application application = new Application();
    Widget widget = new Widget();
    Dialog dialog = new Dialog();
    Button button = new Button();

    // 组装职责链
    button.setNextHandler(dialog);
    dialog.setNextHandler(widget);
    widget.setNextHandler(application);

    // 调用处理，多执行几次
    button.handle();

    System.out.println();

    button.handle();
  }

  public static void main(String[] args) {
    new ChainofResponsibilityPattern().usage();
  }
}
