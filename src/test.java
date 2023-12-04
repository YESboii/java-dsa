
import java.util.*;
import Stack.*;

class Test<T extends Integer>{

    void add(T n1,T n2){
        System.out.println(n1+" "+n2);
    }
}
public class test{
    public static List<List<Integer>> helper(int []nums,int i,List<List<Integer>> list,List<Integer>subset){
        if(i==nums.length){
            list.add(subset);
            return list;
        }
        List<Integer> temp = new ArrayList<>(subset);
        temp.add(nums[i]);
        helper(nums,i+1,list,temp);
        while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }
        helper(nums,i+1,list,subset);

        return list;
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return helper(nums,0,new ArrayList<>(),new ArrayList<>());
    }
    public static int getMaximumSweetness(ArrayList<Integer> arr, int k) {
        int left = Integer.MAX_VALUE;
        int right = 0;

        for (int sweetness : arr) {
            left = Math.min(left, sweetness);
            right += sweetness;
        }

        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canDivide(arr, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static boolean canDivide(ArrayList<Integer> arr, int k, int threshold) {
        int totalSweetness = 0;
        int cuts = 0;

        for (int sweetness : arr) {
            totalSweetness += sweetness;
            if (totalSweetness >= threshold) {
                cuts++;
                totalSweetness = 0;
            }
        }
//        System.out.println(cuts);
        return cuts >= k + 1;
    }

    public static void main(String[] args) {
//        Test t = new Test();
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10, 11, 12, 13 ));
//        System.out.println(getMaximumSweetness(list,3));
//        List<Integer> list = new ArrayList<>();
//        for(int i=1;i<=12;i++){
//            int sqrt = (int)Math.sqrt(i);
//            if(sqrt*sqrt==i){
//                list.add(i);
//            }
//        }
//        System.out.println(list);
//        Integer a = 12;
//        Integer b =10;
//        System.out.println(a>b);
//        Test<Integer> test = new Test<>();
        Stackk<Integer> stackk = new Stackk<Integer>(); // Correct: Instantiate a Stackk<Integer>



    }
}
