package com.pengh.leetcode;

public class _200numIslands {

    /**
     * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
     * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
     * 你可以假设网格的四个边均被水包围。
     *
     * 示例 1:
     *
     * 输入:
     * 11110
     * 11010
     * 11000
     * 00000
     *
     * 输出: 1
     * 示例 2:
     *
     * 输入:
     * 11000
     * 11000
     * 00100
     * 00011
     *
     * 输出: 3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int numIslands(char[][] grid) {



        //深度优先搜索
        int row=grid.length;
        int col=grid[0].length;
        int result=0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]=='0') continue;
                dfs(grid,i,j);
                result++;
            }
        }

        return result;

    }


    private void dfs(char[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0')
            return;

        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
    }


    public static void main(String[] args) {
        System.out.println(
                new _200numIslands().numIslands(
                        new char[][]{
                                new char[]{'1','1','0','0','0'},
                                new char[]{'1','1','0','0','0'},
                                new char[]{'0','0','0','1','0'},
                                new char[]{'0','0','0','0','0'},
                                new char[]{'1','1','0','0','1'},
                        }
                )
        );
    }


}
