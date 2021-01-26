package io.hotcool.structure;

import java.util.LinkedList;
import java.util.List;

public class TreeNodeProblems {
    List<Integer> theList = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(null == root)
            return theList;
        inorderTraversal(root.left);
        theList.add(root.val);
        inorderTraversal(root.right);

        return theList;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<>();

        return solve(1, n);
    }

    public List<TreeNode> solve(int low, int high){
        List<TreeNode> list = new LinkedList<>();
        if(low > high){
            list.add(null);
            return list;
        }

        for(int i = low; i <= high; ++i){
            List<TreeNode> left = solve(low, i - 1);
            List<TreeNode> right = solve(i + 1, high);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode result = new TreeNode(i);
                    result.left = l;
                    result.right = r;
                    list.add(result);
                }
            }
        }

        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}