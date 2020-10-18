package com.mg.empty.demo.alt.leetcode;

import com.fasterxml.jackson.databind.util.LinkedNode;
import com.mg.empty.demo.alt.data.LinkListNode;
import com.mg.empty.demo.alt.data.ListNode;
import com.mg.empty.demo.alt.util.BuildData;
import com.mg.empty.demo.alt.util.ShowUtill;

public class Mg2020100801 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;

        ListNode head= new ListNode(-1);

        ListNode node = head;

        while(l1!=null&&l2!=null)
        {
            if(l1.val<=l2.val)
            {
                node.next = l1;
                l1= l1.next;
            }
            else{
                node.next=l2;
                l2=l2.next;
            }
            node = node.next;
        }

        ListNode tmp = l1==null?l2:l1;
        node.next = tmp;

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = BuildData.buildList(new int[]{1,2,4});
        ListNode l2 = BuildData.buildList(new int[]{1,3,4});

        Mg2020100801 mg2020100801 = new Mg2020100801();
        ShowUtill.showList(mg2020100801.mergeTwoLists(l1,l2));
    }
}
