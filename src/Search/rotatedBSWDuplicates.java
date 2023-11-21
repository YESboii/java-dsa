package Search;

public class rotatedBSWDuplicates {
    static boolean binarySearch(int[]arr,int target,int start,int end){

        while(start<=end){
            int mid = start + (end-start)/2;
            if(target < arr[mid]){
                end = mid -1;
            }
            else if(target> arr[mid]){
                start = mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
    static int findPivotWithDuplicates(int []arr){
        //4,5,6,7,1,2,3
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid<arr.length-1 && arr[mid]>arr[mid+1]){
                return mid;
            }
            else if(mid>0 && arr[mid]< arr[mid-1]){
                return mid-1;
            }
            else if(arr[mid]==arr[start] && arr[start]==arr[end]){
                if(start<arr.length-1 && arr[start]>arr[start+1] ){
                    return start;
                }
                start++;
                if(end>0 && arr[end-1]>arr[end]){
                    return end-1;
                }

                end--;
            }
            else if(arr[start]<arr[mid] || arr[start]==arr[mid] && arr[mid]>arr[end]){
                start=mid+1;
            }
            else  {
                end=mid-1;
            }

        }
        return -1;
    }
    static boolean search(int arr[],int target) {
        int pivot = findPivotWithDuplicates(arr);
        if (pivot == -1) {
            return binarySearch(arr, target, 0, arr.length - 1);
        }
        if (target == arr[pivot]) {
            return true;
        }

        boolean ans = binarySearch(arr, target, 0, pivot - 1);
        if (!ans) {
            return binarySearch(arr, target, pivot + 1, arr.length - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        int []arr = {1,3,5};
//        System.out.println(search(arr,1));
        System.out.println(findPivotWithDuplicates(arr));
    }
}
