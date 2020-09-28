package com.pengh.leetcode;

import java.util.*;

public class _94inorderTraversal {

    /**
     * 给定一个二叉树，返回它的中序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ints=new ArrayList<Integer>();
        if(root==null) return ints;

//        Queue<TreeNode> intQueue=new ArrayDeque<TreeNode>();
//        intQueue.add(root);
//
//        while(!intQueue.isEmpty()){
//            TreeNode node=intQueue.remove();
//            ints.add(node.val);
//            if(node.left!=null) intQueue.add(node.left);
//            if(node.right!=null) intQueue.add(node.right);
//        }

        Stack<TreeNode> intStack=new Stack<TreeNode>();
        TreeNode cur=root;
        while(cur!=null||!intStack.empty()){
            while(cur!=null){
                intStack.push(cur);
                cur=cur.left;
            }
            cur=intStack.pop();
            ints.add(cur.val);
            cur=cur.right;
        }

        return ints;
    }

}
