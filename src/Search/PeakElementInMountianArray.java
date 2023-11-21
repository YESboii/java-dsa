package Search;

public class PeakElementInMountianArray {
    static public int peakIdx(int []arr,int s,int e){
        //at s==e we get our peak element
        while(s<e){
            int m = s + (e-s)/2;
            if(arr[m]>arr[m+1]){
                //mid is inclusive since it is possible that our mid is the peak.
                e = m;
            }
            else{
                s = m+1;//start is exclusive as bigger elements lie ahead.
            }
        }
        return s;
    }
    public static void main(String[] args) {
        //1,2,5,3,2,1
        int []arr = {1,2,5,3,2,1};
        System.out.println(peakIdx(arr,0, arr.length-1));
    }
}
