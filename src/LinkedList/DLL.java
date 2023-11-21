package LinkedList;

public class DLL {
    private Node head;
    public void insertFirst(int val){
        Node node = new Node(val);
        if(head==null){
            head = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }
    public void insertLast(int val){
        Node node = new Node(val);
        Node i = head;
        if(head==null){
            head = node;
            return;
        }
        while(i.next!=null){
            i = i.next;
        }
        i.next = node;
        node.prev = i;
    }
    public Node getNode(int val){
        Node itr = head;
        while(itr!=null){
            if(itr.val==val){
                return itr;
            }
            itr = itr.next;
        }
        return null;
    }
    public void insert(int valueTBS,int val){
        Node temp =getNode(valueTBS);
        Node node = new Node(val);
        if(head==null){
            head = node;
        }
        if(temp!=null){
            node.next = temp.next;
            temp.next = node;
            node.prev = temp;
            if(node.next!=null){
                node.next.prev=node;
            }
        }


    }
   public void display(){

        if(head == null){
            System.out.println("Empty list!!");
        }
        Node node = head;
        while(node!=null){
            System.out.print(node.val+"<->");
            node = node.next;
        }
       System.out.println("null");
    }
    public void displayReverse(){

        if(head == null){
            System.out.println("Empty list!!");
        }
        Node lastNode = head;
        while(lastNode.next!=null){
            lastNode = lastNode.next;
        }
        while(lastNode!=null){
            System.out.print(lastNode.val+"<->");
            lastNode = lastNode.prev;
        }
        System.out.println("null");
    }
    private class Node{
        private int val;
        private Node next;
        private Node prev;
        Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
        Node(int val){
            this.val = val;
        }

    }
}
