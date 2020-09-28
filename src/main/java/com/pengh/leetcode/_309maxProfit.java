package com.pengh.leetcode;

import java.util.Arrays;

public class _309maxProfit {

    /**
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
     *
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     *
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 示例:
     *
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxProfit(int[] prices) {

        int len=prices.length;
        if(len<=1) return 0;

        //dp[i][state] 第i+1天处于状态state的最大收益
        //state 0 不持股 1 持股 2 冷冻期
        int dp[][]=new int[len][3];
        //初始（第一天）
        dp[0][0]=0;dp[0][1]=-prices[0];dp[0][2]=0;

        for(int i=1;i<len;i++){
            //第二天不持股 可由 第一天不持股 第一天持股转化而来
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //第二天持股 可由 第一天持股 第一天为冷冻期 转化而来
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][2]-prices[i]);
            //第二天为冷冻期 可由第一天不持股 转化而来
            dp[i][2]=dp[i-1][0];
        }

        return Math.max(dp[len-1][0],dp[len-1][2]);
    }


    public static void main(String[] args) {
        System.out.println(new _309maxProfit().maxProfit(new int[]{1,2,3,0,2}));
    }
}
