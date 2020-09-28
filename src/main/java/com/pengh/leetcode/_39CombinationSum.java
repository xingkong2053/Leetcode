package com.pengh.leetcode;

import java.util.*;

public class _39CombinationSum {

    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<List<Integer>>();
        Arrays.sort(candidates);

        func(new ArrayList<Integer>(),candidates,target,0);

        return result;
    }

    private void func(List<Integer> nums,int[] candidates,int target,int start){
        if(target<0) return;
        if(target==0){
            result.add(new ArrayList<Integer>(nums));
        }


        for (int i = start; i < candidates.length; i++) {
            nums.add(candidates[i]);
            func(new ArrayList<Integer>(nums),candidates,target-candidates[i],i);
            nums.remove(nums.size()-1);
        }
    }

    public static void main(String[] args) {

        int[] ints = {2, 3, 6,7};
        List<List<Integer>> lists = new _39CombinationSum().combinationSum(ints, 7);
        System.out.println(lists);
    }
}