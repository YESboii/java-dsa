package RecursionPrac;

public class ReverseString_Number {
    public static void main(String[] args) {
//        System.out.println(reverse("meowww"));
        System.out.println(reverse(123456,6));
    }
    public static String reverse(String s){
        if(s.length()==0) return "";

        return reverse(s.substring(1)) + s.charAt(0);
    }
    public static int reverse(int n,int i){
        if(n==0) return 0;

        return ((n%10)*(int)Math.pow(10,i-1))+reverse(n/10,i-1);
    }
}
