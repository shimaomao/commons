package com.spike.commons.fp;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.spike.commons.fp.FPStyleUtils.RegularFunction;
import com.spike.commons.lang.StringUtils;

public class FPStyleUtilsTest {

  @Test
  public void testMap() {

    List<String> stringList = Arrays.asList("hello", "world");
    System.out.println(stringList);

    List<String> stringList2 =
        (List<String>) FPStyleUtils.map(stringList, new RegularFunction<String, String>() {
          @Override
          public String output(String input) {
            input = StringUtils.defaultIfBlank(input, "");
            return input.toUpperCase();
          }
        });

    System.out.println(stringList2);
  }

  @Test
  public void testFlatMap() {

    List<String> stringList = Arrays.asList("Hello", "World");
    System.out.println(stringList);

    RegularFunction<String, List<String>> function = new RegularFunction<String, List<String>>() {
      @Override
      public List<String> output(String input) {
        input = StringUtils.defaultIfBlank(input, "");
        return Arrays.asList(input, input.toUpperCase(), input.toLowerCase());
      }
    };

    List<String> stringList2 = (List<String>) FPStyleUtils.flatMap(stringList, function);

    System.out.println(stringList2);

  }
}
