package RecursionPrac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class phoneNumber {
    public static char[] map(char ch){
        HashMap<Character,char[]> map = new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});

        return map.get(ch);
    }
    public static void letterCombination(String up,String p) {
       if(up.isEmpty()){
           System.out.println(p);
           return;
       }
       char []arr = map(up.charAt(0));
        for (char c : arr) {
            letterCombination(up.substring(1), p + c);
        }
    }
    public static List<String> letterCombinations(String up,String p) {
        if(up.isEmpty()){
            List<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }
        char []arr = map(up.charAt(0));
        List<String> ans = new ArrayList<>();
        for (char c : arr) {
            List<String> ansFromBelowCalls = letterCombinations(up.substring(1), p + c);
            ans.addAll(ansFromBelowCalls);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("",""));

    }

}
