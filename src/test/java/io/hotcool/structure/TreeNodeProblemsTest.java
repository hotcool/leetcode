package io.hotcool.structure;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeNodeProblemsTest {

    @Test
    public void test5(){
        TreeNode tl = new TreeNode(1);
        TreeNode tr = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        TreeNode r = new TreeNode(5, tl, tr);

        TreeNodeProblems tp = new TreeNodeProblems();
        System.out.println(tp.isValidBST(r));
    }

}