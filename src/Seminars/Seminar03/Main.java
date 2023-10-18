package Seminars.Seminar03;


public class Main {

    public static void main(String[] args) {
        intro();
        ListNode first = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode second = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(4))));
        ListNode merge = ListNode.merge(first, second);
        ListNode.iterate(merge); // 1 -> 1 -> 2 -> 2 -> 2 -> 3 -> 4


    }


    static void intro() {
        // head -> second -> third -> ... -> last -> null
        // 1 -> 2 -> 3
        ListNode third = new ListNode(3); // 3
        ListNode second = ListNode.insertFirst(third, 2); // 2 -> 3
        ListNode first = ListNode.insertFirst(second, 1); // 1 -> 2 -> 3
        ListNode.iterate(first); // 1 -> 2 -> 3 -> null

        ListNode head = ListNode.insertFirst(first, 0); // 0 -> 1 -> 2 -> 3
        ListNode.iterate(head); // 0 -> 1 -> 2 -> 3 -> null

        ListNode.insertLast(head, 4); // 0 -> 1 -> 2 -> 3 -> 4
        ListNode.iterate(head); // 0 -> 1 -> 2 -> 3 -> 4 -> null

        ListNode.remove(head, 2);
        ListNode.iterate(head); // 0 -> 1 -> 3 -> 4 -> null

        head = ListNode.reverse(head);
        ListNode.iterate(head); // 4 -> 3 -> 1 -> 0 -> null
    }

}
