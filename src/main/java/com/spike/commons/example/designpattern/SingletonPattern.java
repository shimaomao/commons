package com.spike.commons.example.designpattern;

import com.spike.commons.annotation.designpattern.DesignPattern;
import com.spike.commons.annotation.designpattern.DesignPatternContants.Pattern;

/**
 * <pre>
 * 意图：保证一个类仅有一个实例,并提供一个访问它的全局访问点。
 * </pre>
 * @author zhoujiagen
 */
@DesignPattern(value = Pattern.Singleton, description = "单例")
class SingletonPattern implements DesignPatternClient {

  private final static class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
      return INSTANCE;
    }

    public void doSomething() {
      System.out.println("正在做一些事情...");
    }

  }

  @Override
  public void usage() {
    Singleton singleton = Singleton.getInstance();

    singleton.doSomething();
  }

  public static void main(String[] args) {
    new SingletonPattern().usage();
  }

}
