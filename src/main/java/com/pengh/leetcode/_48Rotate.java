package com.pengh.leetcode;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _48Rotate {

    public void rotate(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;

        int tmp;
        for (int i = 0; i < row-1; i++) {       //转置矩阵
            for (int j = 0; j < row-1-i; j++) {
                tmp=matrix[i][j];
                matrix[i][j]=matrix[row-1-j][row-1-i];
                matrix[row-1-j][row-1-i]=tmp;
            }
        }

        int[] tmpArr;
        for (int i = 0; i < row/2; i++) {         //翻转行
            tmpArr=matrix[i];
            matrix[i]=matrix[row-1-i];
            matrix[row-1-i]=tmpArr;
        }
    }


}
