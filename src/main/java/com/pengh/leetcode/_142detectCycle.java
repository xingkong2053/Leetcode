package com.pengh.leetcode;


import java.util.HashSet;
import java.util.Set;

public class _142detectCycle {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     *
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     * 说明：不允许修改给定的链表。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：tail connects to node index 1
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * 解法一：使用HashSet
     * public ListNode detectCycle(ListNode head) {
*             if(head==null||head.next==null) return null;
*             ListNode p=head;
*             Set<ListNode> nodeSet=new HashSet<>();
*             while(p!=null){
*                 if(!nodeSet.contains(p)) nodeSet.add(p);
*                 else return p;
*                 p=p.next;
*             }
*             return null;
*         }
     *
     * 解法二：快慢指针（Floyd算法）
     *
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if(head==null||head.next==null) return null;
            ListNode fast=head;
            ListNode slow=head;

            //阶段一：寻找相遇点
            while(fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;

                if(fast==slow) break;
            }

            if(fast==null||fast.next==null) return null;

            //阶段二：寻找入环点
            slow=head;
            while(slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }

            return slow;
        }
    }
}


class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
        next=null;
    }
}
