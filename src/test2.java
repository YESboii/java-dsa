import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class test2 {
    static public int findPivot(int []arr){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(mid<arr.length-1 && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>0 && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){
                if(start<arr.length-1 && arr[start]>arr[start+1]){
                    return start;
                }
                start++;
                if(end>0 && arr[end-1]>arr[end]){
                    return end-1;
                }
                end++;
            }
            else if(arr[start]<arr[mid] || arr[start]==arr[mid] && arr[mid]>arr[end]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }

        }
        return -1;
    }
    static public int findMin(int[] nums) {
        int pivotIdx = findPivot(nums);
        if(pivotIdx==-1){
            return nums[0];
        }
        return nums[pivotIdx+1];
    }
    public static int countNegatives(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int rows = grid.length-1;
        int cols = grid[0].length-1;
        int r = 0,c=cols;
        int count=0;
        while(r<=rows && c>=0){
            if(grid[r][c]<=-1){
                count = count + rows - r +1;
                c--;
            }
            else{
                r++;
            }
        }
        return count;

    }
    public static int singleNonDuplicate(int[] arr) {
        // for(int i=0;i<arr.length;){
        //     if(i<arr.length-1 && arr[i]!=arr[i+1])return arr[i];
        //     else if(i==arr.length-1) return arr[i];
        //     else{
        //         i=i+2;
        //     }
        // }
        // return arr[0];
        if(arr.length==1){
            return arr[0];
        }
        else{
            int start = 0,end = arr.length;
            while(start<=end){
                int mid = start + (end -start)/2;
                if(mid==0 || mid == arr.length-1){
                    return arr[mid];
                }
                if(arr[mid]!=arr[mid+1] && arr[mid]!=arr[mid-1]){
                    return arr[mid];
                }
                if(arr[mid]==arr[mid+1]){
                    if((mid+1)%2==0) end = mid-1;
                    else start = mid+1;
                }
                if(arr[mid]==arr[mid-1]){
                    if(mid%2==0) end = mid-1;
                    else start = mid+1;
                }
            }
            return -1;
        }
    }
    public static int[] findRightInterval(int[][] intervals) {
        if(intervals.length==1){
            return new int[]{-1};
        }
        int k = 0;
        int []ans = new int[intervals.length];
        Arrays.fill(ans, -1);
        for(int i=0;i<intervals.length;i++){
            int flag = 0;
            for(int j=0;j<intervals.length;j++){
                if(flag ==0 && i!=j){

                    if(intervals[i][1]==intervals[j][0]){
                        System.out.println(intervals[i][1]+" " +intervals[j][0]);
                        ans[k]=j;

                        flag = 1;
                    }
                }
            }
            k++;

        }
        return ans;
    }
    //Range is given so we can apply binary search.
    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
        for(int i:piles){
            if(i>end)
            {
                end = i;
            }
        }
        int k = 0;
        while(start<=end){
            int mid = start + (end - start)/2;
            long total = 0;
            for(int i:piles){
                total = total + (int)(Math.ceil(i/(double)mid));
            }
            if(total <= h){
                k=mid;
                end = mid-1;
            }
            else if(total>h){
                start = mid+1;
            }

        }
        return k;
    }
    public static int calculateDays(int[] weights, int maxWeightPerDay) {
        int totalWeight = 0;
        int days = 0;

        for (int weight : weights) {
            if (totalWeight + weight <= maxWeightPerDay) {
                totalWeight += weight;
            } else {
                days++;
                totalWeight = weight;
            }
        }

        if (totalWeight > 0) {
            days++;
        }

        return days;
    }
    public static int shipWithinDays(int[] weights, int days) {
        int start = 1, end = 0;
        for(int i:weights){
            end+=i;
            if(i>=start)start =i;
        }
        int capacity = 0;
        while(start<=end){
            int mid = start + (end - start)/2;
            int total=0;
            int i=0, day =calculateDays(weights,mid);
            if(day<=days){ // changed from day<=day to day<=days
                 // changed from capacity = day to capacity = mid
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length) return -1;
        int end = 0,start = (int)Math.pow(10, 9) + 1;

        for(int i:bloomDay){
            if(i>end) end = i;
            if(i<start) start = i;
        }

        if(m*k==bloomDay.length) return end;
        int days = 0;
        while(start<=end){
            int mid = start + (end - start)/2;
            boolean bouquetMade = checkBoquet(bloomDay,mid,m,k);
            if(bouquetMade){
                days = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return days;
    }

    public static boolean checkBoquet(int []bloomDay,int day,int m,int k){
        int bouquet = 0;
        int count = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(day>=bloomDay[i]){
                count++;
            }
            else{
                count=0;
            }
            if(count==k){
                bouquet++;
                count=0;
            }
            if(bouquet==m) return true;
        }
        return false;
    }
    public static int splitArray(int[] nums, int k) {
        int start = 0,end = 0;
        for(int i:nums){
            if(i>start) start = i;
            end+=i;
        }
        int ans = 0;
        while(start<=end){
            int mid = start + (end - start)/2;
            int partsPossible = checkSplit(nums,mid,k);
            if(partsPossible<=k){
                ans = mid;
                end = mid-1;
            }
            else if(partsPossible>k){
                start = mid+1;
            }
        }
        return ans;
    }
    public static int checkSplit(int []nums,int partSum,int k){
        int currSum = 0;
        int parts = 0;
        for(int i:nums){
            if(i+currSum<=partSum){
                currSum+=i;
            }
            else{
                parts++;
                currSum = i;
            }
        }
        if(parts>0) parts++;

        return parts;

    }
    public static int getMaximumSweetness(ArrayList<Integer> arr, int k) {
        k++;
        int start = Integer.MAX_VALUE,end=0;
        for(int i:arr){
            end+=i;
            start = Math.min(start, i);
        }
        int ans =0;
        while(start<=end){
            int mid = start + (end - start)/2;
            int parts = getParts(arr,mid);
            if(parts>=k){
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans; // return the answer

    }

    public static int getParts(ArrayList<Integer> arr,int sweetness){
        int parts = 0,sweetnessCurr=0;
        for(int i:arr){
            if(i+sweetnessCurr<=sweetness){
                sweetnessCurr+=i;
            }
            else{
                parts++;
                sweetnessCurr=i;
            }

        }
//        if(parts>0) parts++;
        System.out.println(parts);
        return parts;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permuteUnique(nums));


    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(ans,nums,0,list);
        return ans;
    }
    public static void helper(List<List<Integer>>ans,int[] up, int start, List<Integer>list){
        if(start == up.length){
            List<Integer> temp = new ArrayList<>(list);
            ans.add(temp);
            return;
        }
        for(int i=0;i<=list.size();i++){
            list.add(i,up[start]);
            helper(ans,up,start+1,list);
            list.remove(i);
        }
    }
}
