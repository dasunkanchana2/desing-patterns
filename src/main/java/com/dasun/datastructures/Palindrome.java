package com.dasun.datastructures;

public class Palindrome {

    public static void main(String[] args) {

        String s = "ABCD";
        char arr[] = s.toCharArray();
        int length = arr.length;
        for(int i=0;i<length/2;i++){
            char temp = arr[i];
            arr[i] = arr[length-i-1];
            arr[length-i-1] =temp;

        }

        for(char c:arr){
            System.out.print(c);
        }
    }
}
