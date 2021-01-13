package io.hotcool.structure;

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
            return String.valueOf(val) + this.next.val;
        }
    }
}
