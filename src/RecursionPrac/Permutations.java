package RecursionPrac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<String> generatePermutations(String p,String up){
        if(up.isEmpty()){
            List<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }
        char ch = up.charAt(0);
        List<String> ans = new ArrayList<>();
        for(int i=0;i<=p.length();i++){
            String first = p.substring(0,i);
            String last = p.substring(i);
            List<String> ansFromBelowCalls = generatePermutations(first+ch+last,up.substring(1));
            ans.addAll(ansFromBelowCalls);
        }
        return ans;
    }
    public static int countPermutations(String p,String up,int count){
        if(up.isEmpty()){
            count++;
            return count;

        }
        char ch = up.charAt(0);

        for(int i=0;i<=p.length();i++){
            String first = p.substring(0,i);
            String last = p.substring(i);
          count = countPermutations(first+ch+last,up.substring(1),count);
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(generatePermutations("","abc"));
            List<Character> list = new ArrayList<>();
            list.add('a');
        list.add('b');
        list.add('c');
            permutations(new ArrayList<>(),list,0);
    }
    public static void permutations(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
                String first = p.substring(0,i);
                String second = p.substring(i);
                permutations(first+ch+second,up.substring(1));
        }
    }
    public static void permutations(List<Character> p,List<Character> up,int idx){
        if(idx==up.size()){
            System.out.println(p);
            return;
        }
        char ch = up.get(idx);
        for(int i=0;i<=p.size();i++){
            List<Character> temp  = new ArrayList<>(p);
            temp.add(i,ch);
            permutations(temp,up,idx+1);
        }
    }
}
