package Stack;


import java.util.ArrayList;

//Generics -> ensures type safety
// ->Enables reusability of  code.So we dont need to write code for every data-type
public class Stackk<T>{


    private Object[] data;
    private static final int DEFAULT_SIZE = 5;

    private int top = -1;
    private int size;
    public Stackk(){
        data = new Object[DEFAULT_SIZE];
        size = 0;
    }
    public Stackk(int intialSize){
        data = new Object[intialSize];
        size = 0;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return data.length-1 == top;
    }
    public void push(T element) {
        if (!isFull()) {
            data[++top] = element;
            size++;
        } else {
            throw new RuntimeException("Stack is full");
        }
    }
    public void pop(){
        if(!isEmpty()){
            top--;
            return;
        }
        throw new RuntimeException("Already Empty");
    }
    public T peek(){
        if(!isEmpty())return (T)data[top];

        throw new RuntimeException("Empty");
    }
}
class test{
    public static void main(String[] args) {
        Stackk<Integer> stackk = new Stackk<Integer>();
//        stackk.push(1);
//        stackk.push(2);
        System.out.println(stackk.peek());


    }
}
