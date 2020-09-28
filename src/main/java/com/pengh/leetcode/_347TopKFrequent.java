package com.pengh.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class _347TopKFrequent {


    /***
     * 347. 前 K 个高频元素
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *
     *
     * 提示：
     *
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
     * 你可以按任意顺序返回答案。

     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null||nums.length==0) return new int[0];

        //使用map统计元素出现的个数
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,Comparator.comparingInt(i->map.getOrDefault(i,0)));

        for (int key : map.keySet()) {
            if(pq.size()<k){
                pq.add(key);
            }
            else if(map.get(key)>map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }

        Integer[] pqArray = pq.toArray(new Integer[k]);
        int[] result=new int[k];
        for (int i = 0; i < k; i++) {
            result[i]=pqArray[i];
        }

        return result;
    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString(new _347TopKFrequent().topKFrequent(new int[]{4,1,-1,2,-1,2,3},2)));
    }

}
