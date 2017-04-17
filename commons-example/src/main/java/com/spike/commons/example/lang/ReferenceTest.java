package com.spike.commons.example.lang;

import java.util.ArrayList;
import java.util.List;

public class ReferenceTest {

  static class TaskContext {
    protected Integer id = 0;
    protected int intValue = 0;
    protected Integer intergetValue = 0;
    protected List<Double> values = new ArrayList<>();

    public void addValue(int delta) {
      intValue += delta;
    }

    public void addValue(Integer delta) {
      intergetValue += delta;
    }

    public void addValue(Double d) {
      values.add(d);
    }

    // getter/setter
    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public int getIntValue() {
      return intValue;
    }

    public Integer getIntergetValue() {
      return intergetValue;
    }

    public List<Double> getValues() {
      return values;
    }

    @Override
    public String toString() {
      return "TaskContext [id=" + id + ", intValue=" + intValue + ", intergetValue="
          + intergetValue + ", values=" + values + "]";
    }
  }

  static class StepContext extends TaskContext {
    private Integer index;

    public StepContext(TaskContext taskContext) {
      super.id = taskContext.getId();
      super.intValue = taskContext.getIntValue();
      super.intergetValue = taskContext.getIntergetValue();
      super.values = taskContext.getValues();
    }

    // getter/setter
    public Integer getIndex() {
      return index;
    }

    public void setIndex(Integer index) {
      this.index = index;
    }

    @Override
    public String toString() {
      return "StepContext [index=" + index + ", id=" + id + ", intValue=" + intValue
          + ", intergetValue=" + intergetValue + ", values=" + values + "]";
    }

  }

  public static void main(String[] args) {
    TaskContext taskContext = new TaskContext();
    taskContext.setId(0);

    // TaskContext: int, Integer, List<Double>均改变
    System.out.println(taskContext);
    doTask(taskContext);
    System.out.println(taskContext);

    // StepContext: int, Integer, List<Double>均改变
    // TaskContext: List<Double>改变
    StepContext stepContext = new StepContext(taskContext);
    stepContext.setIndex(0);
    System.out.println(stepContext);
    doStep(stepContext);
    System.out.println(stepContext);
    System.out.println(taskContext);
  }

  private static void doTask(TaskContext taskContext) {
    taskContext.addValue(2);
    taskContext.addValue(new Integer(3));
    taskContext.addValue(4d);
  }

  private static void doStep(StepContext stepContext) {
    stepContext.addValue(22);
    stepContext.addValue(new Integer(33));
    stepContext.addValue(44d);
  }

}
