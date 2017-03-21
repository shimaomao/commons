package com.spike.commons.example.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.spike.commons.lang.CollectionUtils;

public class ForkJoinExample {

  public static void main(String[] args) {
    ForkJoinPool pool = new ForkJoinPool();
    // example 1
    Integer result = pool.invoke(new Fibonacci(10));
    System.out.println(result);

    // example 2
    List<Double> data = Lists.newArrayList();
    for (int i = 0; i <= 100; i++) {
      data.add(new Double(i));
    }
    Sum sum = new Sum(data);
    System.out.println(pool.invoke(sum));

    // example 3
    // SO I FINALLY KNOW WHY SCALA SHOULD WRAP JAVA PRIMITIVE CLASSES USING IMPLICITS
    class APartitionableTask extends PartitionableTask<AddableDouble, Double> {
      private static final long serialVersionUID = 1L;

      private List<Double> data;

      public APartitionableTask(List<Double> data, int totalSize, int threshold) {
        super(totalSize, threshold);
        this.data = data;
      }

      @Override
      public AddableDouble doCompute() {
        AddableDouble result = new AddableDouble(0d);
        for (Double d : data) {
          result = (AddableDouble) result.add(new AddableDouble(d));
        }
        return result;
      }

      @Override
      public List<PartitionableTask<AddableDouble, Double>> partition() {
        List<PartitionableTask<AddableDouble, Double>> result = Lists.newArrayList();
        List<List<Double>> datas = Lists.partition(this.data, 2);
        for (List<Double> doubles : datas) {
          APartitionableTask task = new APartitionableTask(doubles, doubles.size(), threshold);
          result.add(task);
        }
        return result;
      }
    }

    System.out.println(ForkJoins.invoke(new APartitionableTask(data, 0, 0)));
  }

  static class ForkJoins {
    private static final ForkJoinPool fjp = new ForkJoinPool();

    public static <T extends Addable<D>, D> D invoke(PartitionableTask<T, D> task) {
      return fjp.invoke(task).value();
    }
  }

  static interface Addable<T> {
    T value();

    Addable<T> add(Addable<T> t);
  }

  static class AddableDouble implements Addable<Double> {
    private Double value;

    public AddableDouble(Double value) {
      this.value = value;
    }

    @Override
    public Double value() {
      return value;
    }

    @Override
    public Addable<Double> add(Addable<Double> t) {
      return new AddableDouble(this.value() + t.value());
    }
  }

  static abstract class PartitionableTask<T extends Addable<D>, D> extends RecursiveTask<T> {
    private static final long serialVersionUID = 1L;
    protected int threshold = 10;
    protected int totalSize;

    public PartitionableTask(int totalSize, int threshold) {
      this.totalSize = totalSize;
      this.threshold = threshold;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T compute() {
      if (totalSize <= threshold) {
        return doCompute();
      } else {
        List<PartitionableTask<T, D>> tasks = Lists.newArrayList(invokeAll(this.partition()));
        T t0 = tasks.get(0).join();

        for (int i = 1, len = tasks.size(); i < len; i++) {
          t0 = (T) t0.add(tasks.get(i).join());
        }
        return t0;
      }
    }

    public abstract T doCompute();

    public abstract List<PartitionableTask<T, D>> partition();
  }

  static class Fibonacci extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 1L;
    final int n;

    public Fibonacci(int n) {
      this.n = n;
    }

    @Override
    public Integer compute() {
      if (n <= 1) return n;
      Fibonacci f1 = new Fibonacci(n - 1);
      f1.fork();
      Fibonacci f2 = new Fibonacci(n - 2);
      return f2.compute() + f1.join();
    }
  }

  static class Sum extends RecursiveTask<Double> {
    private static final long serialVersionUID = 1L;

    private int threshold;
    private List<Double> data;

    public Sum(List<Double> data) {
      Preconditions.checkNotNull(data);
      this.data = data;
      this.threshold = 10;
    }

    public Sum(List<Double> data, int threshold) {
      Preconditions.checkNotNull(data);
      this.data = data;
      this.threshold = threshold;
    }

    @Override
    public Double compute() {
      Double sum = 0d;

      if (data.size() <= threshold) {
        for (Double d : data) {
          sum += d;
        }
      } else {
        Collection<Sum> tasks = invokeAll(subTasks());
        for (Sum task : tasks) {
          sum += task.join();
        }
      }

      return sum;
    }

    private List<Sum> subTasks() {
      List<Sum> result = new ArrayList<ForkJoinExample.Sum>();

      List<List<Double>> splits = Lists.partition(this.data, 2);
      if (CollectionUtils.isNotEmpty(splits)) {
        for (List<Double> split : splits) {
          result.add(new Sum(split));
        }
      }

      return result;
    }

  }

}
