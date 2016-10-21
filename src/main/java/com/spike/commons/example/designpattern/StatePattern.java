package com.spike.commons.example.designpattern;

import com.google.common.base.Preconditions;
import com.spike.commons.annotation.designpattern.DesignPattern;
import com.spike.commons.annotation.designpattern.DesignPatternContants.Pattern;

/**
 * <pre>
 * 意图：允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它的类。
 * 
 * 别名：状态对象(Objects for States)
 * </pre>
 * @author zhoujiagen
 */
@DesignPattern(value = Pattern.State, description = "状态")
class StatePattern implements DesignPatternClient {

  /** 状态的上下文，负责维护状态的变迁及有效性验证 */
  private class TCPConnection {
    /** 对状态的引用 */
    private TCPState tcpState;

    public TCPConnection() {
      /** 初始状态 */
      this.tcpState = new TCPListen();
    }

    public void open() {
      /** 处于监听状态才可打开建立连接 */
      Preconditions.checkState(tcpState instanceof TCPListen);

      tcpState.open();
      /** 后继状态 */
      tcpState = new TCPEstablished();
    }

    public void close() {
      tcpState.close();
      /** 后继状态 */
      tcpState = new TCPClosed();
    }

    public void ack() {
      /** 处于连接状态才可确认 */
      Preconditions.checkState(tcpState instanceof TCPEstablished);

      tcpState.ack();
    }
  }

  /** 状态 */
  private abstract class TCPState {
    public void open() {
    }

    public void close() {
    }

    public void ack() {
    }
  }

  private class TCPListen extends TCPState {
    public void open() {
      System.out.println("TCPListen#open()");
    }
  }

  private class TCPEstablished extends TCPState {
    public void close() {
      System.out.println("TCPEstablished#close()");
    }

    public void ack() {
      System.out.println("TCPEstablished#ack()");
    }
  }

  private class TCPClosed extends TCPState {
  }

  @Override
  public void usage() {
    TCPConnection tcpConnection = new TCPConnection();

    tcpConnection.open();
    tcpConnection.ack();
    tcpConnection.close();

    // 关闭后再确认，这里会抛出运行时异常
    tcpConnection.ack();
  }

  public static void main(String[] args) {
    new StatePattern().usage();
  }
}
