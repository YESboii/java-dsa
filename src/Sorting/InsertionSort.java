package Sorting;

import java.util.Arrays;
// Worst case & avg: O(n^2)
//Best case: O(n) if already sorted
//better than average performance selection and bubble & stable as-well
public class InsertionSort {
    static void insertionSort(int []arr,int n){
        for(int i=1;i<n;i++){
            int value = arr[i];
            int hole = i;
            while(hole>0 && arr[hole-1]>value){
                arr[hole]=arr[hole-1];
                hole--;
            }
            arr[hole]=value;
        }
    }
    public static void main(String[]args){
        int []arr={5,2,1,4,3};;
        insertionSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
