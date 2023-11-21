package LinkedList;

//Advantage of LinkedList is insert operation takes O(1)
//Disadvantage search takes O(n)
//variable size
//non-contiguous memory
//<Type>- generics. It is used to enhance reusebility so that we do not need to write code for every datatype.
public class CustomLinkedList<Type> {
     class Node{
        Type data;
        Node next;

        Node(Type data){
            this.data=data;
            this.next=null;
            size++;
        }
    }
    private Node head;
    private int size;
    public void addFirst(Type data){
        Node newNode =new Node(data);
        if(this.head==null) {
            head = newNode;
            return;
        }
        newNode.next=head;
        head=newNode;

    }

    public void addLast(Type data){
        Node newNode = new Node(data);
        if(this.head==null){
            head=newNode;
            return;
        }
        //We use current node so that pointer for head is not lost if we directly use head to iterate till last element we
        //will lose pointer for head, so we use a temporary variable for it.
        Node currentNode = head;
        while(currentNode.next!=null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }
    public void printList(){
        if(head==null){
            System.out.println("This list is empty!");
            return;
        }
        Node nodeCurrent = head;
        while(nodeCurrent!=null){
            System.out.print(nodeCurrent.data+"->");
            nodeCurrent = nodeCurrent.next;
        }
        System.out.println("null");
    }
    public void deleteFirst(){
        if(head==null){
            System.out.println("This list is empty");
            return;
        }
        size--;
        head=head.next;
    }
    public void deleteLast(){

        //In case of 0 elements
        if(head==null){
            System.out.println("This list is empty");
            return;
        }
        size--;
        //In case of only 1 element. Since null.next will throw an error.so it is treated as edge case
        if (head.next==null) {
            head=null;
            return;
        }


        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next!=null){
            secondLast=lastNode;
            lastNode = lastNode.next;
        }
       secondLast.next=null;
    }
    public int size(){
        return size;
    }

    //Time complexity-->O(n)
    //Space Complexity-->O(1) since for any given linked list our space is constant.
    //if we use another LinkedList to store the reverse then space Complexity is O(n).
    public void ReverseLinkedList(){
        if(head==null)
            return;
        if(head.next==null){
            return;
        }

        Node prevNode = null;
        Node currentNode = head;
        Node nextNode;
        if(head==null)
            return;
        if(head.next==null){
            return;
        }


        while(currentNode!=null){

            nextNode = currentNode.next;
            currentNode.next=prevNode;

            prevNode=currentNode;
            currentNode=nextNode;
        }

        head=prevNode;
    }


}
