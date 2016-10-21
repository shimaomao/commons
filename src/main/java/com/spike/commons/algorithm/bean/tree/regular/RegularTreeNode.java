package com.spike.commons.algorithm.bean.tree.regular;

import java.util.TreeSet;

/**
 * Regualr Tree abstraction
 * @author zhoujiagen<br/>
 *         Sep 11, 2015 6:04:43 PM
 */
public class RegularTreeNode implements Comparable<RegularTreeNode> {

  private RegularTreeNode parent;
  private Object content;
  private TreeSet<RegularTreeNode> children = null;
  private boolean isLeaf = false;

  /**
   * @param content
   * @param isLeaf
   */
  public RegularTreeNode(Object content, boolean isLeaf) {
    this.content = content;
    this.isLeaf = isLeaf;
    if (!this.isLeaf) {
      this.children = new TreeSet<RegularTreeNode>();
    }
  }

  public RegularTreeNode(Object content, boolean isLeaf, RegularTreeNode... children) {
    this.content = content;
    this.isLeaf = isLeaf;

    if (!this.isLeaf) {
      this.children = new TreeSet<RegularTreeNode>();
      for (RegularTreeNode child : children) {
        this.children.add(child);
      }
    }
  }

  public RegularTreeNode getParent() {
    return this.parent;
  }

  public TreeSet<RegularTreeNode> getChildren() {
    return this.children;
  }

  public void addChild(RegularTreeNode child) {
    this.children.add(child);

    child.setParent(this);
  }

  public void isLeaf(boolean isLeaf) {
    this.isLeaf = isLeaf;
  }

  public boolean isLeaf() {
    return this.isLeaf;
  }

  public Object getContent() {
    return this.content;
  }

  public void setParent(RegularTreeNode parent) {
    this.parent = parent;
  }

  @Override
  public int compareTo(RegularTreeNode other) {
    // TODO more attention
    return this.getContent().toString().compareTo(other.getContent().toString());
  }

  @Override
  public String toString() {
    return "RegularTreeNode [content=" + content + ", isLeaf=" + isLeaf + "]";
  }

}
