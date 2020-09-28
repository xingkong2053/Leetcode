package com.pengh.leetcode;

import java.util.*;

public class _49groupAnagrams {

    /**
     *  给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * 说明：
     *
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    public List<List<String>> groupAnagrams(String[] strs) {
        //排序字符串
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            //排序字符串
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortString = new String(chars);
            if(!map.containsKey(sortString)) map.put(sortString,new ArrayList<>());
            map.get(sortString).add(str);
        }
        return new ArrayList<>(map.values());
    }
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        //计数法
        if(strs.length==0) return new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();

        int[] count=new int[26];
        for (String str : strs) {
            Arrays.fill(count,0);
            char[] chars = str.toCharArray();
            //获取str中每个字符的数量
            for (char chr : chars) {
                count[chr-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append(i);
                sb.append('*');
            }
            String keyStr = sb.toString();
            if(!map.containsKey(keyStr)) map.put(keyStr,new ArrayList<>());
            map.get(keyStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        _49groupAnagrams ga = new _49groupAnagrams();

        List<List<String>> lists = ga.groupAnagrams(new String[]{"dad","day","day"});
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s+" ");
            }
            System.out.println();
        }
//        System.out.println(ga.isAnagrams("dad","day"));

    }

}
