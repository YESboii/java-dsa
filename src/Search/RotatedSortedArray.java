package Search;

public class RotatedSortedArray {
    static int findPivot(int []arr){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(mid<arr.length-1 && arr[mid]>arr[mid+1]){
                return mid;
            }
            else if(mid>0 && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            else if(arr[mid]<arr[end]){
                end = mid-1;
            }
            else{
                start = mid+1;
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
//    static int search(int []arr,int target){
//        int pIndex = findPivot(arr);
//        if(pIndex==-1){
//            return binarySearch(arr,target,0,arr.length-1);
//        }
//        int ans = binarySearch(arr,target,0,pIndex);
//        if(ans==-1){
//            ans = binarySearch(arr,target,pIndex+1,arr.length-1);
//        }
//        return ans;
//    }
static int search(int []arr,int target){
    int start = 0,end = arr.length-1;
    while(start<=end){
        int mid = start + (end -start)/2;
        boolean condition1 = arr[mid]<arr[start] && target<=arr[start] && target > arr[mid];
        boolean condition2 = arr[mid]>arr[start] && target>=arr[start] && target<arr[mid];
        boolean condition3 = target > arr[end];
        if(arr[mid]==target){
            return mid;
        }
        else if( (condition1 || condition2) && condition3 ){
            end = mid -1;
        }
        else{
            start = mid+1;
        }
    }
    return -1;
}
    public static void main(String[] args) {
        System.out.println(search(new int[]{5,1,3},3));
    }
}
