package RecursionPrac;

public class Recur_Str {
    public static String skip(String p,String up,char a){
//        String p= "";
//        if(up.isEmpty()){
//            return p;
//        }
//        if(up.charAt(0)==a){
//            return skip(up.substring(1),a);
//        }
//        p = up.charAt(0) + skip(up.substring(1),a);
//        return p;
        if(up.isEmpty()){
            return p;
        }
        if(up.charAt(0)==a){
            return skip(p,up.substring(1),a);
        }
        p = p+up.charAt(0);
        return skip(p,up.substring(1),a);
    }
    public static void main(String[] args) {
        System.out.println(skip("","aabaccccccd",'a'));
    }
}
