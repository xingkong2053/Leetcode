package com.pengh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _239MaxSlidingWindow02 {

    /***
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     *  
     *
     * 进阶：
     *
     * 你能在线性时间复杂度内解决此题吗？
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
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * 1 <= k <= nums.length
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums,int k){
        if(k==1) return nums;

        int len=nums.length;
        int[] result=new int[len-k+1];
        //双端队列 存放下标
        LinkedList<Integer> deque=new LinkedList<>();
        int l=0,r=0;


        for (int i = 0; i < len; i++) {
            //从队尾依次弹出比num[i]小的数
            while (!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]) deque.removeLast();

            //添加当前值对应的数组下标
            deque.addLast(i);

            //判断队首的下标是否有效
            if(deque.peekFirst()<=i-k) deque.removeFirst();

            if(i>=k-1) result[i-k+1]=nums[deque.peekFirst()];
        }

        return result;
    }


    public static void main(String[] args) {

//        int[] testArr={1,3,-1,-3,5,3,6,7};
//
//        //[3,3,5,5,6,7]
//        int[] ints = new _239MaxSlidingWindow02().maxSlidingWindow(testArr, 3);
//        System.out.println(Arrays.toString(ints));
        //与
        System.out.println(0b0110&0b1001);
        //或
        System.out.println(0b0110|0b1001);
        //异或
        System.out.println(0b0110^0b1001);
        //异或
        System.out.println(0b1111^0b1111);

        System.out.println(0b10000011);

        //
        System.out.println(~0b01111111);

        int a=10,b=35;

        // a/2
        System.out.println(a>>1);
        // a*2
        System.out.println(a<<1);
        // a%2
        System.out.println(a&1);

        // Math.pow(2,a)
        System.out.println(1>>a);


        //交换ab
        a^=b;
        b^=a;
        a^=b;
        System.out.println(a+" "+b);
        a^=b;
        b^=a;
        a^=b;


        //求ab均值
        System.out.println(a+((a-b)>>1));

        //变换符号
        System.out.println((~a)+1);

        //判断符号是否相同
        System.out.println((a^b)>0);

    }

}
