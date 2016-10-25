package com.spike.commons.algorithm.bean.internalsort;

/**
 * Description: 排序方法算法接口<br/>
 * Date: 2014-5-5 下午10:46:52
 */
public interface Sort<E extends Comparable<? super E>> {
  /**
   * Description: 将E元素数组A排序<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  void sort(E[] A);
}
