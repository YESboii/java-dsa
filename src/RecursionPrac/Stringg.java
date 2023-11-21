package RecursionPrac;

public class Stringg {
    public static String removeOccurrences(char target,String str,int i){
        if(i==str.length()){
            return "";
        }
        String ans = "";
        if(str.charAt(i)!='a'){
            ans = str.charAt(i)+removeOccurrences(target,str,++i);
            return ans;
        }
        ans = ""+removeOccurrences(target,str,++i);
        return ans;
    }
    public static int length(String s){
        if(s.isEmpty()) return 0;

        return 1+ length(s.substring(1));
    }
    public static void main(String[] args) {
        String x = "applebanana";
//        System.out.println(removeOccurrences('a',x,0));
        System.out.println(length(""));
    }
}
