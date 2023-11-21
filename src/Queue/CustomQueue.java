package Queue;



public class CustomQueue {
    private static final int default_size = 10;
    protected int []queue;
    private int end = -1;
    public CustomQueue(){
        this(default_size);
    }
    public CustomQueue(int size){
        this.queue = new int[size];
    }
    public boolean enqueue(int item){
        if(end == queue.length-1){
            System.out.println("Queue is full");
            return false;
        }
        queue[++end] = item;
        return true;

    }
    public boolean full(){
        return end==queue.length-1;
    }
    public int front(){
        if(end==-1){
            System.out.println("Stack is empty");
        }
        return queue[0];
    }
    public int dequeue(){
        if(end==-1){
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        if(end==0){
            return queue[end--];
        }
        int removed = queue[0];
        for(int i=1;i<=end;i++){
            queue[i-1] = queue[i];
        }
        end--;
        return removed;
    }
    public void display(){
        for(int i=0;i<=end;i++){
            System.out.print(queue[i]+"|");
        }
    }

}
