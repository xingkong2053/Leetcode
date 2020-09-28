package com.pengh.leetcode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _124BTreeMaxPath {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(log(N))
     */

    private int maxSum=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        maxGain(root);
        return maxSum;
    }


    public int maxGain(TreeNode x){

        if(x==null) return 0;

        int leftGain=Math.max(maxGain(x.left),0);
        int rightGain=Math.max(maxGain(x.right),0);

        int newPrice=leftGain+rightGain+x.val;

        maxSum=Math.max(newPrice,maxSum);

        return Math.max(leftGain,rightGain)+x.val;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
