package com.spike.commons.example.designpattern;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Lists;
import com.spike.commons.annotation.designpattern.DesignPattern;
import com.spike.commons.annotation.designpattern.DesignPatternContants.Pattern;
import com.spike.commons.exception.ExceptionUtils;

/**
 * <pre>
 * 意图：将一个复杂对象的构建与它的表示分离,使得同样的构建过程可以创建不同的表示。
 * 
 * 
 *  案例：
 *  
 *  一个RTF(RichTextFormat)文档交换格式的阅读器应能将RTF转换为多种正文格式。
 * 	该阅读器可以将RTF文档转换成普通ASCII文本或转换成一个能以交互方式编辑的正文窗口组件。
 * 
 * 但问题在于可能转换的数目是无限的。因此要能够很容易实现新的转换的增加,同时却不改变RTF阅读器。
 * </pre>
 * @author zhoujiagen
 */
@DesignPattern(value = Pattern.Builder, description = "生成器")
class BuilderPattern implements DesignPatternClient {

  /** token类型 */
  private enum TokenType {
    CHARACTER, FONT, PARAGRAPH
  }

  /** 字体类型 */
  private enum Font {
    Font1, Font2, Font3;

    public static Font parse(String literal) {
      if (Font1.name().equals(literal)) {
        return Font1;
      } else if (Font2.name().equals(literal)) {
        return Font2;
      } else if (Font3.name().equals(literal)) {
        return Font3;
      }

      throw ExceptionUtils.unsupport("不支持的字体");
    }
  }

  /** token */
  private class Token {
    /** 类型 */
    private TokenType tokenType;
    /** 内容 */
    private String content;

    public Token(TokenType tokenType, String content) {
      this.tokenType = tokenType;
      this.content = content;
    }

    public TokenType getTokenType() {
      return tokenType;
    }

    public String getContent() {
      return content;
    }

  }

  /** 生成器接口: 文本转换器，负责转换后格式生成的算法 */
  private interface TextConverter {

    /** 转换字符 */
    void convertCharacter(String literal);

    /** 转换字体 */
    void convertFontChange(Font font);

    /** 转换段落 */
    void convertParagraph();

    /** 获取转换结果 */
    Product getResult();
  }

  private class ASCIIConvertet implements TextConverter {
    private ASCIIText text = new ASCIIText();

    @Override
    public Product getResult() {
      return text;
    }

    @Override
    public void convertCharacter(String literal) {
      text.markCharacter(literal);
    }

    @Override
    public void convertFontChange(Font font) {
      // do nothing
    }

    @Override
    public void convertParagraph() {
      // do nothing
    }

  }

  private class TeXConverter implements TextConverter {
    private TeXText text = new TeXText();

    @Override
    public Product getResult() {
      return text;
    }

    @Override
    public void convertCharacter(String literal) {
      text.markCharacter(literal);
    }

    @Override
    public void convertFontChange(Font font) {
      text.markFont(font);
    }

    @Override
    public void convertParagraph() {
      text.markParagraph();
    }
  }

  private class TextWidgetConverter implements TextConverter {
    private TextWidget text = new TextWidget();

    @Override
    public Product getResult() {
      return text;
    }

    @Override
    public void convertCharacter(String literal) {
      text.markCharacter(literal);
    }

    @Override
    public void convertFontChange(Font font) {
      text.markFont(font);
    }

    @Override
    public void convertParagraph() {
      text.markParagraph();
    }
  }

  /** 产品指示型接口 */
  private interface Product {
  }

  private class ASCIIText implements Product {
    private String content;

    public ASCIIText() {
      content = "<ASCIIText>";
    }

    public void markCharacter(String literal) {
      this.content += literal;
    }

    @Override
    public String toString() {
      return this.getClass().getCanonicalName() + ": " + content;
    }

  }

  private class TeXText implements Product {

    // 忽略展示逻辑对应的数据结构
    private List<String> contents = Lists.newArrayList();

    public TeXText() {
      contents.add("<TeXText>");
    }

    public void markFont(Font font) {
      contents.add("<Font: " + font + ">");
    }

    public void markParagraph() {
      contents.add("<Paragraph>");
    }

    public void markCharacter(String literal) {
      contents.add(literal);
    }

    @Override
    public String toString() {
      return this.getClass().getCanonicalName() + ": " + contents;
    }
  }

  private class TextWidget implements Product {
    // 忽略展示逻辑对应的数据结构
    private List<String> contents = Lists.newArrayList();

    public TextWidget() {
      contents.add("<TextWidget>");
    }

    public void markFont(Font font) {
      contents.add("<Font: " + font + ">");
    }

    public void markParagraph() {
      contents.add("<Paragraph>");
    }

    public void markCharacter(String literal) {
      contents.add(literal);
    }

    @Override
    public String toString() {
      return this.getClass().getCanonicalName() + ": " + contents;
    }
  }

  /** 使用生成器的对象: 负责token的解析算法 */
  private class RTFReader {
    private TextConverter textConverter;

    public RTFReader(TextConverter textConverter) {
      this.textConverter = textConverter;
    }

    /** token的解析算法 */
    public void parseRTF(List<Token> tokens) {
      if (CollectionUtils.isEmpty(tokens)) {
        return;
      }

      String tokenContent = null;
      for (Token token : tokens) {
        tokenContent = token.getContent();

        try {
          switch (token.getTokenType()) {
          case CHARACTER:
            textConverter.convertCharacter(tokenContent);
            break;

          case FONT:
            textConverter.convertFontChange(Font.parse(tokenContent));
            break;

          case PARAGRAPH:
            textConverter.convertParagraph();

          default:
            continue;
          }
        } catch (Exception e) {
          e.printStackTrace();
        }

      }

    }
  }

  @Override
  public void usage() {

    // 生成token序列
    List<Token> tokens = Lists.newArrayList(//
      new Token(TokenType.CHARACTER, "char"), //
      new Token(TokenType.FONT, "Font1"),//
      new Token(TokenType.PARAGRAPH, "para")//
        );

    TextConverter textConverter = null;
    RTFReader rtfReader = null;
    Product product = null;

    textConverter = new ASCIIConvertet();
    rtfReader = new RTFReader(textConverter);
    rtfReader.parseRTF(tokens);
    product = textConverter.getResult();// 获取转换结果
    System.out.println(product);

    textConverter = new TeXConverter();
    rtfReader = new RTFReader(textConverter);
    rtfReader.parseRTF(tokens);
    product = textConverter.getResult();
    System.out.println(product);

    textConverter = new TextWidgetConverter();
    rtfReader = new RTFReader(textConverter);
    rtfReader.parseRTF(tokens);
    product = textConverter.getResult();
    System.out.println(product);
  }

  public static void main(String[] args) {
    new BuilderPattern().usage();
  }
}
