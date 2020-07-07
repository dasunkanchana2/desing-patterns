package com.dasun.datastructures;

public class BubbleSort {

    public static void main(String[] args) {

        int arr[] ={9,1,6,7,8,5};
        int n = arr.length;
        int temp = 0;

        for(int i=0;i<n;i++){
            for(int j=1;j<n-i;j++){
                if(arr[j]<arr[j-1]){
                    temp =arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int val:arr){
            System.out.print(val);
        }
    }

}
