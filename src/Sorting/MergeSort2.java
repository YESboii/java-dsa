package Sorting;

import java.util.Arrays;

public class MergeSort2 {
    public static void main(String[] args) {
int []arr = {5,4,3,1,2};
mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int []arr,int start,int end){
        if(start<end){
            int mid = start +(end -start)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);

            merge(arr,start,mid,mid+1,end);
        }
    }
    static void merge(int []arr,int start1,int end1, int start2,int end2){
        int []res = new int[end2-start1+1];
        int i=start1;
        int j = start2;
        int k=0;
        while(i<=end1 && j<=end2){
            if(arr[i]<=arr[j]){
                res[k] = arr[i];
                i++;
            }
            else{
                    res[k] = arr[j];
                    j++;
            }
            k++;
        }
        while(i<=end1){
            res[k] = arr[i];
            i++;
            k++;
        }
        while(j<=end2){
            res[k] = arr[j];
            j++;
            k++;
        }
        for(int x = 0;x<res.length;x++){
            arr[start1+x] = res[x];
        }
        }
    }

