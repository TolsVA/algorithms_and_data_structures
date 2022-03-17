package homework_4;

import java.util.ListIterator;
import java.util.function.Consumer;

public class MyLinkedListDubl<E> implements LinkedList<E>, Iterable<E> {
    protected int size = 0;
    private Node<E> head;
    private Node<E> tail;

    public Node<E> getTail() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(E data) {
        Node<E> first = head;
        head = new Node<>(data, head, tail);
        if (isEmpty()) {
            tail = head;
        } else {
            first.prev = head;
            tail.next = head;
        }
        size++;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Удалять нечего -> MyLinkedListDubl[ ] пуст.");
            return;
        }
        if (head == tail) {
            clear();
            return;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }

    @Override
    public E getFirst() {
        return head.data;
    }

    public void addLast(E data) {
        Node<E> last = tail;
        tail = new Node<>(data, head, tail);
        if (isEmpty()) {
            head = tail;
        } else {
            last.next = tail;
            head.prev = tail;
        }
        size++;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Удалять нечего -> MyLinkedListDubl[ ] пуст.");
            return;
        }
        if (head == tail) {
            clear();
            return;
        } else {
            tail = tail.prev;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }

    public void clear() {
        head.data = null;
        head = null;
        tail = null;
        size = 0;
    }

    public E getLast() {
        return tail.data;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        Node<E> node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        int s = 1;
        if (!isEmpty()) {
            while (node != tail) {
                if (s % 10 == 0) {
                    sb.append(node.data).append(" <->\n                             ");
                } else {
                    sb.append(node.data).append(" <-> ");
                }
                node = node.next;
                s++;
            }
            sb.append(node.data);
        }
        sb.append(" ] - MyLinkedListDubl содержит ").append(size).append(" элементов.\n");

        return sb.toString();
    }


    public void addIndex(int index, E data) {
        if (index <= 0) {
            addFirst(data);
            return;
        }
        if (index >= size) {
            addLast(data);
            return;
        }
        Node<E> find = head;
        int c = 0;
        while (c != index) {
            find = find.next;
            c++;
        }

        assert find != null;
        Node<E> node = new Node<>(data, find, find.prev);

        find.prev.next = node;
        find.prev = node;

        size++;
    }

    public void removeIndex(int index) {
        if (isEmpty()) {
            System.out.println("Удалять нечего -> MyLinkedListDubl[ ] пуст.");
            return;
        }
        if (index <= 0) {
            if (index < 0) {
                System.out.println("Индекс не может быть отрицательным удалён элемент с индексом -> 0");
            }
            removeFirst();
            return;
        }
        if (index >= size - 1) {
            if (index > size - 1) {
                System.out.println("Максимальный индекс для вашего myLinkedListDubl -> " + (size - 1) +
                        ".\nУдалён элемент с индексом -> " + (size - 1));
            }
            removeLast();
            return;
        }

        Node<E> find = head;
        int c = 0;
        while (c != index) {
            find = find.next;
            c++;
        }

        find.next.prev = find.prev;
        find.prev.next = find.next;

        size--;
    }

    public void setIndex(int index, E _data) {
        Node<E> find = head;
        int c = 0;
        if (index >= c && index < size - 1) {
            while (c != index) {
                find = find.next;
                c++;
            }
        } else if (index >= size - 1) {
            find = tail;
        }
        find.data = _data;
    }

    public E getIndex(int index) {
        Node<E> find = head;
        int c = 0;
        if (index >= c && index < size) {
            while (c != index) {
                find = find.next;
                c++;
            }
        } else if (index >= size) {
            System.out.println("Максимальный индекс для вашего myLinkedListDubl -> " + (size - 1));
            find = tail;
        } else {
            System.out.println("Индекс не может быть отрицательным присвоен индекс -> 0");
        }

        assert find != null;
        return find.data;
    }

    public void indexOf(E key) {
        Node<E> find = head;
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        int index = 0;
        while (find != tail) {
            while (!find.data.equals(key)) {
                find = find.next;
                index++;
                if (find == tail) {
                    if (find.data.equals(key)) {
                        myLinkedList.addLast(index);
                    }
                    System.out.println("Количество совпадений значения - " + key + " -> " + myLinkedList.getSize() +
                            " по следующим индексам " + myLinkedList);
                    return;
                }
            }
            myLinkedList.addLast(index);
            find = find.next;
            index++;
            if (find == tail) {
                if (find.data.equals(key)) {
                    myLinkedList.addLast(index);
                }
                System.out.println("Количество совпадений значения - ( " + key + " ) -> " + myLinkedList.getSize() +
                        " по следующим индексам" + myLinkedList);
            }
        }
    }

    public void setKeyAll(E key, E key1) {
        Node<E> find = head;
        while (find != tail) {
            while (!find.data.equals(key)) {
                find = find.next;
                if (find == tail) {
                    if (find.data.equals(key)) {
                        find.data = key1;
                    }
                    return;
                }
            }
            find.data = key1;
            find = find.next;

            if (find == tail) {
                if (find.data.equals(key)) {
                    find.data = key1;
                }
            }
        }
    }

    public void removeKeyAll(E key) {
        Node<E> find = head;
        if (head == tail) {
            if (find.data.equals(key)) {
                removeLast();
            }
            return;
        }
        while (true) {
            while (!find.data.equals(key)) {
                find = find.next;
                if (find == tail) {
                    if (find.data.equals(key)) {
                        removeLast();
                    }
                    return;
                }
            }

            if (find == head) {
                removeFirst();
            } else {
                find.prev.next = find.next;
                find.next.prev = find.prev;
                size--;
            }

            find = find.next;

            if (find == tail) {
                if (find.data.equals(key)) {
                    removeLast();
                }
                return;
            }
        }
    }

    @Override
    public ListIterator<E> iterator() {
        return new ListIterator<>() {

            Node<E> node = head;
            int index = 0;

            @Override
            public boolean hasNext() {
                return node != tail;
            }

            @Override
            public E next() {
                node = node.next;
                index++;
                if (index == size) {
                    index = 0;
                }
                return node.data;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public E previous() {
                node = node.prev;
                index--;
                if (index < 0) {
                    index = size - 1;
                }
                return node.data;
            }

            @Override
            public int nextIndex() {
                index++;
                if (index == size) {
                    index = 0;
                }
                return index;
            }

            @Override
            public int previousIndex() {
                int ind = index - 1;
                if (ind < 0) {
                    ind = size - 1;
                }
                return ind;
            }

            @Override
            public void remove() {
                removeIndex(index);
                index--;
                if (index < 0) {
                    index = size - 1;
                }
            }

            @Override
            public void set(E data) {
                setIndex(index, data);
            }

            @Override
            public void add(E data) {
                addIndex(index, data);
                index++;
                if (index == size) {
                    index = 0;
                }
            }

            @Override
            public String toString() {
                return String.valueOf(node.data);
            }

            @Override
            public void forEachRemaining(Consumer<? super E> action) {
                ListIterator.super.forEachRemaining(action);
            }
        };
    }
}