package Search;

public class FindInMountainArray {
    static int orderAgnosticBS(int []arr,int target,int peakIdx){
        int index = -1;

            int start = 0;
            int end = peakIdx;
            while(start<=end){
                int mid = start +(end-start)/2;

                if(target<arr[mid]){
                    end=mid-1;
                }
                else if(target>arr[mid]){
                    start = mid+1;
                }
                else{
                    return mid;
                }
            }


            start = peakIdx;
            end = arr.length-1;
            while(start<=end){
                int mid = start+(end-start)/2;
                if(target<arr[mid]){
                    start = mid+1;
                }
                else if(target>arr[mid]){
                    end =mid -1;
                }
                else{
                    return mid;
                }
            }

        return -1;
    }
    static int peakElement(int []arr){
        int index=-1;
        //1,2,4,5,4,3,2
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int middle = start + (end-start)/2;
            if(arr[middle]>arr[middle+1]){
                end=middle;
            }
            else{
                start = middle+1;
            }
        }
        index = start;
        return index;
    }
    static int targetFinderInMA(int arr[],int target){
        int peakIdx = peakElement(arr);
        int index = orderAgnosticBS(arr,target,peakIdx);
        return index;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,5,6,17,19,9,4,0};
        System.out.println(targetFinderInMA(arr,0));
    }
}
