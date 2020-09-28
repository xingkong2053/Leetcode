package com.pengh.leetcode;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _128longestConsecutive {
    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     *
     * 要求算法的时间复杂度为 O(n)。
     *
     * 示例:
     *
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        Set<Integer> numSet=new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }

        int length=1;
        int maxLength=1;
        int curNum;

        for (int num : nums) {
            //num总是从连续序列的最小值开始
            if(numSet.contains(num-1)) continue;
            curNum=num;
            while(numSet.contains(curNum+1)){
                length++;
                curNum++;
            }

            maxLength=Math.max(length,maxLength);
            length=1;
        }

        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println("result= " + new _128longestConsecutive().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }


}
