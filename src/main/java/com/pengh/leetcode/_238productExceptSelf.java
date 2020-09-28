package com.pengh.leetcode;

public class _238productExceptSelf {

    /**
     * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     *
     * 示例:
     *
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     * 进阶：
     * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] productExceptSelf(int[] nums) {

        /**
         * 思路：结果=当前数所有左侧所有数的乘积*当前数所有右侧数的乘积
         */
        int[] res=new int[nums.length];
        int k=1;
        for(int i=0;i<nums.length;i++){
            res[i]=k;   //k{i}等于num[i]之前的所有数的乘积
            k=k*nums[i];
        }
        k=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i]*=k;  //k{i}等于num[i]之后所有数的乘积
            k=k*nums[i];
        }

        return res;
    }
}
