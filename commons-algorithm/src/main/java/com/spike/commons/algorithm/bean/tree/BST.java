package com.spike.commons.algorithm.bean.tree;

import com.spike.commons.algorithm.bean.dictionary.DictionaryADT;

/**
 * Description: Binary Search Tree(BST)<br/>
 * BST属性：左子节点的键值<其父节点的键值，右子节点的键值>=其父节点的键值<br/>
 * Date: 2014-4-27 下午10:03:54
 */
public class BST<Key extends Comparable<? super Key>, E> implements DictionaryADT<Key, E> {
  private BTNode<Key, E> root;// BST根节点
  private int nodeCount;// 节点综述

  public BST() {
    root = null;
    nodeCount = 0;
  }

  /* @see dictionary.DictionaryADT#clear() */
  @Override
  public void clear() {
    root = null;
    nodeCount = 0;
  }

  /**
   * BST的结构依赖于插入节点的顺序
   * @see dictionary.DictionaryADT#insert(java.lang.Object, java.lang.Object)
   */
  @Override
  public void insert(Key key, E v) {
    root = insertHelp(root, key, v);
    nodeCount++;
  }

  /**
   * Description: 在以root为根的子树中插入key和e，将此添加元素后的root返回<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  private BTNode<Key, E> insertHelp(BTNode<Key, E> root, Key key, E e) {
    if (root == null) return new BTNode<Key, E>(key, e);
    Key rootKey = root.key();
    if (rootKey.compareTo(key) > 0) {// 该节点的键值比该节点的键值小，走左子节点，并更新该节点
      root.setLeft(insertHelp(root.left(), key, e));
    } else {// 该节点的键值不小于该节点的键值,走右子节点，并更新该节点
      root.setRight(insertHelp(root.right(), key, e));
    }
    return root;
  }

  /* @see dictionary.DictionaryADT#remove(java.lang.Object) */
  @Override
  public E remove(Key key) {
    E temp = findHelp(root, key);
    if (temp != null) {
      root = removeHelp(root, key);
      nodeCount--;
    }
    return temp;
  }

  /**
   * Description: 删除以root为根的子树中键值为key对应的节点，并将修改元素后的root返回<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  private BTNode<Key, E> removeHelp(BTNode<Key, E> root, Key key) {
    if (root == null) return null;
    Key rootKey = root.key();
    if (rootKey.compareTo(key) > 0) {// 若需删除键值小于该节点的键值，走左子节点，并更新该节点
      root.setLeft(removeHelp(root.left(), key));
    } else if (rootKey.compareTo(key) < 0) {// dual :走右子节点
      root.setRight(removeHelp(root.right(), key));
    } else {// 找到需删除键对应的节点
      if (root.left() == null) {// 左子树为空，返回右子树
        return root.right();// 右子树也为空时，root为叶子
      } else if (root.right() == null) {// 左子树不为空，右子树为空，返回左子树
        return root.left();
      } else {// 左右子树均不为空
        // 找右子树中最小键值对应的节点，将该节点晋升为根
        BTNode<Key, E> temp = getmin(root.right());
        root.setElement(temp.element());
        root.setKey(temp.key());
        // 删除右子树中最小键值对应的节点
        root.setRight(deletemin(root.right()));
      }
    }
    return root;
  }

  /**
   * Description: 删除以root为根的子树中最小的键值对应的节点，并将修改元素后的root返回<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  private BTNode<Key, E> deletemin(BTNode<Key, E> root) {
    if (root.left() == null) {// 左子树为空，此时root中键值最小
      return root.right();// root右子节点为空时，此时root节点也为空
    } else {// 递归处理root的左子树
      root.setLeft(deletemin(root.left()));
      return root;
    }
  }

  /**
   * Description: 获取以root为根的子树中最小键值对应的节点<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  private BTNode<Key, E> getmin(BTNode<Key, E> root) {
    if (root.left() == null) return root;
    return getmin(root.left());// 递归的处理root的左子树
  }

  /**
   * Description: 获取以root为根的子树中最大键值对应的节点<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  private BTNode<Key, E> getmax(BTNode<Key, E> root) {
    if (root.right() == null) return root;
    return getmax(root.right());
  }

  /**
   * 删除根节点
   * @see dictionary.DictionaryADT#removeAny()
   */
  @Override
  public E removeAny() {
    if (root == null) return null;
    E temp = root.element();
    root = removeHelp(root, root.key());
    nodeCount--;
    return temp;
  }

  /* @see dictionary.DictionaryADT#find(java.lang.Object) */
  @Override
  public E find(Key key) {
    // 从根节点开始查找
    return findHelp(root, key);
  }

  /**
   * Description: 在以root为根的子树中查找键值为key的元素<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  private E findHelp(BTNode<Key, E> root, Key key) {
    if (root == null) return null;
    Key rootKey = root.key();
    if (rootKey.compareTo(key) > 0) {// 需查找的键值小于该节点的键值，走该节点的左子节点
      return findHelp(root.left(), key);
    } else if (rootKey.compareTo(key) == 0) {// 需查找的键值等于该节点的键值，直接返回
      return root.element();
    } else {// 走该节点的右子节点
      return findHelp(root.right(), key);
    }
  }

  /* @see dictionary.DictionaryADT#size() */
  @Override
  public int size() {
    return nodeCount;
  }

  @Override
  public String toString() {
    return render(root);
  }

  /**
   * Description: 中序遍历<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  private String render(BTNode<Key, E> root) {
    if (root == null) return "";
    StringBuilder sb = new StringBuilder();
    sb.append(render(root.left()));
    sb.append(root.element().toString() + " ");
    sb.append(render(root.right()));
    return sb.toString();
  }

  /**
   * Description: 检查BST性质，满足则返回true<br/>
   * PRE: <br/>
   * POST: <br/>
   */
  public boolean checkBST() {
    if (root == null) return true;
    Key rootKey = root.key();
    if (root.left() != null) {// 左子树最大值
      Key leftMaxKey = getmax(root.left()).key();
      if (leftMaxKey.compareTo(rootKey) >= 0) return false;
    }
    if (root.right() != null) {
      Key rightMinKey = getmin(root.right()).key();
      if (rightMinKey.compareTo(rootKey) < 0) return false;
    }
    return true;
  }
}
