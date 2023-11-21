package Backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        combinationsum(new int[]{2,3,5},new ArrayList<>(),8,0);
    }
    static void combinationsum(int[] inputs, List<Integer> list,int target,int idx){
        if(idx==inputs.length){
            if(target==0){
                System.out.println(list);
            }
            return;
        }
        if(inputs[idx]<=target){
            list.add(inputs[idx]);
            combinationsum(inputs,list,target-inputs[idx],idx);
            list.remove(list.size()-1);
        }
        //There is a possibility that a single number will lead to target when we pick it as well as we don't pick it,
        //therefore, in case we pick it, we will need to 'not pick' as well,since if we put it inside  'else' we will not get the answer.
        combinationsum(inputs,list,target,idx+1);

    }


}

