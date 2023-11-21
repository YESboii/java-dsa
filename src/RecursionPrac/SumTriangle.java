package RecursionPrac;

import java.util.Arrays;

public class SumTriangle {

    public static void main(String[] args) {
        sumTriangle(new int[]{1,2,3,4,5},5);
    }
    static void sumTriangle(int []arr,int n){
        if(arr.length==1){
            System.out.println(Arrays.toString(arr));
            return;
        }
        int []temp = new int[n-1];
        for(int i=0;i<n-1;i++){
            temp[i] = arr[i]+arr[i+1];
        }
        sumTriangle(temp,n-1);
        System.out.println(Arrays.toString(arr));
    }
}
