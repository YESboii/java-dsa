package Search;


import java.util.Arrays;

class Solution {
    public int searchLeftRight(int []arr,int target,boolean LR){
        int start = 0;
        int end = arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(target<arr[mid]){
                end = mid-1;
            }
            else if(target>arr[mid]){
                start = mid+1;
            }
            //Since we need to find the first occurence in any givena array then it is not
            //necessary that it is our first occ therefore we search for the
            //left part again
            //same goes for last index but we search for the right part.
            else{
                ans=mid;
                if(LR){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }


        }
        return ans;

    }
    public int[] searchRange(int[] nums, int target) {
        int []answer={-1,-1};
        int firstOccurenceIndex = searchLeftRight(nums,target,true);
        int lastOccurenceIndex = searchLeftRight(nums,target,false);
        answer[0]=firstOccurenceIndex;
        answer[1]=lastOccurenceIndex;

        return answer;
    }
}
public class FirstandLastOcc {
    public static void main(String[] args) {
        int []arr = {5,7,7,8,10};
        int target=8;
        Solution solution = new Solution();
        solution.searchRange(arr,target);
        System.out.println(Arrays.toString(solution.searchRange(arr,target)));
    }
}
