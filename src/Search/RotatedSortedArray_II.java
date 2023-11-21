package Search;

//With duplicates our time complexity is also affected->O(n/2) since in the worst case we will move linearly i.e, by 1 step in each iteration.
//for example-> if we have[2,2,2,3,2,2,2]....
public class RotatedSortedArray_II {
    static int findPivot(int []arr){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(mid<arr.length-1 && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>0 && arr[mid]<arr[mid-1]){
                return mid-1;
            }

            if(arr[start]==arr[mid] && arr[mid]==arr[end]){
                if(start<arr.length-1 && arr[start]>arr[start+1]){
                    return start;
                }
                start++;
                if(end>0 && arr[end-1]>arr[end]){
                    return end-1;
                }
                end--;
            }
            else if(arr[start]<arr[mid] || arr[start]==arr[mid]&& arr[end]<arr[mid]){
                start = mid+1;
            }
            else{
                end = mid-1;
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
    int []arr = {1,3,5};
        System.out.println(findPivot(arr));
    }
}
