package com.pengh.leetcode;

public class _148sortedList {


    /**
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     *
     * 示例 1:
     *
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * 示例 2:
     *
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if(head==null||head.next==null) return head;

        //快慢指针，快指针指向链表的结尾时，慢指针指向链表的中点
        ListNode slowP=head;
        ListNode fastP=head.next;
        while(fastP!=null&&fastP.next!=null){
            slowP=slowP.next;
            fastP=fastP.next.next;
        }
        //切割
        ListNode mid=slowP.next;
        slowP.next=null;

        //分别排序
        head=sortList(head);
        mid=sortList(mid);

        //返回合并后的链表
        return merge(head,mid);
    }


    //合并两个链表
    private ListNode merge(ListNode a,ListNode b) {

        if(a==null) return b;
        if(b==null) return a;

        if (a.val < b.val) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next=merge(a,b.next);
            return b;
        }

    }




}
