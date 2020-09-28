package com.pengh.leetcode;

public class _206reverseList {

    /**
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;

//        ListNode cur=head;
//        ListNode prev=null;
//
//        while(cur!=null){
//            ListNode tmp=cur.next;
//            cur.next=prev;
//            prev=cur;
//            cur=tmp;
//        }
//        return prev;


//        return reverseNode(head);
    }

//    public ListNode reverseNode(ListNode x){
//        if(x.next==null) return x;
//        ListNode head=reverseNode(x.next);
//        ListNode p=head;
//        while(p.next!=null){
//            p=p.next;
//        }
//        x.next=null;
//        p.next=x;
//        return head;
//    }

    public static void main(String[] args) {

        ListNode head=new ListNode(1);
        ListNode p=head;

        for(int i=2;i<6;i++){
            p.next=new ListNode(i);
            p=p.next;
        }

        head=new _206reverseList().reverseList(head);

        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
        System.out.println("");

    }

}
