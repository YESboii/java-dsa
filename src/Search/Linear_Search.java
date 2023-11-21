package Search;

public class Linear_Search{

    //Linear Search - Looping through every Element.
    /*Best case=O(1) worst case=O(n)*/

    static int linearSearch(int[] arr,int target) {
        if (arr.length == 0)
            return -1;

            for (int index = 0; index < arr.length; index++) {
                if (arr[index] == target)
                    return index;


            }
            return -1;

    }
    public static void main(String[] args) {
        int arr1[] = {1,2,367,21,90,87};
        System.out.println(linearSearch(arr1,901));

    }
}