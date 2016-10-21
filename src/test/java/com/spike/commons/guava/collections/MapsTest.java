package com.spike.commons.guava.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps.EntryTransformer;
import com.spike.commons.guava.collections.domain.Book;

/**
 * {@link Maps}的单元测试
 * @author zhoujiagen
 */
public class MapsTest {

  List<Book> books;

  @Before
  public void setUp() {
    books = Lists.newArrayList();

    Book book = new Book(null, "title1", "publisher1", "isbn1", 0.1D);
    books.add(book);
    book = new Book(null, "title2", "publisher2", "isbn2", 0.2D);
    books.add(book);
    book = new Book(null, "title3", "publisher3", "isbn3", 0.3D);
    books.add(book);
    book = new Book(null, "title4", "publisher4", "isbn4", 0.4D);
    books.add(book);
  }

  /**
   * <pre>
   * 将Book列表转换为key=isbn, value=Book的Map
   * </pre>
   */
  @Test
  public void _uniqueIndex() {

    // Map的键生成函数
    Function<Book, String> keyFunction = new Function<Book, String>() {
      @Override
      public String apply(Book input) {
        return input.getIsbn();
      }
    };

    Map<String, Book> result = Maps.uniqueIndex(books, keyFunction);

    Assert.assertThat(result.size(), Is.is(4));
    System.out.println(result);
  }

  /**
   * <pre>
   *  由Book列表转换为key=isbn, value=Book的Map
   * </pre>
   */
  @Test
  public void _asMap() {
    Function<Book, String> transformFunction = new Function<Book, String>() {
      @Override
      public String apply(Book input) {
        return input.getIsbn();
      }
    };
    Set<String> isbnSet = FluentIterable.from(books).transform(transformFunction).toSet();

    Function<String, Book> function = new Function<String, Book>() {
      @Override
      public Book apply(final String isbn) {
        return FluentIterable.from(books).filter(new Predicate<Book>() {
          @Override
          public boolean apply(Book input) {
            return input.getIsbn().equals(isbn);
          }
        }).first().get();
      }
    };

    Map<String, Book> result = Maps.asMap(isbnSet, function);

    System.out.println(result);
  }

  @Test
  public void _toMap() {
    List<String> keys = Lists.newArrayList("1", "2", "3");
    Function<String, Integer> valueFunction = new Function<String, Integer>() {
      @Override
      public Integer apply(String input) {
        return Integer.parseInt(input) + 1;
      }
    };

    ImmutableMap<String, Integer> result = Maps.toMap(keys, valueFunction);

    System.out.println(result);
  }

  @Test
  public void _transformFromEntries() {
    Function<Book, String> keyFunction = new Function<Book, String>() {
      @Override
      public String apply(Book input) {
        return input.getIsbn();
      }
    };

    Map<String, Book> isbnBookMap = Maps.uniqueIndex(books, keyFunction);
    System.out.println(isbnBookMap);

    EntryTransformer<String, Book, Book> transformer = new EntryTransformer<String, Book, Book>() {

      @Override
      public Book transformEntry(String key, Book value) {
        Book result = value;
        result.setPrice(value.getPrice() + 1D); // 涨价
        return result;
      }
    };

    Map<String, Book> result = Maps.transformEntries(isbnBookMap, transformer);
    System.out.println(result);
  }

}
