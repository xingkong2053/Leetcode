package com.pengh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _297Codec {

    /**
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     *
     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     *
     * 示例: 
     *
     * 你可以将以下二叉树：
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * 序列化为 "[1,2,3,null,null,4,5]"
     * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
     *
     * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    private void rserialize(TreeNode x,StringBuilder sb){
        if(x==null) {
            sb.append("null,");
            return;
        }

        //深度优先搜索
        int value=x.val;
        sb.append(value).append(",");
        rserialize(x.left,sb);
        rserialize(x.right,sb);
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        rserialize(root,sb);
        return sb.toString();
    }

    private TreeNode rdeserialize(List<String> list){
        if(list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(list.remove(0)));
        root.left=rdeserialize(list);
        root.right=rdeserialize(list);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> strings=new ArrayList<>(Arrays.asList(data.split(",")));
        return rdeserialize(strings);
    }

    public static void main(String[] args) {

        /**
         *      *     1
         *      *    / \
         *      *   2   3
         *      *      / \
         *      *     4   5
         */
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(5);
        String ser=new _297Codec().serialize(root);
        TreeNode root2=new _297Codec().deserialize(ser);
        String ser2=new _297Codec().serialize(root2);
        System.out.println(ser2);
    }
}
