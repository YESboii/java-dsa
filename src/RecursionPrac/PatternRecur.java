package RecursionPrac;

import java.util.Arrays;

public class PatternRecur {
    public static void main(String []args){
//        printTriangle(5,1);
        int []arr = {3,2,1,4,Integer.MAX_VALUE,Integer.MIN_VALUE,-1,-92929,99};
//        bubbleSort(arr,0,0);
        selectionSort(arr,0,1,0);
        System.out.println(Arrays.toString(arr));
    }

    private static void printTriangle(int r,int c) {
        if(r == 0){
            return;
        }
        if(c<=r){
            printTriangle(r,++c);
            System.out.print("*");
        }
        else{
            printTriangle(--r,1);
            System.out.println();
        }

    }
    public static void bubbleSort(int []arr,int i,int j) {
        int temp = 0;
        if (i == arr.length-1) {
            return;
        }
        if (j < arr.length - 1) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            bubbleSort(arr, i, ++j);
        } else {
            bubbleSort(arr, ++i, 0);
        }
    }
    public static void selectionSort(int []arr,int i,int j,int minIdx){
        if(i==arr.length){
            return;
        }

        if(j<arr.length){
            if(arr[j]<arr[minIdx]){
                minIdx = j;
            }
            selectionSort(arr,i,++j,minIdx);
        }
        else{
            int temp =arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
            i++;
            selectionSort(arr,i,i+1,i);
        }
    }
    }

