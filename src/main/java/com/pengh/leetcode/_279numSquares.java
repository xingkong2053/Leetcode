package com.pengh.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _279numSquares {

    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     *
     * 示例 1:
     *
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * 示例 2:
     *
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/perfect-squares
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    private Queue<Integer> queue;

    public int numSquares(int n) {
//        //方法1：动态规划 核心思想：
//        if(n==0) return 0;
//        int[] dp=new int[n+1];  //dp[0]不用
//        for(int i=1;i<=n;i++){
//            dp[i]=i;
//            for(int j=1;i-j*j>=0;j++){
//                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
//            }
//        }
//        return dp[n];

        //方法二：广度优先搜索
        if(n==0) return 0;
        queue=new LinkedList<>();
        queue.offer(n);
        int step=0;
        while(!queue.isEmpty()){
            step++;
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                Integer node = queue.remove();
                for(int j=1;j*j<=node.intValue();j++){
                    int val=node-j*j;
                    if(val==0) return step;
                    queue.add(val);
                }
            }

        }

        //方法三：四平方定理


        return step;
    }

    public static void main(String[] args) {
        System.out.println(new _279numSquares().numSquares(12));
    }
}
