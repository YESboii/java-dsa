package RecursionPrac;

import java.util.ArrayList;

public class SortedArray {
    static boolean sortedArray(int []arr,int i){
        if(i ==  0 || i == arr.length - 1 ){
            return true;
        }
        return (arr[i]<arr[i+1]) && sortedArray(arr,i+1);
    }
    static int linearSearch(int []arr,int i,int target){
        if(i == arr.length || arr[i] == target ){
            return i== arr.length ? -1 : i;
        }
        return linearSearch(arr,i+1,target);
    }
    static ArrayList<Integer> occurrences(int []arr,int i,int target,ArrayList<Integer> list){
        if(i<0){

            return list;
        }
        if(arr[i] == target){
            list.add(i);
        }

            return occurrences(arr,--i,target,list);

    }
    static ArrayList<Integer> occurrences1(int []arr,int i,int target){
        ArrayList<Integer> list = new ArrayList<>();
        if(i<0){

            return list;
        }
        if(arr[i] == target){
            list.add(i);
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        list1 = occurrences1(arr,--i,target);
        list.addAll(list1);
        return list;

    }
    public static void main(String[] args) {
        int [] arr= {0,1,0,2,22};

//        System.out.println(sortedArray(arr,0));
//        System.out.println(linearSearch(arr,0,0));
        ArrayList<Integer> list = occurrences1(arr,arr.length-1,0);

        System.out.println(list);
    }
}
