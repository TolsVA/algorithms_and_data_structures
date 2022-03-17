package homework_4_3;

public class LinkedQueue<E> implements Queue<E> {
    private final DoublyLinkedList<E> data;

    public LinkedQueue() {
        this.data = new DoublyLinkedList<>();
    }

    @Override
    public boolean insertFirst(E value) {
        data.addFirst(value);
        return true;
    }

    @Override
    public void contains(E value) {
        data.indexOf(value);
    }

    @Override
    public boolean insertLast(E value) {
        data.addLast(value);
        return true;
    }

    @Override
    public void removeFirst() {
        data.removeFirst();
    }

    @Override
    public E getFirst() {
        return data.getFirst();
    }

    @Override
    public void removeLast() {
        data.removeLast();
    }

    @Override
    public E getLast() {
        return data.getLast();
    }

    @Override
    public void remove(E value){
        data.removeKeyAll(value);
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
