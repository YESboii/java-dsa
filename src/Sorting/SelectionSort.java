package Sorting;


import java.util.Arrays;

//worst case: O(n^2)
//Minimum element is identified after each pass, and then it is swapped at it's index
//not a stable sorting element.
class SelectionSort {
    static void selectionSort(int []arr,int n){
        for(int i=0;i<n-1;i++){
            int minIdx=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIdx]){
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i]=arr[minIdx];
            arr[minIdx]=temp;
        }
    }
    static void selectionSortRecur(int []arr,int i,int j,int minIdx){
            if(i==arr.length-1) return;

            if(j< arr.length){
                if(arr[j]<arr[minIdx]) minIdx = j;
                selectionSortRecur(arr,i,j+1,minIdx);
            }
            else{
                swap(arr,i,minIdx);
                selectionSortRecur(arr,i+1,i+2,i+1);
            }
    }
    static void swap(int []arr,int a,int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;

    }

    public static void main(String[] args) {
        int []arr={5,2,1,4,3};;
        selectionSortRecur(arr,0,1,0);
        System.out.println(Arrays.toString(arr));
    }
}

