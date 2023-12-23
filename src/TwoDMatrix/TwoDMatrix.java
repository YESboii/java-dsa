package TwoDMatrix;

import java.util.Arrays;
import java.util.Stack;

public class TwoDMatrix {
    //In case of row & col sorted matrix the search time complexity = O(n+m);
    //because in the worst case i.e, if our element lies at(n-1,0) we need to traverse the entire matrix;
    public static void main(String[] args) {
        int [][]arr = {
                {1,4,7,11,15}
        };
        System.out.println(Arrays.toString(ans(arr,1,5,15)));
            }
    public static int[] ans(int [][]arr,int m,int n,int target){
        int row = 0,col = n-1;
        while(row<m && col>=0){
            if(arr[row][col]==target){
                return new int[]{row,col};
            }
            else if(arr[row][col]<target){
                row++;
            }
            else{
                col--;
            }
        }
        return new int[]{-1,-1};
    }
}
