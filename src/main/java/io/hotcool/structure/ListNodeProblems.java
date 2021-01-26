package io.hotcool.structure;

import java.util.HashMap;

public class ListNodeProblems {

    public ListNode partition(ListNode head, int x) {
        if (null == head)
            return null;

        ListNode greater = new ListNode(-1), lesser = new ListNode(-1);
        ListNode cur = head;
        ListNode pg = greater, pl = lesser;
        while (null != cur) {
            if (cur.val < x) {
                pl.next = new ListNode(cur.val);
                pl = pl.next;
            } else {
                pg.next = new ListNode(cur.val);
                pg = pg.next;
            }
            cur = cur.next;
        }

        pl.next = greater.next;
        return lesser.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(null == head)
            return null;

        ListNode tmp = new ListNode(0);

        ListNode tail = tmp, cur = head;
        while(null != cur){
            if( null != cur.next && cur.next.val == cur.val){
                int lastVal = cur.val;
                while(null != cur && lastVal == cur.val)
                    cur = cur.next;
            }
            else{
                tail.next = cur;
                tail = cur;
                cur = cur.next;
            }
        }
        tail.next = null;
        return tmp.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m < 0 || n < 0)
            return null;

        ListNode fakeHead = new ListNode(-1, head);
        ListNode tmp = fakeHead;
        int i = 1;
        //move to the place
        while( i < m){
            tmp = tmp.next;
            ++i;
        }
        ListNode cur = tmp.next;
        ListNode next = null, prev = null;
        while (i <= n){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            ++i;
        }
        //cur holds tail
        tmp.next.next = cur;
        tmp.next = prev;
        return fakeHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(val) + this.next;
        }
    }
}
