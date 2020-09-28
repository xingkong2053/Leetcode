package com.pengh.leetcode;


import java.util.Arrays;
import java.util.Comparator;

public class _435eraseOverlapIntervals {

    /**
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     *
     * 注意:
     *
     * 可以认为区间的终点总是大于它的起点。
     * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
     * 示例 1:
     *
     * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
     *
     * 输出: 1
     *
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     * 示例 2:
     *
     * 输入: [ [1,2], [1,2], [1,2] ]
     *
     * 输出: 2
     *
     * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
     * 示例 3:
     *
     * 输入: [ [1,2], [2,3] ]
     *
     * 输出: 0
     *
     * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int eraseOverlapIntervals(int[][] intervals) {

        int len=intervals.length;
        if(len==0) return 0;
        /*
        //将数组按照intervals[i][1]值排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int minEnd=intervals[0][1];
        //非重叠区间的个数
        int cnt=1;
        for (int[] interval : intervals) {
            if(interval[0]>=minEnd){
                cnt++;
                minEnd=interval[1];
            }
        }

        //需要移除的区间数量=总数-非重叠区间的个数
        return len-cnt;

         */

        //动态规划
        //将数组按照intervals[i][0]的值进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //dp[i] 第i项之前（包括第i项）非重叠区间的个数
        int[] dp=new int[len];
        int cnt=1;
        dp[0]=1;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
               if(intervals[j][1]<=intervals[i][0]){
                   dp[i]=Math.max(dp[i],dp[j]);
               }
            }
            dp[i]++;
            cnt=Math.max(cnt,dp[i]);
        }

        return len-cnt;
    }


}
