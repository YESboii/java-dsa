package Search;

import java.util.Arrays;

//will work only for all cases
//concept of first and last Occ along with floor and ceil excluding the number itself.
public class MaxCount {
    static int binarySearch(int []arr,int target,int start,int end,boolean searchRight){
        int ans = -1;
        while(start<=end){
            int mid = start + (end-start)/2;

            if(target<arr[mid]){
                end = mid-1;
            }
            else if(target>arr[mid]){
                start = mid+1;
            }
            else{
               ans = mid;
               if(searchRight)
               end=mid-1;

               else{
                   start=mid+1;
               }
            }
        }
        if(ans!=-1){
            return ans;
        }
        if(searchRight){
            return start;}

        return end;

    }
    static int firstAndLast(int []arr){
        int []ans = {-1,-1};
        int l=arr.length;
        ans[0] = binarySearch(arr,1,0,arr.length-1,true);
        ans[1] = binarySearch(arr,-1,0,arr.length-1,false);
        return Math.max(l-ans[0],ans[1]+1);
    }
    public static void main(String[] args) {
        int []arr = {-1,-1,-1,-1,-1};
//        int []arr = {-3,-2,-2,-2,-1,1,2,3,4};
//        int []arr = {-3,-2,-1};
        //Since array is sorted binary search makes more sense
        //we will find first and last occurrence of 0 since duplicates are allowed.
        System.out.println(firstAndLast(arr));
//        System.out.println(Arrays.toString(firstAndLast(arr)));
    }
}
