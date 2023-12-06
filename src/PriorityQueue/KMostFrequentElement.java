package PriorityQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.*;

public class KMostFrequentElement {
    public static void main(String[] args) {
        int []nums={5,2,5,3,5,3,1,1,3};
        Solution solution = new Solution();
        solution.topKFrequent(nums,2);
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        System.out.println(map);
        List<Integer> list = new ArrayList<>(map.keySet());
        System.out.println(list);
        int idx = list.size()-1;
        for(int i=idx;i>=0;i--){
            heapify(list,list.size(),i,map);
        }
        System.out.println(list);
        heapsort(list,k,list.size(),map);
        System.out.println(list);
        int []ans = new int[k];
        int j=0;
        for(int i=list.size()-1;i>=list.size()-k;i--){
            ans[j] = list.get(i);
            j++;
        }

        return ans;
    }
    public void heapify(List<Integer> list,int n,int i,Map<Integer,Integer> map){
        int frequent = i;
        int left = 2*i+1;
        int right = 2*i+2;

        while (true) {
            int currFreq = map.get(list.get(frequent));

            if(left<n && map.get(list.get(left))>currFreq){
                frequent = left;
            }

            if(right<n && map.get(list.get(right))>currFreq){
                frequent = right;
            }

            if(frequent!=i){
                int temp = list.get(i);
                list.set(i,list.get(frequent)) ;
                list.set(frequent,temp);
                i = frequent;
                left = 2*i+1;
                right = 2*i+2;
            } else {
                break;
            }
        }
    }
    public void heapsort(List<Integer> list,int k,int n,Map<Integer,Integer> map){
        for(int i = n-1;i>=n-k;i--){
            int temp = list.get(i);
            list.set(i,list.get(0)) ;
            list.set(0,temp);
            heapify(list,i,0,map);
        }
    }
}
