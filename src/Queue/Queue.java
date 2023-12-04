package Queue;

public class Queue {
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
class Test{
    public static void main(String[] args) {
        Queue queue = new Queue(4);
        System.out.println(queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.isFull());
        queue.print();
        queue.dequeue();
        queue.enqueue(5);
//        queue.enqueue(5)
    }
}
