
import LinkedList.*;

import java.util.Scanner;
class MyLinkedList {
    private class Node{
        private int val;
        private Node next;
        public Node(){
            super();
        }
        public Node(int val){
            this.val = val;
            this.next = null;
        }
        public Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
    }
    private Node head;
    private int size;
    public MyLinkedList() {
        head =  null;
        size = 0;
    }

    public int get(int index) {
        if(index>=size || index<0){
            return -1;
        }
        Node itr = head;
        for(int i=0;i<index;i++){
            itr = itr.next;
        }
        return itr.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if(head==null){
            head = node;
            size++;
            return;

        }
        node.next = head;
        head = node;
        size++;
        return;

    }

    public void addAtTail(int val) {

        if(head==null){
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        Node itr = head;
        while(itr.next!=null){
            itr = itr.next;
        }
        size++;
        itr.next = node;

        return;
    }

    public void addAtIndex(int index, int val) {
        if(index==0){
            addAtHead(val);
            return;
        }
        if(index==size){
            addAtTail(val);
            return;
        }
        if(index<0 || index>size){
            return;
        }
        Node itr =head;
        for(int i=0;i<index-1;i++){
            itr = itr.next;
        }
        Node node = new Node(val,itr.next);
        itr.next = node;
        size++;
        return;
    }
    public void sizee(){
        System.out.println(size);
    }

    public void deleteAtIndex(int index) {
        if(index>=0 && index<size){
            size--;
            Node itr =head;
            for(int i=0;i<index-1;i++){
                itr = itr.next;
            }
            if(itr.next!=null){

                itr.next = itr.next.next;
            }
            else{
                itr.next = null;
            }

        }

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
public class CustomLLI {

    public static void main(String[] args) {
//         MyLinkedList obj = new MyLinkedList();

//  obj.addAtHead(1);
//  obj.sizee();
//  obj.addAtTail(3);
//         obj.sizee();
//  obj.addAtIndex(1,2);
//         System.out.println( obj.get(1));
//         obj.sizee();
//  obj.deleteAtIndex(0);
//         System.out.println(obj.get(0));
//         obj.sizee();
        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        ll.printList();
        ll.ReverseLinkedList();
        ll.printList();
    }
}
