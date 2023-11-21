import java.util.Arrays;

public class SearchIn2DSortedMartrix {
    public static int[] binarySearch(int [][]arr,int row,int cStart,int cEnd,int target){
        while(cStart<=cEnd){
            int cMid = cStart + (cEnd - cStart)/2;
            if(arr[row][cMid]==target){
                return new int[]{row,cMid};
            } else if (arr[row][cMid]<target) {

                cStart = cMid+1;
            }
            else{
                cEnd = cMid -1;
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] searchIn2D(int [][]arr,int target){
        int rows = arr.length;
        int cols = arr[0].length;
        if(rows==1){
            return binarySearch(arr,rows,0,cols-1,target);
        }
        int rStart = 0,rEnd = rows-1,cMid = cols/2;
        while(rStart!=rEnd-1){
            int rMid = rStart+(rEnd - rStart)/2;
            if(target==arr[rMid][cMid]){
                return new int[]{rMid,cMid};
            } else if (target>arr[rMid][cMid]) {
                rStart = rMid;
            }
            else{
                rEnd = rMid;
            }
        }
        if(arr[rStart][cMid]==target){
            return new int[]{rStart,cMid};
        }
        if(arr[rStart+1][cMid]==target){
            return new int[]{rStart+1,cMid};
        }
        if(target<arr[rStart][cMid]){
            return binarySearch(arr,rStart,0,cMid-1,target);
        }
        if(target>arr[rStart][cMid] && target <arr[rStart+1][0] ){
            return binarySearch(arr,rStart,cMid+1,cols-1,target);
        }
        if(target<arr[rStart+1][cMid]){
            return binarySearch(arr,rStart+1,0,cMid-1,target);
        }

        return binarySearch(arr,rStart+1,cMid+1,cols-1,target);
    }
    public static void main(String []args){
    int [][]arr = {
            {1,3,5,7},{10,11,16,20},{23,30,34,50}
    };
        System.out.println(Arrays.toString(searchIn2D(arr, 10)));

}
}
