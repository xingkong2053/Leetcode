package com.pengh.leetcode;

public class _5LongestPalindrome {

    /**
     * 5.求最长回文子串
     *
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        //中心扩散动态规划
        int len=s.length();
        if(len<=1) return s;

        int maxLen=1;
        int begin=0;

        //dp[i][j] 表示 s[i,j] 是不是个回文子串
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i]=true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if(chars[i]==chars[j]){
                    if(j-i<=2) dp[i][j]=true;
                    else dp[i][j]=dp[i+1][j-1];
                }
                else dp[i][j]=false;
                if (dp[i][j]&&maxLen<j-i+1) {
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }

        return s.substring(begin,begin+maxLen);
    }
}
