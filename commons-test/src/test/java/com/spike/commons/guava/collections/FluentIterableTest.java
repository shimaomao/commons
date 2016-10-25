package com.spike.commons.guava.collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.spike.commons.guava.collections.domain.Person;

/**
 * {@link FluentIterable}的单元测试 流畅的迭代
 * @author zhoujiagen
 */
public class FluentIterableTest {

  private Person person1;
  private Person person2;
  private Person person3;
  private Person person4;
  private List<Person> personList;

  @Before
  public void setUp() {
    person1 = new Person("Wilma", "Flintstone", 30, "F");
    person2 = new Person("Fred", "Flintstone", 32, "M");
    person3 = new Person("Betty", "Rubble", 31, "F");
    person4 = new Person("Barney", "Rubble", 33, "M");

    personList = Lists.newArrayList(person1, person2, person3, person4);
  }

  @Test
  public void _filter() {
    // 过滤用谓词
    Predicate<Person> predicate = new Predicate<Person>() {
      @Override
      public boolean apply(Person input) {
        return input.getAge() > 31;
      }
    };

    Iterable<Person> personFilteredByAge = FluentIterable.from(personList).filter(predicate);

    System.out.println(personFilteredByAge);

    // 元素包含性
    assertThat(Iterables.contains(personFilteredByAge, person1), is(false));
    assertThat(Iterables.contains(personFilteredByAge, person2), is(true));
    assertThat(Iterables.contains(personFilteredByAge, person3), is(false));
    assertThat(Iterables.contains(personFilteredByAge, person4), is(true));
  }

  @Test
  public void _transform() {
    // 转换用函数
    Function<Person, String> function = new Function<Person, String>() {
      @Override
      public String apply(Person input) {
        return Joiner.on("#").join(input.getLastName(), input.getFirstName(), input.getAge());
      }
    };

    List<String> transformedList = FluentIterable.from(personList).transform(function).toList();
    System.out.println(transformedList);

    // "Wilma", "Flintstone", 30, "F"
    assertThat(transformedList.get(0), is("Flintstone#Wilma#30"));
  }
}
