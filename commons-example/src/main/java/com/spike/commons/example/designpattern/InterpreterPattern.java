package com.spike.commons.example.designpattern;

import java.util.List;

import com.google.common.collect.Lists;
import com.spike.commons.annotation.designpattern.DesignPattern;
import com.spike.commons.annotation.designpattern.DesignPatternContants.Pattern;

/**
 * <pre>
 * 意图：给定一个语言,定义它的文法的一种表示,
 * 并定义一个解释器,这个解释器使用该表示来解释语言中的句子。
 * 
 * 
 * 正则表达式的文法：
 * 
 * expression ::= literal | alternation | sequence | repetition | '(' expression ')'
 * literal ::=  'a' | 'b' | 'c'
 * alternation ::= expression '|' expression
 * sequence ::= expression '&' expression
 * repetition ::= expression '*'
 * 
 * </pre>
 * @author zhoujiagen
 */
@DesignPattern(value = Pattern.Interpreter, description = "解释器")
class InterpreterPattern implements DesignPatternClient {

  private String SYMBOL_SEP = " | ";
  private String SYMBOL_AND = " & ";
  private String SYMBOL_MUL = " * ";
  private String SYMBOL_LB = " ( ";
  private String SYMBOL_RB = " ) ";

  private enum Literal {
    a('a'), b('b'), c('c'), d('d'), e('e'), f('f'), g('g'), //
    h('h'), i('i'), j('j'), k('k'), l('l'), m('m'), n('n'), //
    o('o'), p('p'), q('q'), r('r'), s('s'), t('t'), //
    u('u'), v('v'), w('w'), x('x'), y('y'), z('z');

    private char literal;

    Literal(char literal) {
      this.literal = literal;
    }

    public char get() {
      return literal;
    }
  }

  private abstract class RegularExpression {
    /** 解释 */
    public abstract String intepret();
  }

  private class LiteralExpression extends RegularExpression {
    public List<Literal> literals;

    @Override
    public String intepret() {
      StringBuffer sb = new StringBuffer();
      for (Literal literal : literals) {
        sb.append(literal.get());
      }
      return sb.toString();
    }
  }

  private class AlternationExpression extends RegularExpression {
    public RegularExpression alternative1;
    public RegularExpression alternative2;

    @Override
    public String intepret() {
      return alternative1.intepret() + SYMBOL_SEP + alternative2.intepret();
    }

  }

  private class SequenceExpression extends RegularExpression {
    public RegularExpression sequence1;
    public RegularExpression sequence2;

    @Override
    public String intepret() {
      return sequence1.intepret() + SYMBOL_AND + sequence2.intepret();
    }
  }

  private class RepetitionExpression extends RegularExpression {
    public RegularExpression repetition;

    @Override
    public String intepret() {
      if (repetition instanceof AlternationExpression || repetition instanceof SequenceExpression) {
        return SYMBOL_LB + repetition.intepret() + SYMBOL_RB + SYMBOL_MUL;
      } else {
        return repetition.intepret() + SYMBOL_MUL;
      }
    }
  }

  @Override
  public void usage() {
    // raining & (dogs | cats) *

    // 基础准备
    List<Literal> raining = Lists.newArrayList(//
      Literal.r, Literal.a, Literal.i, Literal.n, Literal.i, Literal.n, Literal.g);
    List<Literal> dogs = Lists.newArrayList(Literal.d, Literal.o, Literal.g, Literal.s);
    List<Literal> cats = Lists.newArrayList(Literal.c, Literal.a, Literal.t, Literal.s);

    // 从最内层的表示开始
    LiteralExpression rainningLE = new LiteralExpression();
    rainningLE.literals = raining;
    LiteralExpression dogsLE = new LiteralExpression();
    dogsLE.literals = dogs;
    LiteralExpression catsLE = new LiteralExpression();
    catsLE.literals = cats;

    AlternationExpression ae = new AlternationExpression();
    ae.alternative1 = dogsLE;
    ae.alternative2 = catsLE;

    RepetitionExpression re = new RepetitionExpression();
    re.repetition = ae;

    SequenceExpression se = new SequenceExpression();
    se.sequence1 = rainningLE;
    se.sequence2 = re;

    // 解释
    System.out.println(se.intepret());
  }

  public static void main(String[] args) {
    new InterpreterPattern().usage();
  }

}
