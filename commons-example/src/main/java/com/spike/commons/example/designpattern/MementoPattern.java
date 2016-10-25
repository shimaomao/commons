package com.spike.commons.example.designpattern;

import com.google.common.base.Function;
import com.spike.commons.annotation.designpattern.DesignPattern;
import com.spike.commons.example.designpattern.support.ConstraintSolver;
import com.spike.commons.example.designpattern.support.SolverState;
import com.spike.commons.annotation.designpattern.DesignPatternContants.Pattern;

/**
 * <pre>
 * 意图：在不破坏封装性的前提下,捕获一个对象的内部状态,并在该对象之外保存这个状态。
 * 这样以后就可将该对象恢复到原先保存的状态。
 * 
 * 别名：Token
 * </pre>
 * @author zhoujiagen
 * @see ConstraintSolver
 * @see SolverState
 */
@DesignPattern(value = Pattern.Memento, description = "备忘录")
class MementoPattern implements DesignPatternClient {

  private class Caretaker {
    private ConstraintSolver constraintSolver;
    private SolverState solverState;

    public void solve(Function<ConstraintSolver, Void> function) {
      constraintSolver = new ConstraintSolver();

      // 创建备忘录
      solverState = constraintSolver.createSolverState();

      function.apply(constraintSolver);

      // 将备忘录送回原发器
      constraintSolver.setSolverState(solverState);
    }

  }

  @Override
  public void usage() {
    Caretaker caretaker = new Caretaker();

    // 模拟ConstraintSolver处理更新其内部的SolverState
    Function<ConstraintSolver, Void> function = new Function<ConstraintSolver, Void>() {
      @Override
      public Void apply(ConstraintSolver input) {
        input.doSolveStep();
        input.doSolveStep();
        return null;
      }
    };
    caretaker.solve(function);
  }

  public static void main(String[] args) {
    new MementoPattern().usage();
  }
}
