package com.spike.commons.algorithm.bean.tree.regular;

import java.util.Iterator;
import java.util.TreeSet;

import com.spike.commons.lang.StringUtils;

/**
 * Regular Tree abstraction <code>
 * RegularTreeNode rootNode = REGULAR_TREE_ROOT;

		RegularTreeNode level2_11 = new RegularTreeNode("2_11", true);
		RegularTreeNode level2_12 = new RegularTreeNode("2_12", true);
		RegularTreeNode level1_1 = new RegularTreeNode("1_1", false, level2_11, level2_12);

		RegularTreeNode level2_21 = new RegularTreeNode("2_21", true);
		RegularTreeNode level2_22 = new RegularTreeNode("2_22", true);
		RegularTreeNode level1_2 = new RegularTreeNode("1_2", false, level2_21, level2_22);

		RegularTreeNode level2_31 = new RegularTreeNode("2_31", true);
		RegularTreeNode level1_3 = new RegularTreeNode("1_3", false, level2_31);

		rootNode.addChild(level1_1);
		rootNode.addChild(level1_2);
		rootNode.addChild(level1_3);

		// level1_1.addChild(level2_11);
		// level1_1.addChild(level2_12);
		//
		// level1_2.addChild(level2_21);
		// level1_2.addChild(level2_22);
		//
		// level1_3.addChild(level2_31);

		RegularTree tree = new RegularTree(rootNode);

		tree.traverse();
 * 
 * </code>
 * @author zhoujiagen<br/>
 *         Sep 11, 2015 6:04:57 PM
 */
public class RegularTree {
  public static final RegularTreeNode REGULAR_TREE_ROOT = new RegularTreeNode("ROOT", false);

  private RegularTreeNode root;

  public RegularTree(RegularTreeNode root) {
    this.root = root;
  }

  public RegularTreeNode getRoot() {
    return root;
  }

  public void traverse() {
    doTraverse(root, 0);
  }

  private void doTraverse(RegularTreeNode node, int level) {
    System.out.println(StringUtils.REPEAT(StringUtils.TAB, level) + node.getContent());

    if (!node.isLeaf()) {
      doTraverse(node.getChildren(), ++level);
    }
  }

  private void doTraverse(TreeSet<RegularTreeNode> children, int level) {
    Iterator<RegularTreeNode> iterator = children.iterator();

    int nextLevel = level + 1;
    while (iterator.hasNext()) {
      RegularTreeNode thisNode = iterator.next();
      doTraverse(thisNode, nextLevel);
    }

  }
}
