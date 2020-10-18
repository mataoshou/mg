package com.mg.empty.demo.alt.leetcode;

import com.mg.empty.demo.alt.data.TreeNode;

public class Mg2020100702 {

    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if(preorder.length==0||inorder.length==0)return null;
        return  buildTreeData(preorder,0,preorder.length-1,
                    inorder,0,inorder.length-1);
    }

    public TreeNode buildTreeData(int[] preorder,int preleft,int preright,int[] inorder,int inleft,int inright)
    {

        if(preleft>preright||inleft>inright)return null;

        TreeNode node = new TreeNode(preorder[preleft]);
        if(preleft==preright&&inleft==inright)return node;



        int middle = 0;
        int premiddle =0;
        int inmiddle=0;
        for(int i=inleft;i<=inright;i++)
        {
            if(inorder[i] == preorder[preleft])
            {
                middle= i;
                break;
            }
        }

        int left =middle - inleft;
        int right = inright -middle;

        node.left = buildTreeData(preorder,preleft+1,preleft+left,
                inorder,inleft,inleft+left-1);
        node.right = buildTreeData(preorder,preleft+left+1,preright,
                inorder,inleft+left+1,inright);
        return node;
    }

    public static void main(String[] args) {
        Mg2020100702 mg2020100702 = new Mg2020100702();
        mg2020100702.buildTree(new int[]{1,2},
                new int[]{2,1});
    }
}
