package Sorting;

//sorts by swapping adjacent values until array is sorted
//worst and avg case O(n^2)

import java.util.Arrays;

public class BubbleSort {
    static void swap(int []arr,int a,int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;

    }
    static void bubbleSort(int []arr){
        int n = arr.length;
        //n-1 times..
       for(int i = 0;i<n-1;i++){
         int flag=0;// flag is used to make the best case O(n)since when we have a sorted array we will break out of the loop
         //0 till n-2
           for(int j=0;j<n-i-1;j++){
               if(arr[j]>arr[j+1]){
                  flag=1;
                   swap(arr,j,j+1);
               }
           }
           if(flag==0){
               break;
           }
       }
    }
    static void bubbleSortRecursion(int []arr,int i,int j){
        if(i==arr.length-1) return;
        if(j<arr.length-1){
            if(arr[j]>arr[j+1]) swap(arr,j,j+1);
            bubbleSortRecursion(arr,i,j+1);
        }
        else {
            bubbleSortRecursion(arr,i+1,0);
        }
    }
    public static void main(String[] args) {
        int []arr={4,2,12,-99,87,7,66,21,3,3,1};
        bubbleSortRecursion(arr,0,0);
        System.out.println(Arrays.toString(arr));
    }
}
