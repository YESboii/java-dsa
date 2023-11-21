package RecursionPrac;
import java.util.ArrayList;
import java.util.List;
public class SubsetsArrayList {
    public static List<List<Integer>> subset(int []up,int i,List<Integer> processed){
        if(i==up.length){
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(processed);
            return temp;
        }
        List<Integer> tempList = new ArrayList<>(processed);
        tempList.add(up[i]);
        List<List<Integer>> leftBranch = subset(up,i+1,processed);
        List<List<Integer>> rightBranch = subset(up,i+1,tempList);
        leftBranch.addAll(rightBranch);
        return leftBranch;
    }
    public static void subsets(int []up,List<Integer>subset,int index){
        if(index==up.length){
            System.out.println(subset);
            return;
        }
        //case of pick
        subset.add(up[index]);
        subsets(up,subset,index+1);

        //backtrack and delete changes made in the case of pick the number
        subset.remove(subset.size()-1);
        subsets(up,subset,index+1);
    }
    public static void main(String[] args) {
        subsets(new int[]{1,2,3},new ArrayList<>(),0);
    }
}
