package com.pengh.leetcode;

import java.util.Stack;

public class _234Palindrome {

    /**
     * 回文链表
     *
     * 请判断一个链表是否为回文链表。
     *
     *     示例 1:
     *
     *     输入: 1->2
     *     输出: false
     *     示例 2:
     *
     *     输入: 1->2->2->1
     *     输出: true
     *     进阶：
     *     你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     *
     *     来源：力扣（LeetCode）
     *     链接：https://leetcode-cn.com/problems/palindrome-linked-list
     *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isPalindrome(ListNode head) {
        //链表反转
        if(head==null) return false;
        if(head.next==null) return true;
        ListNode fast=head,slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow=reverseList(slow);
        while(slow!=null){
            if(head.val!=slow.val) return false;
            head=head.next;
            slow=slow.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head){
        if(head.next==null) return head;
        ListNode pre=null,cur=head;

        while(cur!=null){
            ListNode tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] ints={1,1};

        ListNode head=new ListNode(ints[0]),cur=head;
        for (int i = 1; i < ints.length; i++) {
            cur.next=new ListNode(ints[i]);
            cur=cur.next;
        }

        System.out.println(new _234Palindrome().isPalindrome(head));

    }

}
