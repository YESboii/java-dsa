package Queue;

public class CircularQueue {
    private static final int default_size = 10;
    protected int []queue;
    private int end = 0;
    private int front = 0;
    public CircularQueue(){
        this(default_size);
    }
    public CircularQueue(int size){
        this.queue = new int[size];
    }
}
