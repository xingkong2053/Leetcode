package com.pengh.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _23mergeKLists {

    /**
     合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

     示例:

     输入:
     [
       1->4->5,
       1->3->4,
       2->6
     ]
     输出: 1->1->2->3->4->4->5->6

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;

        //索引优先队列
        PriorityQueue<ListNode> priorityQueue=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        for (ListNode root : lists) {
            if(root!=null) priorityQueue.add(root);
        }

        ListNode result=new ListNode(0),p=result;

        while(!priorityQueue.isEmpty()){
                p.next=priorityQueue.poll();
                p=p.next;
                if(p.next!=null)
                    priorityQueue.add(p.next);
        }
        return result.next;

    }
     */

    public ListNode mergeKLists(ListNode[] lists){
        if(lists==null||lists.length==0) return null;
        //两两合并
        int len=lists.length;
        if(len==1) return lists[0];
        if(len==2) return mergeLists(lists[0],lists[1]);

        int mid=len/2;
        ListNode leftPart=mergeKLists(Arrays.copyOfRange(lists,0,mid));
        ListNode rightPart=mergeKLists(Arrays.copyOfRange(lists,mid,len));
        return mergeLists(leftPart,rightPart);

    }

    //合并双链表
    private ListNode mergeLists(ListNode n1,ListNode n2){
        if(n1==null) return n2;
        if(n2==null) return n1;

        if(n1.val>n2.val){
            n2.next=mergeLists(n1,n2.next);
            return n2;
        }
        else{
            n1.next=mergeLists(n1.next,n2);
            return n1;
        }
    }
}
