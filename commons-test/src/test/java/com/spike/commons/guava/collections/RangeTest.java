package com.spike.commons.guava.collections;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Range;
import com.spike.commons.guava.collections.domain.Person;

/**
 * {@link Range}的单元测试
 * @author zhoujiagen
 */
public class RangeTest {

  @Test
  public void _create() {
    Range<Integer> range = Range.closed(1, 10);
    Assert.assertTrue(range.contains(1));
    Assert.assertTrue(range.contains(10));

    range = Range.openClosed(1, 10);
    Assert.assertFalse(range.contains(1));
    Assert.assertTrue(range.contains(10));

    range = Range.open(1, 10);
    Assert.assertFalse(range.contains(1));
    Assert.assertFalse(range.contains(10));
  }

  @Test
  public void rangeWithComparableClass() {
    Range<Integer> personAgeRange = Range.closed(35, 50);

    // Range is a Predicate
    Function<Person, Integer> personToAgefunction = new Function<Person, Integer>() {
      @Override
      public Integer apply(Person input) {
        return input.getAge();
      }
    };
    Predicate<Person> predicate = Predicates.compose(personAgeRange, personToAgefunction);

    Person input = new Person("firstName", "firstName", 36, "M");
    Assert.assertTrue(predicate.apply(input));

    input.setAge(34);
    Assert.assertFalse(predicate.apply(input));
  }

}
