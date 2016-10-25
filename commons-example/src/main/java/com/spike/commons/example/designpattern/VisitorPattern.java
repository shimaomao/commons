package com.spike.commons.example.designpattern;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.spike.commons.annotation.designpattern.DesignPattern;
import com.spike.commons.annotation.designpattern.DesignPatternContants.Pattern;

/**
 * <pre>
 * 意图：表示一个作用于某对象结构中的各元素的操作。
 * 它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。
 * 
 * </pre>
 * @author zhoujiagen
 */
@DesignPattern(value = Pattern.Visitor, description = "访问者")
class VisitorPattern implements DesignPatternClient {

  private class Program {
    private List<Node> nodes = Lists.newArrayList();

    public Program(List<Node> nodes) {
      this.nodes = nodes;
    }

    public void addNode(Node node) {
      nodes.add(node);
    }

    public void removeNode(Node node) {
      nodes.remove(node);
    }

    public void doStuff(NodeVisitor nodeVisitor) {
      Preconditions.checkNotNull(nodeVisitor);

      for (Node node : nodes) {
        node.accept(nodeVisitor);
      }
    }

  }

  /** 类层次1：接受操作的元素 */
  private abstract class Node {
    /** 接受操作并执行相应处理 */
    public abstract void accept(NodeVisitor nodeVisitor);
  }

  private class AssignmentNode extends Node {
    @Override
    public void accept(NodeVisitor nodeVisitor) {
      Preconditions.checkNotNull(nodeVisitor);

      nodeVisitor.visitAssignment();
    }
  }

  private class VariableRefNode extends Node {
    @Override
    public void accept(NodeVisitor nodeVisitor) {
      Preconditions.checkNotNull(nodeVisitor);

      nodeVisitor.visitVariableRef();
    }
  }

  /** 类层次2：定义对元素的操作的访问者 */
  private abstract class NodeVisitor {
    public abstract void visitAssignment();

    public abstract void visitVariableRef();
  }

  private class TypeCheckingVisitor extends NodeVisitor {

    @Override
    public void visitAssignment() {
      System.out.println("TypeCheckingVisitor#visitAssignment");
    }

    @Override
    public void visitVariableRef() {
      System.out.println("TypeCheckingVisitor#visitVariableRef");
    }
  }

  private class CodeGeneratingVisitor extends NodeVisitor {

    @Override
    public void visitAssignment() {
      System.out.println("CodeGeneratingVisitor#visitAssignment");
    }

    @Override
    public void visitVariableRef() {
      System.out.println("CodeGeneratingVisitor#visitVariableRef");
    }
  }

  @Override
  public void usage() {
    Node assignmentNode = new AssignmentNode();
    Node variableRefNode = new VariableRefNode();

    NodeVisitor typeCheckingVisitor = new TypeCheckingVisitor();
    NodeVisitor codeGeneratingVisitor = new CodeGeneratingVisitor();

    List<Node> nodes = Lists.newArrayList(assignmentNode, variableRefNode);
    Program program = new Program(nodes);

    program.addNode(new AssignmentNode());
    program.addNode(new VariableRefNode());

    program.removeNode(variableRefNode);

    // 类型检查
    program.doStuff(typeCheckingVisitor);

    System.out.println();

    // 代码生成
    program.doStuff(codeGeneratingVisitor);
  }

  public static void main(String[] args) {
    new VisitorPattern().usage();
  }

}
