package Sorting;

import java.util.Arrays;


//Time Complexity : O(n logn)
//n for merging and log n times we merge the arrays.
//recursion Stack:log n
//Auxiliary space: O(n)
//It might appear to be nlogn but the func call  is emptied from stack as soon as the value is merged and returned..So the previous calls that are waiting
//their space will be allocated only when the merge(left,right) function returns the value.. So in the worst case it will O(n)
//It is used to sort LinkedList.
public class MergeSort {
    public static void main(String[] args) {
int []arr = {Integer.MAX_VALUE,3,2,11111,0,989,Integer.MIN_VALUE,89398728};
arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int []arr){
        if(arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int []left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int []right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }
    static int[] merge(int []left,int []right){
        int []res = new int[left.length+right.length];
        int i=0;
        int j=0;
        int k=0;
        while(i< left.length && j< right.length){
            if(left[i]<right[j]){
                res[k]=left[i];
                i++;
                k++;
            }
            else{
                res[k]=right[j];
                j++;
                k++;
            }
        }
        while(i< left.length){
            res[k] = left[i];
            i++;
            k++;
        }
        while(j< right.length){
            res[k] = right[j];
            j++;
            k++;
        }
        return res;
    }
}
