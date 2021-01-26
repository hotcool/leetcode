package io.hotcool.structure;

import org.junit.Test;

import static org.junit.Assert.*;
import io.hotcool.structure.ListNodeProblems.ListNode;

public class ListNodeProblemsTest {

    @Test
    public void testPartitionList(){
        ListNode node5 = new ListNode(2);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(4, node2);
        ListNode node0 = new ListNode(1, node1);

        System.out.println(node0);

        ListNodeProblems problems = new ListNodeProblems();
        ListNode result = problems.partition(node0, 3);

        System.out.println(result);
    }

    @Test
    public void testPartitionList1(){
        ListNode node5 = new ListNode(1);
        ListNode node4 = new ListNode(2, node5);

        System.out.println(node4);

        ListNodeProblems problems = new ListNodeProblems();
        ListNode result = problems.partition(node4, 2);

        System.out.println(result);
    }

    @Test
    public void testRemoval(){
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(3, node2);
        ListNode node7 = new ListNode(2, node1);
        ListNode node0 = new ListNode(1, node7);

        System.out.println(node0);

        ListNodeProblems problems = new ListNodeProblems();
        ListNode result = problems.deleteDuplicates(node0);

        System.out.println(result);
    }

    @Test
    public void testReverse2(){
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNodeProblems problems = new ListNodeProblems();

        System.out.println(problems.reverseBetween(node1, 2, 4));
    }
}