package RecursionPrac;

public class FirstUpperCase {
    public static void main(String[] args) {
        System.out.println(firstUC("AyushHG"));
    }
    static char firstUC(String s){
        if(s.isEmpty()) return ' ';
        if(s.charAt(0)>='A' && s.charAt(0)<='Z') return s.charAt(0);
        return firstUC(s.substring(1));
    }
}
