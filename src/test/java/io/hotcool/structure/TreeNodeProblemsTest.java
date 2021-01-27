package io.hotcool.structure;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

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

    @Test
    public void testMu(){
        Queue<String> q = new LinkedList<>();
        q.add("A");
        q.add("B");
        q.add("C");
        q.add("D");
        q.add("E");
        q.add("F");
        q.add("G");
        q.add("H");
        q.add("I");
        q.add("J");
        System.out.println(q);
        TreeNodeProblems p = new TreeNodeProblems();
        System.out.println(p.music(q, 3));
    }

}