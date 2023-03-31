package Homeworks.Homework03;

public class Homework03 {

    static class ListNode {
        int value;

        ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(4)))); // 1 -> 2 -> 2 -> 4
        ListNode node1 = new ListNode(5);

        // 1. Посчитать размер списка.
        System.out.println(size(node)); // 4

        // 2. Написать строковое представление списка в формате [first_value -> second_value -> ... -> last_value]
        // Вариант без создания строкового объекта
        asString(node); // [1 -> 2 -> 2 -> 4]
        asString(node1); // [5]

        // Вариант с созданием строкового объекта
        System.out.println(asString1(node)); // [1 -> 2 -> 2 -> 4]
        System.out.println(asString1(node1)); // [5]

//         3. Найти значение по индексу
        System.out.println(getByIndex(node, 0)); // 1
        System.out.println(getByIndex(node, 3)); // 4
        System.out.println(getByIndex(node, 4)); // new IndexOutOfBoundsException

    }

    /**
     * Посчитать размер списка.
     */
    static int size(ListNode node) {
        ListNode iter = node;
        int size = 0;
        while (iter != null) {
            size++;
            iter = iter.next;
        }
        return size;
    }

    /**
     * Написать строковое представление списка в формате
     * [first_value -> second_value -> ... -> last_value]
     */
    static void asString(ListNode node) {
        ListNode iter = node;
        // === WITH BRACKETS DEFINED INSIDE LOOP ===
//        while (iter != null) {
//            if(iter == node && iter.next == null) {
//                System.out.print("[" + iter.value + "]");
//            } else if(iter == node) {
//                System.out.print("[" + iter.value + " -> ");
//            } else if(iter.next == null) {
//                System.out.print(iter.value + "]");
//            } else {
//                System.out.print(iter.value + " -> ");
//            }
//            iter = iter.next;
//        }
//        System.out.println();

        // === OR WITH BRACKETS DEFINED OUTSIDE LOOP ===
        System.out.print("[");
        while (iter != null) {
            if(iter.next == null) {
                System.out.print(iter.value);
            } else {
                System.out.print(iter.value + " -> ");
            }
            iter = iter.next;
        }
        System.out.println("]");

    }

    static String asString1(ListNode node) {
        ListNode iter = node;
        String result = "";
        while (iter != null) {
            if(iter == node && iter.next == null) {
                result += "[" + iter.value + "]";
            } else if(iter == node) {
                result += "[" + iter.value + " -> ";
            } else if(iter.next == null) {
                result += iter.value + "]";
            } else {
                result += iter.value + " -> ";
            }
            iter = iter.next;
        }
        return result;
    }

    /**
     * Найти значение по индексу
     */
    static int getByIndex(ListNode node, int index) {
        ListNode iter = node;
        int iterIndex = 0;
        while (iter != null) {
            if(iterIndex == index) {
                return iter.value;
            }
            iterIndex++;
            iter = iter.next;
        }
        throw new IndexOutOfBoundsException();
    }





}
