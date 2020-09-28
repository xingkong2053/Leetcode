package com.pengh.leetcode;

import java.util.Arrays;

public class _221maximalSquare {

    /**
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
     *
     * 示例:
     *
     * 输入:
     *
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     *
     * 输出: 4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximal-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    public int maximalSquare(char[][] matrix) {
        //动态规划（二维数组）
        int row=matrix.length,col=row!=0?matrix[0].length:0;
        int[][] dp=new int[row+1][col+1];
        int maxLen=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j]=='1') {
                    //取三者之中的最小值
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i + 1][j]), dp[i][j + 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i + 1][j + 1]);
                }
            }
        }

        return maxLen*maxLen;
    }

     */
    public int maximalSquare(char[][] matrix) {
        //动态规划（一维数组）
        int row=matrix.length,col=row!=0?matrix[0].length:0;
        int[] dp=new int[col],tmp;
        int maxLen=0;
        for (int i = 0; i < row; i++) {
            tmp= Arrays.copyOf(dp,dp.length);
            for (int j = 0; j < col; j++) {
                if(matrix[i][j]=='1') {
                    //取三者之中的最小值
                    dp[j+1]=Math.min(Math.min(tmp[j],tmp[j+1]),dp[j])+1;
                    maxLen=Math.max(maxLen,dp[j+1]);
                }
            }
        }

        return maxLen*maxLen;
    }


}
