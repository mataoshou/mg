package com.mg.empty.demo.alt.data;

import com.mg.empty.demo.alt.leetcode.Mg20201007;

/**
 * 树是一种非线性关系的数据结构
 * 根节点下分布着一些不交叉的子节点
 * 每个子节点都有且只有一个前驱节点
 * 每个节点可以有多个后继节点
 * 节点度  一个节点包含子树的数量
 * 树的度  节点中最大的度
 * 树的深度  节点的最大成熟
 * 森林  多个没有交叉关系的树组成
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int x) { val = x; }
}
