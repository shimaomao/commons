package com.spike.commons.example.designpattern.support;

import com.google.common.base.MoreObjects;

/** 解决器的状态：备忘录(memento) */
public class SolverState {
  private int state;

  public SolverState(int state) {
    this.state = state;
  }

  /** 对除{@link ConstraintSolver}的类隐藏这些方法，即区分宽接口、窄接口 */
  protected void setState(int state) {
    this.state = state;
  }

  protected int getState() {
    return state;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).omitNullValues().add("state", state).toString();
  }

}