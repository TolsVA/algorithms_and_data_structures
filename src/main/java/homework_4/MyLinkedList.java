package homework_4;

public class MyLinkedList<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    private boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(E data) {
        Node<E> first = head;
        Node<E> node = new Node<>(data);
        if (isEmpty()) {
            head = node;
            tail = node;
            head.next = node;
            head.prev = node;
        } else {
            head = node;
            head.prev = tail;
            head.next = first;
            first.prev = head;
            tail.next = head;
        }
        size++;

    }

    public void removeFirst() {
        if (head == tail) {
            remove();
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }

    public E getFirst() {
        Node<E> node = head;
        return node.data;
    }

    public void addLast(E data) {
        Node<E> end = tail;
        Node<E> node = new Node<>(data);
        if (isEmpty()) {
            addFirst(data);
        } else {
            tail = node;
            tail.prev = end;
            end.next = tail;
            tail.next = head;
            head.prev = tail;
            size++;
        }
    }

    public void removeLast() {
        if (head == tail) {
            remove();
        } else {
            tail = tail.prev;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }

    private void remove() {
        head.data = null;
        head = null;
        tail = null;
    }


    @Override
    public String toString() {
        Node<E> node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (!isEmpty()) {
            while (node != tail) {
                sb.append(node.data).append(", ");
                node = node.next;
            }
            sb.append(node.data);
        }
        sb.append("]\n");

        return sb.toString();
    }

}
