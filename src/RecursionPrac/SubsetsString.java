package RecursionPrac;

import java.util.ArrayList;
import java.util.List;

public class SubsetsString {
//    public static List<String> findSubsets(List<String>ans,String p , String up){
//        if(up.isEmpty()){
//            ans.add(p);
//            return ans;//The result of this is ignored, the answer is correct as we pass the ans list in the func argument
//            //so every ans is poiting to the same List object...
//        }
//        //NOTE: String is immutable so, it works by directly trimming the string
//        findSubsets(ans,p+up.charAt(0),up.substring(1));
//        findSubsets(ans,p,up.substring(1));
//        return ans;
//    }
    public static List<String> subset(String p,String up){
        if(up.isEmpty()){
            List<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }
//        Since we did not pass our list in argument our list is local to that func call, so we need to merge the list before returning.
        char ch = up.charAt(0);
        List<String> left = subset(p+ch,up.substring(1));
        List<String> right = (subset(p,up.substring(1)));
        left.addAll(right);
        return left;
    }

    public static void main(String[] args) {
        String x = "abc";
        System.out.println(subset("",x));
    }
}
