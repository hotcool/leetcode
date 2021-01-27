package io.hotcool.structure;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean check(TreeNode root, long max , long min){
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return check(root.left, root.val, min) && check(root.right, max, root.val);
    }

    public boolean isSymmetric(TreeNode root) {
        if(null == root)
            return true;
        if(null == root.left && null == root.right)
            return true;
        if( (null == root.left && null != root.right) || (null != root.left && null == root.right))
            return false;
        return root.left.val == root.right.val && subNode(root.left, root.right);
    }

    private boolean subNode(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null)
            return node1.val == node2.val && subNode(node1.left, node2.right) && subNode(node1.right, node2.left);
        else if (node1 == null && node2 == null)
            return true;
        else
            return false;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(null == root)
            return new LinkedList<>();

        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int height = 1;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> l = new LinkedList<>();
            for(int i = 0; i < size; ++i){
                TreeNode r = q.poll();
                if(height % 2 == 0){
                    l.addFirst(r.val);
                }
                else{
                    l.add(r.val);
                }
                if(null != r.left){
                    q.add(r.left);
                }
                if(null != r.right){
                    q.add(r.right);
                }
            }
            list.add(l);
            ++height;
        }

        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(null == root)
            return new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> l = new LinkedList<>();
            for(int i = 0; i < size; ++i){
                TreeNode r = q.poll();
                l.add(r.val);
                if(null != r.left){
                    q.add(r.left);
                }
                if(null != r.right){
                    q.add(r.right);
                }
            }
            list.add(l);
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