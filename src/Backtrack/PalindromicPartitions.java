package Backtrack;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PalindromicPartitions {
    public static void main(String[] args) {
        String input = "geeks";
        Deque<String> path = new LinkedList<>();
        System.out.println(printPartitions(input,new ArrayList<>(),0));
    }
//    public static void printPartitions(String p, List<String> list,int start){
//        if(start==p.length()){
//            System.out.println(list);
//            return;
//        }
//        for(int end = start+1;end<=p.length();end++){
//            if(isPalindrome(p.substring(start,end))){
//                list.add(p.substring(start,end));
//                printPartitions(p,list,end);
//                list.remove(list.size()-1);
//            }
//        }
//
//    }

    public static List<List<String>> printPartitions(String p, List<String> list,int start){
        if(start==p.length()){
            //always copy that list that will be modified not the ans list unless the ans list needs to be modified....
            List<String> temp = new ArrayList<>(list);
            List<List<String>> temp2 = new ArrayList<>();
            temp2.add(temp);
            return temp2;
        }
        List<List<String>> ans = new ArrayList<>();
        for(int end = start+1;end<=p.length();end++){
            if(isPalindrome(p.substring(start,end))){
                list.add(p.substring(start,end));
                System.out.println("*** "+list+start);
                List<List<String>> temp = new ArrayList<>(printPartitions(p,list,end));
                ans.addAll(temp);
                System.out.println("@@@ "+list+start);
                list.remove(list.size()-1);
                System.out.println("### "+list+start);
            }
        }
        return ans;
    }
//    static void partition(String input, Deque<String> path, int start) {
//        if (start == input.length()) {
//            System.out.println(path);
//            return;
//        }
//
//        for (int end = start + 1; end <= input.length(); end++) {
//            if (isPalindrome(input)) {
//                path.addLast(input.substring(start, end));
//                partition(input, path, end);
//                path.removeLast();
//            }
//        }
//    }

    static boolean isPalindrome(String str) {
        int low = 0,high =str.length()-1;
        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
//    public static void printPartitions(String s,int start,List<String> list){
//        if(start==s.length()){
//            System.out.println(list);
//            return;
//        }
//        for(int end = start+1;end<=s.length();end++){
//            if(isPalindrome(s.substring(start,end))){
//                list.add(s.substring(start,end));
//                printPartitions(s,end,list);
//                //we need to delete the previously added palindromic partition in the loop itself since now we need to increase the size of partition
//                //so, we backtrack and remove any changes that we had made in the list in the previous bottom calls in the tree..
//                list.remove(list.size()-1);
//            }
//        }
//    }
}
