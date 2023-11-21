package Sorting;

import java.util.Arrays;
//Time complexity:O(nlogn) worst case: O(n^2) when we choose pivot as the smallest and largest element
//not stable
//Auxiliary space : constant
public class QuickSort{
    public static int partition(int []arr,int start,int end){
        int pIndex = start;
        int pivot = arr[end];
        for(int i= start;i<end;i++){
            if(arr[i]<=pivot){
                int temp=arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        int temp = arr[pIndex];
        arr[pIndex] = pivot;
        arr[end] = temp;
        return pIndex;
    }
   public static void quickSort(int []arr,int start,int end){
      if(start<end){
          int pIndex = partition(arr,start,end);
          quickSort(arr,start,pIndex-1);
          quickSort(arr,pIndex+1,end);
      }
   }
    public static void main(String[] args) {
        int []arr = {5,2,1,4,3};
        int low = 0;
        int high = arr.length-1;
        quickSort(arr,low,high);
        System.out.println(Arrays.toString(arr));
    }
}