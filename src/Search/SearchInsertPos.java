package Search;

public class SearchInsertPos {
    static int searchInsert(int []arr,int target){
        int start = 0;
        int end = arr.length-1;
        int index = -1;
        while(start<=end){
            int mid = start + (end - start)/2;

            if(target<arr[mid]){
                end = mid-1;
            }
            else if(target>arr[mid]){
                start = mid+1;
            }
            else{
                index = mid;
                break;
            }
        }

        //our BS always ends when start becomes start= end+1;
        //so when we return start it returns the index..
        if(index != -1){
            return index;
        }
        return start;
    }
    public static void main(String[] args) {
        int []arr = {1,3,5,6};
        int index = searchInsert(arr,0);
        System.out.println(index);

    }

}
