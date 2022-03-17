package homework_3;

import homework_3.queue.QueueImpl;

import java.util.Arrays;

public class Homework_3 {
    private static Long time;
    public static void main(String[] args) {
/*  1. Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1).
       Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.

       Примеры:
                [1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
                [1, 2, 4, 5, 6] => 3
                [] => 1

       (дополнительно).
       2. Закольцевать очередь, чтобы после извлечения элементов пустые ячейки по пере использовались*/

        int[] arr = new int[]{1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16}; // 11
        int[] arr1 = new int[]{1, 2 ,3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}; // 4
        int[] arr2 = new int[]{1, 2 ,3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16}; // 8
        int[] arr3 = new int[]{1, 2, 4, 5, 6}; // 3
        int[] arr4 = new int[]{2, 3, 4, 5, 6}; // 1
        int[] arr5 = new int[1]; // 1

        System.out.println(Arrays.toString(arr) + " -> Пропущено число - " + search(arr) + "\n");
        System.out.println(Arrays.toString(arr1) + " -> Пропущено число - " + search(arr1) + "\n");
        System.out.println(Arrays.toString(arr2) + " -> Пропущено число - " + search(arr2) + "\n");
        System.out.println(Arrays.toString(arr3) + " -> Пропущено число - " + search(arr3) + "\n");
        System.out.println(Arrays.toString(arr4) + " -> Пропущено число - " + search(arr4) + "\n");
        System.out.println(Arrays.toString(arr5) + " -> Пропущено число - " + search(arr5) + "\n");


        testQueue();

    }

    private static void testQueue() {

        QueueImpl<Integer> queue = new QueueImpl<>(4);

        System.out.println("add element: 34 " + queue.insert(34) + "  head = " + queue.getHead() + "  tail = " + queue.getTail());
        System.out.println("add element: 12 " + queue.insert(12) + "  head = " + queue.getHead() + "  tail = " + queue.getTail());
        System.out.println("add element: 20 " + queue.insert(20) + "  head = " + queue.getHead() + "  tail = " + queue.getTail());
        System.out.println("add element: 16 " + queue.insert(16) + "  head = " + queue.getHead() + "  tail = " + queue.getTail());
        System.out.println("add element: 14 " + queue.insert(14) + "  head = " + queue.getHead() + "  tail = " + queue.getTail());
        System.out.println("add element: 17 " + queue.insert(17) + "  head = " + queue.getHead() + "  tail = " + queue.getTail());

        queue.display();
        System.out.print("remove: " + queue.remove() + "  head = " + queue.getHead() +
                "  tail = " + queue.getTail() + ", size = " + queue.size() + " -> ");
        queue.display();
        System.out.print("remove: " + queue.remove() + "  head = " + queue.getHead() +
                "  tail = " + queue.getTail() + ", size = " + queue.size() + " -> ");
        queue.display();
        System.out.print("add element: 17 " + queue.insert(17) + "  head = " + queue.getHead() +
                "  tail = " + queue.getTail() + ", size = " + queue.size() + " -> ");
        queue.display();
        System.out.print("add element: 44 " + queue.insert(44) + "  head = " + queue.getHead() +
                "  tail = " + queue.getTail() + ", size = " + queue.size() + " -> ");
        queue.display();
        System.out.print("add element: 45 " + queue.insert(45) + "  head = " + queue.getHead() +
                "  tail = " + queue.getTail() + ", size = " + queue.size() + " -> ");
        queue.display();
        System.out.print("remove: " + queue.remove() + "  head = " + queue.getHead() +
                "  tail = " + queue.getTail() + ", size = " + queue.size() + " -> ");
        queue.display();
        System.out.print("add element: 45 " + queue.insert(45) + "  head = " + queue.getHead() +
                "  tail = " + queue.getTail() + ", size = " + queue.size() + " -> ");
        queue.display();
        System.out.print("remove: " + queue.remove() + "  head = " + queue.getHead() +
                "  tail = " + queue.getTail() + ", size = " + queue.size() + " -> ");
        queue.display();
        System.out.print("add element: 70" + queue.insert(70) + "  head = " + queue.getHead() +
                "  tail = " + queue.getTail() + ", size = " + queue.size() + " -> ");
        queue.display();
        System.out.print("remove: " + queue.remove() + "  head = " + queue.getHead() +
                "  tail = " + queue.getTail() + ", size = " + queue.size() + " -> ");
        queue.display();
        System.out.print("add element: 80 " + queue.insert(80) + "  head = " + queue.getHead() +
                "  tail = " + queue.getTail() + ", size = " + queue.size() + " -> ");
        queue.display();

    }

    private static int search(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        if (arr[start] != start + 1) {
            System.out.println("НАЙДЕНО! Кол-во итераций: " + 1);
        } else {

            int base;

            int i = 0;

            while (end >= start) {
                i++;
                base = (start + end) / 2;
                if (arr[base] != base + 1 && arr[base - 1] == base) {
                    System.out.println("НАЙДЕНО! Кол-во итераций: " + i);
                    return base + 1;
                } else if (arr[base] == base + 1) {
                    start = base + 1;
                } else {
                    end = base - 1;
                }
            }
        }
        return start + 1;
    }
}
