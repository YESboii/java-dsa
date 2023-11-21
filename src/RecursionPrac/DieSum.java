package RecursionPrac;

import java.util.ArrayList;

public class DieSum {
    public static void main(String[] args) {
        System.out.println(generatePairSum(5,0,new int[]{1,2,3,4,5,6},new ArrayList<>()));
    }
    static ArrayList<ArrayList<Integer>> generatePairSum(int target,int i,int []dieFaces,ArrayList<Integer> list){
        if(target == 0){
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(list));
            return ans;
        }

        if(i==dieFaces.length) return new ArrayList<>();

        var ans = new ArrayList<ArrayList<Integer>>();
        for(int j = i; j<= 5; j++){
            if(dieFaces[j]<=target){
                list.add(dieFaces[j]);
                ArrayList<ArrayList<Integer>> ansFromBelowCalls = generatePairSum(target-dieFaces[j],i,dieFaces,list);
                ans.addAll(ansFromBelowCalls);
                list.remove(list.size()-1);
            }
            else{
                break;
            }
        }
        return ans;
    }
}
