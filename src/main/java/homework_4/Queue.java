package homework_4;

public interface Queue<E> {

    boolean insertLast(E value);

    boolean insertFirst(E value);

    void contains(E value);

    void removeFirst();

    E getLast();

    E getFirst();

    void removeLast();

    void remove(E value);

    E peekFront();

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();

}
