package RecursionPrac;


import java.util.*;

public class ReverseStack {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("abra");
        al.add("ka");
        al.add("dabra");
        System.out.println(passwordCracker(al,"kaab"));
    }
    public static  String passwordCracker(ArrayList<String> passwords, String loginAttempt) {
        return helper(passwords,"",loginAttempt);

    }
    public static String helper(ArrayList<String> passwords, String p, String up){
        if(up.isEmpty()){
            return p;
        }

        for(String password:passwords){
            if(up.startsWith(password)){
                return helper(passwords,p+" "+password,up.substring(password.length()));
            }
        }
        return "WRONG PASSWORD";
    }

}


