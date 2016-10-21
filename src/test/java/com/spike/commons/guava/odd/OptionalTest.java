package com.spike.commons.guava.odd;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Optional;

/**
 * {@link Optional}的单元测试
 * @author zhoujiagen
 */
public class OptionalTest {

  @Test(expected = IllegalStateException.class)
  public void create() {
    Optional<String> absent = Optional.absent();
    System.out.println(absent);// Optional.absent()
    Assert.assertFalse(absent.isPresent());
    System.out.println();

    String helloString = "hello";
    Optional<String> helloOptional = Optional.of(helloString);
    System.out.println(helloOptional);// Optional.of(hello)
    Assert.assertTrue(helloOptional.isPresent());
    System.out.println(helloOptional.get());
    System.out.println();

    String nullString = null;
    Optional<String> nullOptional = Optional.fromNullable(nullString);
    System.out.println(nullOptional);// Optional.absent()
    Assert.assertFalse(nullOptional.isPresent());
    System.out.println(nullOptional.get());
  }

}
