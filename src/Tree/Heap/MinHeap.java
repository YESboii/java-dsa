package Tree.Heap;

import java.util.Arrays;

public class MinHeap {
    private int []arr;
    private int size;
    private static final int DEFAULT_SIZE = 8;
    MinHeap(){
        this.arr = new int[DEFAULT_SIZE];
        this.size = 0;
    }
    MinHeap(int []arr){
        this.arr = arr;
        this.size = arr.length;
    }
    public void heapify(int []arr,int n,int i){
        int min = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && arr[left]<arr[min]){
            min = left;
        }
        if(right<n && arr[right]<arr[min]){
            min = right;
        }
        if(min!=i){
            swap(arr,i,min);
            heapify(arr,n,min);
        }
    }
    public void buildHeap(){
        int idxOfLastInternalNode = (size/2) -1;
        for (int i = idxOfLastInternalNode;i>=0;i--){
                heapify(arr,size,i);
        }
    }
    public void print(){
        for (int i:
             arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public void add(int element){
        if(size == arr.length) arr = Arrays.copyOf(arr,size*2);
        //insert element at last and then check for Min heap property violation
        arr[size] = element;
        int current = size;
        size++;
        while(current>0){
            int parentNodeIdx = (current-1)/2;
            if(arr[current]<arr[parentNodeIdx]){
                swap(arr,current,parentNodeIdx);
                current = parentNodeIdx;
            }
            else break;
        }
    }
    public void heapSort(){
        for(int i=size-1;i>=1;i--){
            swap(arr,0,i);
            heapify(arr,i,0);
        }
    }
    public void swap(int []a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
class Demo{
    public static void main(String[] args) {
        int []arr = {70, 42, 35, 8, 12, 15, 23, 6, 90};
        MinHeap heap = new MinHeap(arr);
        heap.buildHeap();
//        heap.add(0);
//        heap.heapSort();
        heap.print();
    }
}
