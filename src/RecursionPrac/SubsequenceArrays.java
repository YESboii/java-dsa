package RecursionPrac;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceArrays {
    public static void subset(List<List<Integer>> ans,List<Integer> list,int []arr,int i){
        //Time complexity: O(n*2^n)
        //Space Complexity: O(n*2^n)
        if(arr.length==i){

            ans.add(list);
            return;
        }
        //this will initialise temp with the same content of list but will point to different object..
        //copying takes O(n) time
        //making subsets takes O(2^n) time
        //space complexity : O(n), if we exclude the output array..
        //else :O(n*2^n)
        //stack memory usage is:height of tree.
        List<Integer> temp = new ArrayList<>(list);
        temp.add(arr[i]);
        subset(ans,temp,arr,i+1);
     subset(ans,list,arr,i+1);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
       subset(result,new ArrayList<>(),nums,0);
       return result;

    }

    public static void main(String[] args) {
        int []arr = {1,2,3};
        System.out.println(subsets(arr));
    }
}
