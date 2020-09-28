package com.pengh.leetcode;

public class _42trap {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     *
     *
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
     *
     * 示例:
     *
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    public int trap(int[] height) {
        if(height.length<=2) return 0;

        //按行求
        //1获取最大高度
        int maxHeight=height[0];
        for (int i = 1; i < height.length; i++) {
            if(maxHeight<height[i]) maxHeight=height[i];
        }

        int result=0;
        //分别求高度为1，2，3中雨水的数量
        for (int i = 1; i <= maxHeight; i++) {
            boolean start=false;
            int tmpCnt=0;
            for (int h : height) {
                if(h>=i)
                    if(!start) start=true;  //h>=i&&start==false
                    else {                  //h>=i&&start==true
                        result+=tmpCnt;
                        tmpCnt=0;
                    }
                else if(start) tmpCnt++;    //h<i&&start
            }
        }
        return result;
    }
     */

    public int trap(int[] height) {
        int sum=0;
        for (int i = 1; i < height.length-1; i++) {
            int leftMaxHeight=0;
            for(int j=0;j<i;j++) leftMaxHeight=Math.max(leftMaxHeight,height[j]);
            int rightMaxHeight=0;
            for (int j=i+1;j<height.length;j++) rightMaxHeight=Math.max(rightMaxHeight,height[j]);
            int minHeight=Math.min(leftMaxHeight,rightMaxHeight);
            if(minHeight>height[i]) sum+=minHeight-height[i];
        }
        return sum;
    }

//    public static void main(String[] args) {
//        int[] height=new int[]{
//
//        };
//        System.out.println(new _42trap().trap(height));
//    }
}
