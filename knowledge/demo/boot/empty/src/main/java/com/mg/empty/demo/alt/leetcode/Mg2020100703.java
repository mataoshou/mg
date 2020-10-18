package com.mg.empty.demo.alt.leetcode;

import com.mg.empty.demo.alt.data.TreeNode;

/**
 * 树的深度
 */
public class Mg2020100703 {
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return getDepath(root,0);
    }

    public int getDepath(TreeNode root,int current)
    {
        if(root==null)return current;
        current++;
        return Math.max(getDepath(root.left,current),getDepath(root.right,current));
    }
}
