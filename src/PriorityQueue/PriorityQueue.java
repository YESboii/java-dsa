package PriorityQueue;

//using LinkedList
public class PriorityQueue{
    private class Node{
        int data;
        int priority;
        Node next;
        Node(int data,int priority,Node next){
            this.next = next;
            this.data = data;
            this.priority = priority;

        }
        Node(int data,int priority){
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }
    private int size;
    private Node head;
    PriorityQueue(){
        this.size = 0;
        this.head = null;
    }
    public void add(int element,int priority){
        size++;
        if(size==0 || head==null){
            head = new Node(element,priority);
            return;
        }
        //6 4 3 2
            Node node = new Node(element,priority);
        if(head.priority<priority){
            node.next = head;
            head = node;
            return;
        }
        Node temp = head;
        while(temp.next!=null && temp.next.priority>=priority){
            temp = temp.next;
        }
        node.next= temp.next;
        temp.next = node;
    }
    public int pop(){
        int val = head.data;
        head = head.next;
        return val;
    }

    public int getSize() {
        return size;
    }
    public int peek(){
        return head.data;
    }
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.format("{data: %d,priority: %d}->",temp.data,temp.priority);
            temp= temp.next;
        }
        System.out.println();
    }
}
class Demo{
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(1,7);//O(n)
        priorityQueue.add(2,8);
        priorityQueue.add(10,6);
        priorityQueue.add(9,6);
        priorityQueue.add(3,6);
        priorityQueue.add(4,6);
        priorityQueue.print();
        priorityQueue.pop();//O(1)
        priorityQueue.add(20,7);
        priorityQueue.print();
    }
}
