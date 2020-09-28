package com.pengh.leetcode;

import java.util.Arrays;

public class _300lengthOfLIS {

    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例:
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * 说明:
     *
     * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     * 你算法的时间复杂度应该为 O(n2) 。
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;

//        //动态规划
//        //dp[i] 前i项数中递增数的个数
//        int[] dp=new int[len];
//        Arrays.fill(dp, 1);
//
//        int maxVal=1;
//
//        for(int i=1;i<len;i++){
//            for(int j=0;j<i;j++){
//                //nums[i]可以接在nums[j]之后
//                if(nums[j]<nums[i]) dp[i]=Math.max(dp[i],dp[j]+1);
//            }
//            maxVal=Math.max(maxVal,dp[i]);
//        }
//        return maxVal;

        //动态规划+二分查找
        int[] tails=new int[len];   //tail[1]==9 代表连续上升数列的最后一个数字为9
        int res=0;
        for(int num:nums){
            int i=0,j=res;
            while(i<j){
                int m=(i+j)/2;
                if(tails[m]<num) i=m+1;
                else j=m;
            }
            tails[i]=num;
            if(res==j) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        new _300lengthOfLIS().lengthOfLIS(new int[]
                {10,9,2,5,3,7,101,18});
    }
}
