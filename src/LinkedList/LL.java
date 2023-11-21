package LinkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL(){
        this.size = 0;
    }

    public void reverseList(){
        helperRecur(head,null);

    }
    private void helperRecur(Node currHead,Node prevHead){
        if(currHead==null){
            return;
        }
        Node nextNode = currHead.next;
        currHead.next = prevHead;
        helperRecur(nextNode,currHead);
    }

    public void reverse(){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        reverseRec(head);
    }
    private void reverseRec(Node node){

        if(node.next==null){
            head = tail;
            return;
        }
        reverseRec(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;

    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next=head;
        head = node;
        if(tail==null){
            tail =head;
        }
        size++;
    }
    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next =node;
        tail = node ;

    }
    public void insert(int val,int index){
        if(index>size || index<0){
            System.out.print("Out of bounds!!");
            return;
        }
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }

        Node tempHead = head;
        for(int i = 1;i<index;i++){
            tempHead = tempHead.next;
        }
        Node node = new Node(val,tempHead.next);
        tempHead.next=node;
        size++;
    }
    public void addRec(int value, int index){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        if(head.next==null){
            head.next=new Node(value);
            return;
        }
        if(index == 0){
            Node node = new Node(value);
            node.next = head;
            head = node;
            return;
        }
        helper(value,index,head);

    }
    private void helper(int value,int index,Node head){
        if(index ==1){
            Node temp = head.next;
            head.next = new Node(value);
            head.next.next = temp;
            return;
        }
        helper(value,--index,head.next);
    }

    public void deleteFirst(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        tail = tail.next;
        size--;
    }
    public void deleteLast(){

        if(head==null){
            System.out.println("List is Empty");
            return;
        }

        if(head.next==null){
            deleteFirst();
            return;
        }
        Node node = head;
        while(node.next.next!= null){
            node = node.next;
        }
        tail = node;
        node.next = null;
        size--;
    }
    public void delete(int index){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        if(head.next==null){
            deleteFirst();
            return;
        }
        Node node = head;
        for(int i=1;i<index;i++){
            node = node.next;
        }
        node.next = node.next.next;
        size--;
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public int lengthCycle(){
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
               int length =1;
               Node temp = slow.next;
               while(temp!=slow){
                   length++;
                   temp=temp.next;
               }
               return length;
            }
        }
        return -1;
    }

    private class Node{
        private int val;
        private Node next;

        Node(int value, Node next){
            this.val= value;
            this.next = next;
        }
        Node(int value){
            this.val = value;
        }
    }


}
