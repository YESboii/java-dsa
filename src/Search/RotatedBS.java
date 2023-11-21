package Search;


public class RotatedBS {

    //no duplicates
    static int findPivot(int []arr){
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
            else if(arr[mid]<=arr[start]){
                end=mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
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
                if(arr[start]>arr[start+1]){
                    return start;
                }
                else if(arr[end-1]>arr[end]){
                    return end-1;
                }
                start++;
                end--;
            } else if (arr[mid]<=arr[start]) {
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    static int binarySearch(int[]arr,int target,int start,int end){

        while(start<=end){
            int mid = start + (end-start)/2;
            if(target < arr[mid]){
                end = mid -1;
            }
            else if(target> arr[mid]){
                start = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    static int search(int arr[],int target) {
        int pivot = findPivot(arr);
        if(pivot==-1){
            return binarySearch(arr,target,0,arr.length-1);
        }
        if (target == arr[pivot]) {
            return pivot;
        }

        int ans = binarySearch(arr, target, 0, pivot - 1);
        if (ans == -1) {
            return binarySearch(arr, target, pivot + 1, arr.length - 1);
        }
        return ans;


    }
    public static void main(String[] args) {
        int []arr = {2,5,6,6,6,6,0,0,1,2};
//        System.out.println(search(arr,2));
        System.out.println(findPivotWithDuplicates(arr));
    }
}
