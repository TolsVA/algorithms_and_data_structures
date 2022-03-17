package homework_4;

import java.util.ListIterator;

public class Homework_4 {
    public static void main(String[] args) {

        MyLinkedListDubl<Integer> myLinkedList = new MyLinkedListDubl<>();

        for (int i = 1; i <= 10; i++) {
            myLinkedList.addLast(i);
        }

        System.out.print("Создан массив -            ");
        myLinkedList.display();

        System.out.print("Удалён первый элемент - " + myLinkedList.getFirst() +"   ");
        myLinkedList.removeFirst();
        myLinkedList.display();

        System.out.print("Удалён последний элемент - " + myLinkedList.getLast() +"   ");
        myLinkedList.removeLast();
        myLinkedList.display();
        myLinkedList.addIndex(0, 5);
        myLinkedList.display();

        myLinkedList.setKeyAll(8, 5);
        myLinkedList.display();

        myLinkedList.indexOf(5);
        myLinkedList.addLast(5);
        myLinkedList.display();

        testIterator(myLinkedList);

        testIterator2(myLinkedList);

        testDeque();
    }

    private static void testDeque() {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        System.out.println("testDeque()");
        for (int i = 1; i < 8; i++) {
            linkedQueue.insertFirst(i);
        }
        linkedQueue.insertLast(8);
        linkedQueue.insertLast(9);
        linkedQueue.insertLast(10);

        linkedQueue.display();

        linkedQueue.contains(4);

        int first = linkedQueue.getFirst();
        linkedQueue.removeFirst();
        System.out.print("Удалён первый элемент - " + first + " -> ");
        linkedQueue.display();

        int last = linkedQueue.getLast();
        linkedQueue.removeLast();
        System.out.print("Удалён последний элемент - " + last + " -> ");
        linkedQueue.display();

        int val = 3;
        linkedQueue.remove(val);
        System.out.print("Удалены элементы по ключу - " + val + " -> ");
        linkedQueue.display();

    }

    private static <E> void testIterator2(MyLinkedListDubl<E> myLinkedList) {

        StringBuilder s = new StringBuilder("[");

        s.append(myLinkedList.getFirst());

        for (E val : myLinkedList) {
            s.append(", ").append(val);
        }
        System.out.println(s.append("]"));
    }

    private static <E> void testIterator(MyLinkedListDubl<E> myLinkedList) {

        ListIterator<E> iterator = myLinkedList.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            E val = iterator.previous();
            if (val.equals(5)){
                iterator.remove();
            }
            iterator.next();
            if (!iterator.hasNext()) {
                iterator.previous();
                val = iterator.next();
                if (val.equals(5)){
                    iterator.remove();
                }
            }
        }
        myLinkedList.display();

        while (!iterator.hasNext()) {
            iterator.next();
        }

        while (iterator.hasNext()) {
            iterator.next();
            Integer s = iterator.previousIndex();
            E e = iterator.previous();
            while (!e.equals(s)){
                iterator.add((E)s);
                s++;
            }
            iterator.next();
            s++;
            if (!iterator.hasNext()) {
                if (!e.equals(s)) {
                    iterator.add((E)s);
                }
            }
        }
        myLinkedList.display();

        while (iterator.hasNext()) {
            iterator.next();
        }
        System.out.print("Проход в обратную сторону - [" + iterator);
        iterator.previous();
        while (iterator.hasNext()) {
            System.out.print(", " + iterator);
            iterator.previous();
        }
        System.out.print("]");
        System.out.println();

        while (!iterator.hasNext()) {
            iterator.next();
        }

        Integer s = 8;
        while (iterator.hasNext()) {
            iterator.set((E) s);
            iterator.next();
            if (!iterator.hasNext()) {
                iterator.set((E) s);
            }
        }
        while (!iterator.hasNext()) {
            iterator.next();
        }

        System.out.print("[" + iterator);
        iterator.forEachRemaining(val -> System.out.print(", " + iterator));
        System.out.print("]\n");

    }
}
