package PriorityQueue;

import java.util.Arrays;

//Using Heap.
public class PQ {
    private int []data;
    private int size;
    private static final int DEFAULT_SIZE = 8;
    PQ(int []data){
        this.data = data;
        this.size = data.length;
        buildHeap();
    }
    PQ(){
        this.size = 0;
        this.data = new int[DEFAULT_SIZE];
    }
    public void print(){
        for(int i=0;i<size;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
    private void heapify(int []data,int size,int i){
        int largest = i;

        int left = 2*i+1,right = 2*i+2;

        if(left<size && data[left]>data[largest]) largest=left;

        if(right<size && data[right]>data[largest]) largest = right;

        if(largest!=i){
            swap(data,largest,i);
            heapify(data,size,largest);
        }

    }
    public void offer(int e){
        if(size==data.length) data = Arrays.copyOf(data,size*2);
        data[size] = e;
        int idx = size;
        size++;
        while(idx>0){
            int  parentIdx = (idx-1)/2;
            if(data[idx]>data[parentIdx]) {
                swap(data,parentIdx,idx);
                idx = parentIdx;
            }
            else break;
        }
    }
    public int dequeue(){
        swap(data,0,size-1);
        size--;
        int value = data[size];
        heapify(data,size,0);
        return value;
    }
    private void buildHeap(){
        int lastIndexOfInternalNode = size/2 -1;
        for(int i=lastIndexOfInternalNode;i>=0;i--){
            heapify(data,size,i);
        }
    }
    private void swap(int []a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
class Demo1{
    public static void main(String[] args) {
        PQ pq = new PQ(new int[]{6,3,4,5,9});
        pq.print();
        pq.offer(10);
        pq.print();

        System.out.println(pq.dequeue());

        pq.print();
    }
}
