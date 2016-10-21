package com.spike.commons.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * <ul>
 * <li>Author: zhoujg | Date: 2014-4-22 下午11:25:05</li>
 * <li>Description: 排列, 减1算法设计策略</li>
 * </ul>
 */
public class Permutation {

  public static void main(String[] args) {
    char[] array = new char[] { 'A', 'B', 'C', 'D', 'E' };

    // test addOne
    // ArrayList<Character> test = new ArrayList<Character>();
    // test.add('A');
    // test.add('B');
    // test.add('C');
    // test.add('D');
    // render(addOne(test, 'E'));

    render(permutate(array, 5));
  }

  static Set<ArrayList<Character>> permutate(char[] array, int n) {
    Set<ArrayList<Character>> result = null;
    if (n == 1) {// 1
      result = new HashSet<ArrayList<Character>>();
      ArrayList<Character> characters = new ArrayList<Character>();
      characters.add(array[0]);
      result.add(characters);
    } else {// n-1 -> n
      result = new HashSet<ArrayList<Character>>();
      Set<ArrayList<Character>> minusOneResult = permutate(array, n - 1);
      Character c = array[n - 1];
      for (ArrayList<Character> list : minusOneResult) {
        result.addAll(addOne(list, c));
      }
    }
    return result;
  }

  static Set<ArrayList<Character>> addOne(ArrayList<Character> list, Character c) {
    Set<ArrayList<Character>> result = new HashSet<ArrayList<Character>>();
    ArrayList<Character> temp = null;
    for (int i = 0; i <= list.size(); i++) {
      temp = new ArrayList<Character>(list);
      temp.add(i, c);// ArrayList insert :-)
      result.add(temp);
    }
    return result;
  }

  static void render(Set<ArrayList<Character>> set) {
    System.out.println("Contains " + set.size() + " records!!!");
    for (ArrayList<Character> list : set) {
      for (Character c : list) {
        System.out.print(c);
      }
      System.out.println();
    }
  }

}
