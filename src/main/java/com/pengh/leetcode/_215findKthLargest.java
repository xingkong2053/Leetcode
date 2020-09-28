package com.pengh.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class _215findKthLargest {

    /**
     * 数组中第k个最大元素
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * 说明:
     *
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    private int[] _nums;

    public int findKthLargest(int[] nums, int k) {

//        //方法1：使用优先队列
//        PriorityQueue<Integer> heap = new PriorityQueue<>((i, j) -> i - j);
//        for (int num : nums) {
//            heap.add(num);
//            if(heap.size()>k) heap.poll();
//        }
//        return heap.poll();

        //方法2：快速选择
        _nums=nums;
        return quickSelect(0,_nums.length-1,_nums.length-k);
    }

    //在数组[left...right]中找第n个最小值
    private int quickSelect(int left,int right,int nthSmallest){

        if(left==right) return _nums[left];
        Random random = new Random();
        int pivotIndex=left+random.nextInt(right-left);
        pivotIndex=partition(left,right,pivotIndex);

        if(nthSmallest==pivotIndex) return _nums[pivotIndex];
        else if(nthSmallest>pivotIndex) return quickSelect(pivotIndex+1,right,nthSmallest);
        else return quickSelect(left,pivotIndex-1,nthSmallest);
    }

    //快速排序切分
    private int partition(int left,int right,int pivotIndex){
        //枢轴
        int pivot=_nums[pivotIndex];
        //将枢轴移动到末尾
        swap(pivotIndex,right);
        int storeIndex=left;
        //将小于枢轴的数都移动到数组的左侧
        for (int i=left;i<=right;i++){
            if (_nums[i]<pivot) {
                swap(i,storeIndex);
                storeIndex++;
            }
        }
        //将枢轴移动到中间
        swap(storeIndex,right);
        return storeIndex;
    }

    //交换
    private void swap(int x,int y){
        int tmp=_nums[x];
        _nums[x]=_nums[y];
        _nums[y]=tmp;
    }

    public static void main(String[] args) {
        int[] nums={1,3,2,5,6,4,2,5,7,3,9,1,8};
        int kthLargest = new _215findKthLargest().findKthLargest(nums, 4);
        System.out.println(kthLargest);
    }
}
