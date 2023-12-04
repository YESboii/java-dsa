package Tree.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    An abstract data structure that stores data in the form of an array which has a representation of a
    complete binary tree that satisfies the property of MIN/MAX Heap.
 */
public class Heap {
    private int []list;
    private int size;
    private static final int DEFAULT_SIZE = 8;

    Heap(int []arr){
        this.list = arr;
        this.size = arr.length;
    }
    Heap(){
        this.list = new int[DEFAULT_SIZE];
        size = 0;
    }
    public void heapify(int []arr,int n,int i){
            int largest = i;
            int left = 2*i +1;
            int right = 2*i+2;

            if(left<n && list[left]>list[largest]){
                largest = left;
            }
            if(right<n && list[right]>list[largest]){
                largest = right;
            }
            if(largest != i){
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                heapify(arr,n,largest);
            }
    }
    public void buildHeap(){
        int n = size;
        int idx = (n/2) -1; //last non-leaf node.We dont need to heapify the leaf nodes
        for(int i=idx;i>=0;i--){
            heapify(list,n,i);
        }
    }
    public void print(){
        for (int i = 0;i<size&&list[i]!=0;i++
             ) {
            System.out.print(list[i]+" ");
        }
        System.out.println();
    }
    public void heapSort(){
        for(int i=list.length-1;i>0;i--){
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;
            heapify(list, i, 0);
        }
    }
    public void add(int element){
        if(size==list.length) list = Arrays.copyOf(list,2*size);
        list[size] = element;
        int current = size;
        size++;
        while(current!=0){
            int parent = (current-1)/2;
            if(list[current]>list[parent]){
                int temp = list[current];
                list[current] = list[parent];
                list[parent] = temp;
                current = parent;
            }
            else break;
        }
    }
}
class Test{
    public static void main(String[] args) {
//        https://www.geeksforgeeks.org/time-complexity-of-building-a-heap/
        //Time complexity looks O(n * log(n)) buts its O(n).
        int []arr = {5,3,1,4,6};   //after creating the heap, the array will be in the order of the level order traversal of the heap tree.
        Heap heap = new Heap();
        heap.add(6);
        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(5);

        heap.buildHeap();//{6, 5, 1, 4, 3 }
        heap.print();
//        heap.print();
//        /*
//               6
//              / \
//             5   1
//            / \
//           4   3
//         */
//        heap.add(7);
//        heap.print();
    }
}
