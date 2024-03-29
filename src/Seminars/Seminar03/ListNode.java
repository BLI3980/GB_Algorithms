package Seminars.Seminar03;

public class ListNode {
    private int value;
    private ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    /**
     * Дано 2 отсортированных связных списка.
     * Нужно их смержить и получить новый отсортированный связный список.
     *
     * (1, 2, 3), (1, 2, 2, 4) -> (1, 1, 2, 2, 2, 3, 4);
     * (1, 2), (3, 4, 5, 6) -> (1, 2, 3, 4, 5, 6).
     */
    // (a && b) ~ !a || !b
    // a || b ~ !a && !b
    static ListNode merge(ListNode first, ListNode second) {
        ListNode head = null; // 1 -> 1 -> 2
        ListNode iterator = null; // 2
        while (first != null || second != null) {
            int nextValue = -1; // 2

            if (first == null) { // second != null
                nextValue = second.value;
                second = second.next;
            } else if (second == null) {
                nextValue = first.value;
                first = first.next;
            } else if (first.value > second.value) {
                nextValue = second.value;
                second = second.next;
            } else { // if (first.value <= second.value) {
                nextValue = first.value;
                first = first.next;
            }

            if (head == null) {
                head = new ListNode(nextValue);
                iterator = head;
            } else {
                iterator.next = new ListNode(nextValue);
                iterator = iterator.next;
            }
        }
        return head;
    }

    /**
     * Распечатать все элементы связного списка
     */
    static void iterate(ListNode node) {
        ListNode iter = node; // [null]
        while (iter != null) {
            System.out.print(iter.value + " -> ");
            iter = iter.next;
        }
        System.out.println("null");
    }

    /**
     * Создать список, полученный из head прибавлением value в начало
     */
    static ListNode insertFirst(ListNode head, int value) {
        return new ListNode(value, head);
    }

    /**
     * Добавить к существующему списку в конце значение value
     */
    static void insertLast(ListNode head, int value) {
        ListNode last = new ListNode(value);
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
        }
        iter.next = last;
    }

    /**
     * Удаляет из списка первое вхождение value.
     */
    static void remove(ListNode head, int value) {
        // iter -> 1
        // iter.next -> 2
        // iter.next.next -> 3

        // -> .. -> 1 -> 1 -> null

        ListNode iter = head; // [null]
        while (iter.next != null) {
            if (iter.next.value == value) {
                iter.next = iter.next.next;
                break;
            }
            iter = iter.next;
        }
    }

    /**
     * Разворачиват список в обратную сторону.
     */
    static ListNode reverse(ListNode head) {
        // 0 -> 1 -> 3 -> 4 -> null
        ListNode node = null;
        ListNode iterator = head;
        while (iterator != null) {
            if (node == null) {
                node = new ListNode(iterator.value);
            } else {
                node = insertFirst(node, iterator.value);
            }
            iterator = iterator.next;
        }
        return node;
    }



}

