package com.mg.empty.demo.alt.leetcode;

import com.mg.empty.demo.alt.data.TreeNode;
import com.mg.empty.demo.alt.util.BuildData;

public class Mg20201007 {

    public boolean isBalanced(TreeNode root) {

        if(root==null)return true;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        if(left&&right)
        {
            int lDepth = getDepath(root.left,0);
            int rDepth = getDepath(root.right,0);
            if(Math.abs(lDepth-rDepth)>1)return false;
        }

        return left&&right;

    }

    public int getDepath(TreeNode root,int current)
    {
        if(root==null)return current;
        current++;
        return Math.max(getDepath(root.left,current),getDepath(root.right,current));
    }



    public static void main(String[] args) {

        Integer[] arrays = new Integer[]{1,2,2,3,null,null,3,4,null,null,4};
        Mg20201007 mg20201007 = new Mg20201007();
        System.out.println(mg20201007.isBalanced(BuildData.buildTree(arrays,0)));
    }

}
