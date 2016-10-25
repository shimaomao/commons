package com.spike.commons.example.designpattern;

import java.util.List;
import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.spike.commons.annotation.designpattern.DesignPattern;
import com.spike.commons.annotation.designpattern.DesignPatternContants.Pattern;

/**
 * <pre>
 * 意图：运用共享技术有效地支持大量细粒度的对象。
 * </pre>
 * @author zhoujiagen
 */
@DesignPattern(value = Pattern.Flyweight, description = "享元")
class FlyweightPattern implements DesignPatternClient {

  /** 享元：字形抽象类 */
  private abstract class Glyph {
    public abstract void draw(Context context);
  }

  /** 具体享元，被共享：字符字形 */
  private class CharacterGlyph extends Glyph {
    /** 内部状态 */
    public char c;

    public CharacterGlyph(char c) {
      this.c = c;
    }

    @Override
    public void draw(Context context) {
      System.out.println(context + ", c=" + c);
    }
  }

  /** 不共享的具体享元: 行 */
  private class Row extends Glyph {
    /** 聚合 */
    private List<Glyph> children = Lists.newArrayList();

    @Override
    public void draw(Context context) {
      for (Glyph child : children) {
        child.draw(context);
      }
    }

    public void add(Glyph glyph) {
      children.add(glyph);
    }

  }

  /** 不共享的具体享元: 列 */
  private class Column extends Glyph {
    /** 聚合 */
    private List<Glyph> children = Lists.newArrayList();

    @Override
    public void draw(Context context) {
      for (Glyph child : children) {
        child.draw(context);
      }
    }

    public void add(Glyph glyph) {
      children.add(glyph);
    }
  }

  /** 享元的外部状态 */
  private class Context {
    private int size;

    public Context(int size) {
      this.size = size;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + size;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      Context other = (Context) obj;
      if (!getOuterType().equals(other.getOuterType())) return false;
      if (size != other.size) return false;
      return true;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)//
          .omitNullValues()//
          .add("size", size)//
          .toString();
    }

    private FlyweightPattern getOuterType() {
      return FlyweightPattern.this;
    }
  }

  /** 字形工厂 */
  class GlyphFactory {

    private Map<java.lang.Character, Glyph> GLYPH_POOL = Maps.newHashMap();

    public Glyph create(char innerRepresentation) {
      java.lang.Character character = new java.lang.Character(innerRepresentation);
      if (GLYPH_POOL.containsKey(character)) {
        return GLYPH_POOL.get(innerRepresentation);
      } else {
        Glyph glyph = new CharacterGlyph(innerRepresentation);
        GLYPH_POOL.put(character, glyph);
        return glyph;
      }
    }

  }

  @Override
  public void usage() {
    // 链表映射
    Map<Context, List<? extends Glyph>> contextMap = Maps.newLinkedHashMap();

    GlyphFactory glyphFactory = new GlyphFactory();

    Glyph charA = glyphFactory.create('a');
    Glyph charA2 = glyphFactory.create('a');
    Preconditions.checkState(charA == charA2);

    // 按列
    Column columnGlyph = new Column();
    Context context = new Context(12);
    Row rowGlyph = new Row();
    rowGlyph.add(glyphFactory.create('a'));
    rowGlyph.add(glyphFactory.create('b'));
    rowGlyph.add(glyphFactory.create('c'));
    columnGlyph.add(rowGlyph);
    contextMap.put(context, Lists.newArrayList(rowGlyph));

    context = new Context(13);
    rowGlyph = new Row();
    rowGlyph.add(glyphFactory.create('d'));
    rowGlyph.add(glyphFactory.create('e'));
    rowGlyph.add(glyphFactory.create('f'));
    columnGlyph.add(rowGlyph);
    contextMap.put(context, Lists.newArrayList(rowGlyph));

    // 按上下文展示
    for (Context ctx : contextMap.keySet()) {
      List<? extends Glyph> glyphs = contextMap.get(ctx);
      for (Glyph glyph : glyphs) {
        glyph.draw(ctx);
      }

      System.out.println();
    }

  }

  public static void main(String[] args) {
    new FlyweightPattern().usage();
  }

}
