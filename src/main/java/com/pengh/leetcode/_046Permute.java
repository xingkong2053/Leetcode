package com.pengh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class _046Permute {

    private ArrayList<List<Integer>> result= new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        int len=nums.length;
        List<Integer> list=new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        if(nums.length==0) return result;
        func(0,list,len);
        return result;
    }

    private void func(int first,List<Integer> nums,int n){
        if(first==n) result.add(new ArrayList<Integer>(nums));

        for (int i = first; i < n; i++) {
            Collections.swap(nums,first,i);
            func(first+1,nums,n);
            Collections.swap(nums,first,i);
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> permute = new _046Permute().permute(new int[]{1, 2, 3});

        System.out.println(permute);

    }

}
