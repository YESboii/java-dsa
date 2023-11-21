package RecursionPrac;

public class MaxAndMin {
    public static void main(String[] args) {
        System.out.println(min(new int[]{Integer.MAX_VALUE,1,5,6,3,2,Integer.MIN_VALUE,237829332},0));
    }
    static int max(int []arr,int i){
        if(i==arr.length-1) return arr[i];

        return Math.max(arr[i],max(arr,i+1));
    }
    static int min(int []arr,int i){
        if(i==arr.length-1) return arr[i];

        return Math.min(arr[i],min(arr,i+1));
    }
}
