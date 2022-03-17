package homework_3.queue;

public class QueueImpl <E> implements Queue<E> {

    protected final int DEFAULT_TAIL = -1;
    protected final int DEFAULT_HEAD = 0;

    protected final E[] data;
    protected int size;
    protected int tail;
    protected int head;

    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        tail = DEFAULT_TAIL;
        head = DEFAULT_HEAD;
    }

    public int getTail() {
        return tail;
    }

    public int getHead() {
        return head;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        //организовать закольцовывание
        if (tail == data.length - 1){
            tail = 0;
            data[tail] = value;
        } else {
            data[++tail] = value;
        }
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        //закольцовывание
        E value;
        if (head == data.length - 1){
            value = data[head];
            head = 0;
        } else {
            value = data[head++];
            data[--head] = null;
            head++;
        }
        size--;
        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (head > tail) {
            for (int i = head; i < data.length; i++) {
                sb.append(data[i]);
                sb.append(", ");

            }
            for (int i = 0; i <= tail; i++) {
                sb.append(data[i]);
                if (i != tail) {
                    sb.append(", ");
                }
            }
        } else {
            for (int i = head; i <= tail; i++) {
                sb.append(data[i]);
                if (i != tail) {
                    sb.append(", ");
                }
            }
        }
        return sb.append("]").toString();
    }
}
