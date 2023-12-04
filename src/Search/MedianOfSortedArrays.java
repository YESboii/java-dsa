package Search;

import java.math.BigInteger;
import java.util.Arrays;

public class MedianOfSortedArrays {
    public static void main(String[] args) {

        System.out.println(uppercaseOrLowercase(5,"aBZac"));
    }
    public static long solve(long N) {
        // Write your code here
        BigInteger n1 = BigInteger.valueOf(1L);
        BigInteger n2 = BigInteger.valueOf(1L);
        while(N!=1){
            BigInteger temp = n1.add(n2);
            n1 = n2;
            n2 = temp;
            N--;
        }


        n1 = n1.remainder(BigInteger.valueOf(1000000007L));

        return n1.longValue();
    }
    static String uppercaseOrLowercase(int n, String s) {
        int lower = 0, upper = 0;

        for (char c : s.toCharArray()) {
            if (c >= 'a') {
                lower++;
            } else {
                upper++;
            }
        }

        StringBuilder str = new StringBuilder();

        if (lower > upper) {
            for (char c : s.toCharArray()) {
                char ch = (char) (c - 32);
                str.append(ch);
            }
        } else {
            for (char c : s.toCharArray()) {
                char ch = (char) (c + 32);
                str.append(ch);
            }
        }

        return str.toString();
    }

//    public static double median(int []a,int []b){
//        if(a.length>b.length){
//            return median(b,a);
//        }
//        int totalLength = a.length + b.length;
//        int mid = totalLength/2;
//        int l = 0,r = a.length-1;
//
//        while(true){
//            int m = (l+r)>>1;//since our mid index is inclusive,therefore, we will take floor division
//            int midB = mid - m -2;
//
//            int leftA = m>=0 ? a[m] :
//
//
//            if(leftB<=rightA && leftA<=rightB){
//                if(total%2!=0) return Math.min(rightA,rightB);
//
//                else return (Math.max(leftA,leftB) + Math.min(rightA,rightB)) / 2.0;
//
//            }
//            else if(leftB>rightA) r = midB-1;
//
//            else l = midB+1;
//
//
//
//        }
    }

