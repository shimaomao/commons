package com.spike.commons.example.designpattern;

import com.spike.commons.annotation.designpattern.DesignPattern;
import com.spike.commons.annotation.designpattern.DesignPatternContants.Pattern;

/**
 * <pre>
 * 意图：为子系统中的一组接口提供一个一致的界面,Facade模式定义了一个高层接口,这个接口使得这一子系统更加容易使用。
 * </pre>
 * @author zhoujiagen
 */
@DesignPattern(value = Pattern.Facade, description = "外观")
class FacadePattern implements DesignPatternClient {

  private class Compiler {
    public void compile() {
      // 模拟编译过程
      new CompilerSystem.Scanner();

      new CompilerSystem.Parser();

      new CompilerSystem.ProgramNodeBuilder().build();

      new CompilerSystem.RISCCodeGenerator(new CompilerSystem.BytecodeStream());
    }
  }

  private static class CompilerSystem {
    static class Stream {
    }

    static class BytecodeStream extends Stream {
    }

    static abstract class CodeGenerator {
      @SuppressWarnings("unused")
      private BytecodeStream bytecodeStream = new BytecodeStream();

      public CodeGenerator(BytecodeStream bytecodeStream) {
        this.bytecodeStream = bytecodeStream;
      }

    }

    @SuppressWarnings("unused")
    static class StackMachineCodeGenerator extends CodeGenerator {
      public StackMachineCodeGenerator(BytecodeStream bytecodeStream) {
        super(bytecodeStream);
      }
    }

    static class RISCCodeGenerator extends CodeGenerator {
      public RISCCodeGenerator(BytecodeStream bytecodeStream) {
        super(bytecodeStream);
      }
    }

    static class Scanner {
    }

    static class Token {
    }

    static class Symbol {
    }

    static class Parser {
    }

    abstract static class ProgramNode {
      @SuppressWarnings("unused")
      public Token token;
      @SuppressWarnings("unused")
      public Symbol symbol;
    }

    static class StatementNode extends ProgramNode {
    }

    static class ExpressionNode extends ProgramNode {
    }

    static class VariableNode extends ProgramNode {
    }

    static class ProgramNodeBuilder {
      private StatementNode statementNode;
      private ExpressionNode expressionNode;
      private VariableNode variableNode;

      public ProgramNodeBuilder() {
        statementNode = new StatementNode();
        expressionNode = new ExpressionNode();
        variableNode = new VariableNode();
      }

      public void build() {
        statementNode.token = null;
        expressionNode.token = null;
        variableNode.token = null;
      }
    }
  }

  @Override
  public void usage() {
    new Compiler().compile();
  }

  public static void main(String[] args) {
    new FacadePattern().usage();
  }

}
