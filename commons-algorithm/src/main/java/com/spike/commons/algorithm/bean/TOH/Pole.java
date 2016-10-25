package com.spike.commons.algorithm.bean.TOH;

/**
 * Source code example for
 * "A Practical Introduction to Data Structures and Algorithm Analysis, 3rd Edition (Java)" by
 * Clifford A. Shaffer Copyright 2008-2011 by Clifford A. Shaffer
 */

class Pole {// 杆
  int poleNum;

  /**
   * @param value 杆编号
   */
  Pole(int value) {
    poleNum = value;
  }

  @Override
  public String toString() {
    return Integer.toString(poleNum);
  }
}
