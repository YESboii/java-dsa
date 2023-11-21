package RecursionPrac;

import java.util.ArrayList;

public class Subsequence {
    public static void main(String[] args) {
        String x = "abc";
        System.out.println(subseq("",x));
    }
    public static ArrayList<String> subseq(String ans, String s){
        if(s.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        char temp = s.charAt(0);
        ArrayList<String> left = subseq(ans+temp,s.substring(1));
        ArrayList<String> right = subseq(ans,s.substring(1));
        left.addAll(right);
        return left;
    }
}
