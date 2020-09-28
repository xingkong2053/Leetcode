package com.pengh.leetcode;


import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;

public class _239maxSlidingWindow {

    /**
     *  给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     *  
     *
     * 示例:
     *
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *  
     *
     * 提示：
     *
     * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
     *
     *  
     *
     * 进阶：
     *
     * 你能在线性时间复杂度内解决此题吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        //分块策略
        int len=nums.length;
        if(len==0) return new int[0];
        int[] result=new int[len-k+1];
        int[] left=new int[len],right=new int[len];

        for(int i=0;i<len;i++){
            if(i%k==0) left[i]=nums[i];
            else left[i]=Math.max(nums[i],left[i-1]);
        }

        for(int i=len-1;i>=0;i--){
            if(i%k==(k-1)||i==len-1) right[i]=nums[i];
            else right[i]=Math.max(right[i+1],nums[i]);
        }

        for(int i=0;i<len-k+1;i++){
            result[i]=Math.max(left[i+k-1],right[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        int[] ints=new int[]{1,3,-1,-3,5,3,6,7};
        int[] window = new _239maxSlidingWindow().maxSlidingWindow(ints, 3);
        System.out.println(Arrays.toString(window));
    }



}
