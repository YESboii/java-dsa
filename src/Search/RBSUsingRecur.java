package Search;

public class RBSUsingRecur {
    public static int RBS(int []arr,int target,int s,int e){
        if(s>e){
            return -1;
        }
        int mid = s + (e-s)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[s]<=arr[mid]){
            if(target>=arr[s] && target<arr[mid]){
                return RBS(arr,target,s,mid-1);
            }
            else{
                return RBS(arr,target,mid+1,e);
            }
        }else{
            if(target>arr[mid] && target<=arr[e]){
                return RBS(arr,target,mid+1,e);
            }else{
                return RBS(arr,target,s,mid-1);
            }
        }

    }
    public static void main(String[] args) {
        System.out.println(RBS(new int[]{5,6,7,8,1,2,3,4},2,0,7));
    }
}
