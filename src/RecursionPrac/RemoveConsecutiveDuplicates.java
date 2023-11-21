package RecursionPrac;

public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeConsecutiveDuplicates("","aabccba"));
    }
    static String removeConsecutiveDuplicates(String p,String up){
        if(up.isEmpty()) return p;

        if(p.isEmpty() || p.charAt(p.length()-1)!=up.charAt(0)) return removeConsecutiveDuplicates(p+up.charAt(0),up.substring(1));


        return removeConsecutiveDuplicates(p,up.substring(1));

    }
}
