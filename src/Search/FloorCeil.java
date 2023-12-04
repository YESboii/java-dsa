package Search;

import java.util.Arrays;

public class FloorCeil {
    static int floor(int n,int x,int []a){
        int floor = -1;
        int start = 0,end = a.length-1;
        while(start<=end){
            int mid=start + (end-start)/2;
            if(a[mid]<=x){
                floor = a[mid];
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return floor;
    }
    static int ceil(int n,int x,int []a){
        int ceil = -1;
        int start = 0,end = a.length-1;
        while(start<=end){
            int mid=start + (end-start)/2;
            if(a[mid]>=x){
                ceil = a[mid];
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ceil;
    }
    static int[] floorAndCeil(int n,int x,int []a){
         return new int[]{floor(n,x,a),ceil(n,x,a)};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(floorAndCeil(6, 8, new int[]{3, 4, 4, 7, 8, 10})));
    }
}
