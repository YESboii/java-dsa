package Search;

public class searchInInfiniteArray {
    static int answer(int []arr,int target){
        int index = -1;
        int start = 0;
        int end = 1;
        while(target>arr[end]){
            int temp  = end+1;
            //index of end will be prev end + prev box size*2
            end = end + (end-start+1)*2;
            start =temp;
        }
        while(start<=end){
            int mid = start +(end-start)/2;
            if(arr[mid]<target){
                start = mid+1;

            }
            else if(arr[mid]>target){
                end = mid-1;
            }
            else{
                index = mid;
                break;
            }

        }
        return index;
    }
    public static void main(String[] args) {
    int []arr = {1,2,4,5,7,8,9,33,100};
        System.out.println(answer(arr,8));
    }
}
