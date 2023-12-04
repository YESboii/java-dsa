package functionalProgramming.LambdaFunc;

public class LambdaFunc {
    public static void main(String[] args) {
        Calculator add = (a,b)->a+b;
        Calculator sub = (a,b)-> a-b;

        LambdaFunc lambdaFunc = new LambdaFunc();
        System.out.println(lambdaFunc.operate(5,6,add));
    }
        int operate(int a,int b,Calculator c){
        return c.opeartion(a,b);
        }
    interface Calculator{
        int opeartion(int a,int b);
    }
}
