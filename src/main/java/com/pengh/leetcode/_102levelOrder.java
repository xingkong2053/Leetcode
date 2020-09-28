package com.pengh.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _102levelOrder {

    /**
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */

    private List<List<Integer>> lists=new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root==null) return lists;
        //func(root,1);

        //迭代方法
        Queue<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.offer(root);
        //level当前层 m当前层元素个数
        int m=1,n;
        //循环当前层
        while(!queue.isEmpty()){
            n=m;
            m=0;
            lists.add(new ArrayList<Integer>());
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.remove();
                lists.get(lists.size()-1).add(node.val);
                if(node.left!=null) {
                    queue.offer(node.left);
                    m++;
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    m++;
                }
            }

        }

        return lists;

    }

//    private void func(TreeNode x,int level){
//        if(x==null) return;
//        if(lists.size()<level) lists.add(new ArrayList<Integer>());
//        lists.get(level-1).add(x.val);
//        func(x.left,level+1);
//        func(x.right,level+1);
//    }


}
