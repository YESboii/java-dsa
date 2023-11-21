package MiscQuestions;

import java.util.Stack;

public class ValidParanthesis {
    static public boolean longestValidParentheses(String s) {
        int count=0;
        Stack<Character> stack = new Stack<>();
        if(s.length()==0 || s.length()==1){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(')');
            }
            else if(s.charAt(i)=='{'){
                stack.push('}');
            }
            else if(s.charAt(i)=='['){
                stack.push(']');
            }
            else if(stack.isEmpty() || stack.pop() != s.charAt(i) ){
                return false;
            }
        }

     return stack.isEmpty();
    }
    public static void main(String[] args) {
        String p="";

        System.out.println(longestValidParentheses(p));
    }
}
