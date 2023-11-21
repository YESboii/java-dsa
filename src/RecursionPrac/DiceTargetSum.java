package RecursionPrac;

import java.util.ArrayList;

public class DiceTargetSum {
//    Time Complexity: O(6^n)
    //recursive stack: O(n)
//    space complexity:??
    static ArrayList<ArrayList<Integer>> generateCombinations(ArrayList<Integer> pList,int target){
        if(target==0){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            temp.add(pList);
            return temp;
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=6;i++){
            ArrayList<Integer> tempPList = new ArrayList<>(pList);
            if(i<=target){
                tempPList.add(i);
                ArrayList<ArrayList<Integer>> ansFromBelowCalls = generateCombinations(tempPList,target-i);
                ans.addAll(ansFromBelowCalls);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(generateCombinations(new ArrayList<>(),5));
    }
}
