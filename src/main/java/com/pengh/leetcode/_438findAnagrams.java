package com.pengh.leetcode;

import java.util.*;

public class _438findAnagrams {

    /**
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     *
     * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     *
     * 说明：
     *
     * 字母异位词指字母相同，但排列不同的字符串。
     * 不考虑答案输出的顺序。
     * 示例 1:
     *
     * 输入:
     * s: "cbaebabacd" p: "abc"
     *
     * 输出:
     * [0, 6]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     *  示例 2:
     *
     * 输入:
     * s: "abab" p: "ab"
     *
     * 输出:
     * [0, 1, 2]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    private int[] chrCnt=new int[26];

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result=new ArrayList<>();
        if(s.length()==0||p.length()==0) return result;
        String key=generateKey(p);
        for(int i=0;i<s.length()-p.length()+1;i++){
            String sub=s.substring(i,i+p.length());
            if(key.equals(generateKey(sub))) result.add(i);
        }
        return result;
    }

    private String generateKey(String s){
        //生成字符串p的验证字符串
        Arrays.fill(this.chrCnt,0);
        for (int i = 0; i < s.length(); i++) {
            chrCnt[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int cnt : chrCnt) {
            sb.append(cnt);
            sb.append("*");
        }
        return sb.toString();
    }

     */

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result=new ArrayList<>();
        if(s.length()==0||p.length()==0) return result;

        Map<Character,Integer> map=new HashMap<>();
        //字符串p中各字符的个数
        for (char c : p.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> window=new HashMap<>();
        int left=0;     //左指针
        int right=0;    //右指针
        int valid=p.length();
        while(right<s.length()){
            char chr=s.charAt(right);
            if (map.containsKey(chr)) {
                window.put(chr,window.getOrDefault(chr,0)+1);
                if(window.get(chr)<=map.get(chr)){
                    valid--;
                }
            }

            while(valid==0){
                if (right-left+1==p.length()) result.add(left);
                chr=s.charAt(left);
                if(map.containsKey(chr)){
                    window.put(chr,window.getOrDefault(chr,0)-1);
                    if(window.get(chr)<map.get(chr)){
                        valid++;
                    }
                }
                left++;
            }
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _438findAnagrams().findAnagrams("cbaebabacd","abc"));
    }
}
