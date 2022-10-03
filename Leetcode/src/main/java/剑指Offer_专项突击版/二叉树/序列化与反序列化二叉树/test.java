package 剑指Offer_专项突击版.二叉树.序列化与反序列化二叉树;

import LeetCode.热题100.hard.二叉树路径最大和.TreeNode;

public class test {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node = new TreeNode(1,null,new TreeNode(3,null,new TreeNode(1)));
        System.out.println(codec.serialize(node));
    }
}
