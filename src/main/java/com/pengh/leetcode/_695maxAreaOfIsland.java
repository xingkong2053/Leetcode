package com.pengh.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _695maxAreaOfIsland {

    /**
     * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
     *
     * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     *
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
     *
     *  
     *
     * 示例 1:
     *
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
     *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
     *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
     *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
     *
     * 示例 2:
     *
     * [[0,0,0,0,0,0,0,0]]
     * 对于上面这个给定的矩阵, 返回 0。
     *
     *  
     *
     * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/max-area-of-island
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Coordinate{
        int x;
        int y;
        Coordinate(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length;
        if(row==0) return 0;
        int col=grid[0].length;
        if(col==0) return 0;

        Queue<Coordinate> queue=new LinkedList<>();
        int[][] direction=new int[][]{{0,1},{-1,0},{1,0}};

        int result=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) continue;
                grid[i][j] = 0;
                int cnt = 0;
                queue.offer(new Coordinate(i, j));
                while (!queue.isEmpty()) {
                    Coordinate coor = queue.remove();
                    for (int[] ints : direction) {
                        int x = coor.x + ints[0];
                        int y = coor.y + ints[1];
                        if (x == row || x < 0 || y == col || y < 0) continue;
                        if (grid[x][y] == 1) {
                            queue.offer(new Coordinate(x, y));
                            grid[x][y] = 0;
                        }
                    }
                    cnt++;
                }
                result=Math.max(result,cnt);
            }
        }
        return result;
    }

}
