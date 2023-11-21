package Search;


import java.util.Scanner;

//To find elements in a sorted array..
//Time complexity-O(logn)
//Space complexity-O(1)
public class    BinarySearch {
    static int binarySearch(int []arr,int low,int high,int target){
        if(low>high){
            return -1;
        }
        int middle = low+(high-low)/2;
        if(arr[middle]==target){
            return middle;
        }
        if(target<arr[middle]){
            return binarySearch(arr,low,middle-1,target);
        }
        return binarySearch(arr,middle+1,high,target);
    }

    static int orderAgnosticBS(int []arr,int target,boolean asc){
        int start = 0;
        int end = arr.length-1;
        if(asc){
            while(start<=end){
                int mid = start + (end - start)/2;
                if(arr[mid]>target){
                    end = mid - 1;
                }
                else if (arr[mid]<target) {
                    start = mid + 1;
                }
                else{
                    return mid;
                }
            }
            return -1;
        }
        else{

            while(start<=end){
                int mid = start + (end - start)/2;
                if(arr[mid]>target){
                   start = mid + 1;
                }
                else if (arr[mid]<target) {
                    end = mid -1;
                }
                else{
                    return mid;
                }
            }
            return -1;

        }
    }
    public static void main(String[] args) {
       int []arr = {100,85,12,0,-1,-3,-100};
        System.out.println(orderAgnosticBS(arr,0,false));
    }
}
