package com.spike.commons.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <ul>
 * <li>Author: zhoujg | Date: 2014-4-20 下午4:31:06</li>
 * <li>Description: 集合的幂集，减1算法设计策略</li>
 * </ul>
 */
public class PowerSet {

  public static void main(String[] args) {
    char[] input = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };// 输入
    List<Character> source = new ArrayList<Character>();
    for (char c : input) {// omit duplicated input
      if (!source.contains(c)) {
        source.add(c);
      }
    }
    // render(generatePowerSet(source, 1));
    // render(generatePowerSet(source, 2));
    // render(generatePowerSet(source, 3));
    // System.out.println(generatePowerSet(source, 4).size());
    // render(generatePowerSet(source, 4));

    long start = System.currentTimeMillis(), end;
    System.out.println(generatePowerSet(source, source.size()).size());
    render(generatePowerSet(source, source.size()));
    end = System.currentTimeMillis();
    System.out.println("Last " + (end - start) + " ms");
  }

  // ///////////////////////////////////////////////////////////////////
  /**
   * 生成字符列表source中长度为length的字符集合的幂集
   */
  static List<HashSet<Character>> generatePowerSet(List<Character> source, int length) {
    if (source == null) {
      return null;
    } else if (length == 0) {
      List<HashSet<Character>> result = new ArrayList<HashSet<Character>>();
      result.add(new HashSet<Character>());
      return result;
    } else {
      List<HashSet<Character>> result = new ArrayList<HashSet<Character>>();
      List<HashSet<Character>> oneLessResult = generatePowerSet(source, length - 1);// 减1
      result.addAll(oneLessResult);
      for (HashSet<Character> set : oneLessResult) {// n-1 -> n
        HashSet<Character> newSet = new HashSet<Character>(set);// copy
        newSet.add(source.get(length - 1));
        result.add(newSet);
      }
      return result;
    }
  }

  static void render(List<HashSet<Character>> result) {
    System.out.print("{");
    for (HashSet<Character> set : result) {
      System.out.print("{");
      for (Character c : set) {
        System.out.print(c + " ");
      }
      System.out.print("} ");
    }
    System.out.println("}");
  }

}
