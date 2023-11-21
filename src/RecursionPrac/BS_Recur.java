package RecursionPrac;

public class BS_Recur {
    static int binarySearch(int []arr,int target,int start,int end){
        if(start>end){
            return -1;
        }
        int mid = start + (end-start)/2;
        if(arr[mid] == target){
            return mid;
        } else if (target<arr[mid]) {
            return binarySearch(arr,target,start,mid-1);
        }
        else {
            return binarySearch(arr,target,mid+1,end);
        }
    }
    public static void main(String[] args) {
        int []arr = {1,2,3,5,66,210,999,1000};
        System.out.println(binarySearch(arr,999,0, arr.length-1));
    }
}
