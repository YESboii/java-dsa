package Bitwise_Maths;

public class Unique {
    //ex-or can be used to find only unique element in an array of duplicates
    //to find odd number/even number of occurrences in an array.
    public static void main(String[] args) {
        int []arr = {2,2,4,1,4,6,6,6,5,1,5};
        int result=0;
        for(int i:arr){
            result=result^i;
        }
        System.out.println(result);
    }
}
