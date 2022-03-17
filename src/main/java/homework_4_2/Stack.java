package homework_4_2;

public class Stack {
    private int maxSize;
    private char[] stackArr;
    private int top;

    public Stack(int size){
        this.maxSize = size;
        this.stackArr = new char[size];
        this.top = -1;
    }


    public void push(char i){
        stackArr[++top] = i;
    }

    public char pop(){
        return stackArr[top--];
    }

    public boolean isEmpty(){
        return (top == -1);
    }
}
