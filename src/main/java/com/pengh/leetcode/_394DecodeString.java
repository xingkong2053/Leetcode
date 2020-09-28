package com.pengh.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class _394DecodeString {


    /**
     * 394. 字符串解码
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     *
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     *
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     *
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     *
     * 原题链接 ： https://leetcode-cn.com/problems/decode-string/
     * @param s
     * @return
     */
    public String decodeString(String s){
        if(s==null) return null;

        int len=s.length();

        int digit=0;
        StringBuilder snippet=new StringBuilder();

        //辅助栈
        LinkedList<String> snippetStack=new LinkedList<>();
        LinkedList<Integer> digitStack=new LinkedList<>();


        for (char c : s.toCharArray()) {
            //c为数字
            if(Character.isDigit(c)) digit=digit*10+c-'0';

            //c为字母
            else if((Character.isLetter(c)))  snippet.append(c);

            else if(c=='['){
                digitStack.push(digit);
                snippetStack.push(snippet.toString());
                digit=0;
                snippet=new StringBuilder();
            }

            else if(c==']'){
                int n = digitStack.pop();
                snippet=new StringBuilder(snippetStack.pop()+snippet.toString().repeat(n));
            }
        }


        return snippet.toString();

    }


    public static void main(String[] args) {
        System.out.println(new _394DecodeString().decodeString("3[a2[c]]"));
    }

}
