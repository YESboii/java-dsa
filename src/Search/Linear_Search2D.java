package Search;
import java.util.*;
public class Linear_Search2D {
    static int[] search2D(int arr[][],int target){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(arr[i][j]==target)
                   return new int[]{i,j};
            }


        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {


        int arr[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int target=155;
        System.out.println(Arrays.toString(search2D(arr,target)));
    }

}
