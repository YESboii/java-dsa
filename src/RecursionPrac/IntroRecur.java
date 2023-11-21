package RecursionPrac;

import java.util.ArrayList;
import java.util.List;

public class IntroRecur {
    //Printing nth Fibonacci number using Recursion...
    static int fibo(int n){
        //recurrence relation fibo(n) = fibo(n-1) +fibo(n-2);
        if(n<2){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
    static boolean sortedArray(int []arr){
        if(arr.length==0){

            return false;
        }
        return helper(arr,arr.length-1);
    }
    static boolean helper(int []arr,int j){
        if(j==0){
            return true;
        }
        if(arr[j]<arr[j-1])
        {
            return false;
        }
        return helper(arr,j-1);

    }
    static boolean sorted(int []arr,int i){
        if(i== arr.length-1){
            return true;
        }
        return arr[i]<=arr[i+1] && sorted(arr,++i);
    }
    public static void main(String[] args) {
        int ans = fibo(4);
//        System.out.println(findOcc(new int[]{1,2,3,3,4,5},3,0));
//        System.out.println(geekoNacci(1,3,2,40));
//          System.out.println(sumOfDigits(12345));
//          System.out.println(product(7,13));
        System.out.println(isPrime(1,1,0));
    }
    public static List<Integer> findOcc(int []arr,int target,int index){
        List<Integer> list = new ArrayList<>();
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        list.addAll(findOcc(arr,target,index+1));
        return list;
    }
    public static int geekoNacci(int a,int b,int c,int n){
        if(n==1) return a;
        if(n==2) return b;
        if(n==3) return c;

        return geekoNacci(a,b,c,n-1)+geekoNacci(a,b,c,n-2)+geekoNacci(a,b,c,n-3);
    }
    public static int sumOfDigits(int n){
        if(n==0) return 0;

        return (n%10)+ sumOfDigits(n/10);
    }
    public static int product(int a,int b){
        if(b==0) return 0;
        return a+product(a,b-1);
    }
    public static boolean isPrime(int n,int i,int factors){

        if(i==n/2+1) return factors==1;

        if(n%i==0) factors++;

       return  isPrime(n,i+1,factors);
    }
}
