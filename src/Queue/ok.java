package Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ok {
}
//package Stack.k;
class Queue {
    private int capacity;

    private int size;

    private int front;
    private int rear;
    private int[]data;
    private static final int DEFAULT_CAPACITY = 8;

    public Queue(int capacity){
        this.capacity = capacity;
        this.data = new int[capacity];
        front = -1;
        rear =-1;
        size = 0;
    }
    public Queue(){
        this(DEFAULT_CAPACITY);
    }
    public boolean isEmpty(){
        return (front==-1 || front>rear);
    }
    public boolean isFull(){
        return rear == capacity-1;
    }
    public boolean enqueue(int value){
        if(isFull()) return false;

        data[++rear] = value;
        size++;
        if(front==-1) front = 0;
        return true;
    }
    public boolean dequeue(){
        if(isEmpty()) return false;

        size--;
        System.out.println(data[front++]);
        if(isEmpty()){
            front = -1;
            rear = -1;
        }
        return true;
    }
    public int getFront(){
        if (isEmpty()){
            throw new RuntimeException("Empty");
        }
        return data[front];
    }
    public int getRear(){
        if (isEmpty()){
            throw new RuntimeException("Empty");
        }
        return data[rear];
    }
    public void print(){
        if(isEmpty()){
            System.out.println("Empty");
            return;
        }
        for(int i= front;i<=rear;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
}
class CircularQueue {
    private int capacity;

    private int size;

    private int front;
    private int rear;
    private int[]data;
    private static final int DEFAULT_CAPACITY = 8;

    public CircularQueue(int capacity){
        this.capacity = capacity;
        this.data = new int[capacity];
        front = -1;
        rear =-1;
        size = 0;
    }
    public CircularQueue(){
        this(DEFAULT_CAPACITY);
    }
    public boolean isEmpty(){
        return (front==-1);
    }
    public boolean isFull(){
        return (front==rear+1 || (front == 0 && rear == capacity-1));
    }
    public boolean enqueue(int value){
        if(isFull()) return false;
        size++;
        rear = (rear+1)%capacity;
        data[rear] = value;
        if(front==-1) {
            front=0;
        }
        return true;
    }
    public boolean dequeue(){
        if(isEmpty()) return false;

        size--;
        System.out.println(data[front]);
        if(front==rear){
            front = -1;
            rear = -1;
        }
        else{
        front = (front+1)%capacity;
        }
        return true;
    }
    public int getFront(){
        if (isEmpty()){
            throw new RuntimeException("Empty");
        }
        return data[front];
    }
    public int getRear(){
        if (isEmpty()){
            throw new RuntimeException("Empty");
        }
        return data[rear];
    }
    public void print(){
        System.out.println(Arrays.toString(data));
    }
}
class ok1{
    public static void main(String[] args) {
        Queue queue = new Queue(3);
        System.out.println(queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(2);
//       queue.dequeue();
//       queue.enqueue(3);
       queue.print();

//        queue.enqueue(5)
    }
}

