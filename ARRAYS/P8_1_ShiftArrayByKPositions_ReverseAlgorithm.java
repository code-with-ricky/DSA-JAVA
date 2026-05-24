// Ques: Shift array elements by k positions in right direction
// Time complexity: O(n) + O(k) + O(n-k) = O(2n) = O(n)

/*
    RIGHT SHIFTING:
    1. reverse all elements
    2. reverse first k elements
    3. reverse remaining elements
*/

import java.util.Scanner;

public class P8_ShiftArrayByKPositions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = in.nextInt();
        if(n > 0) {
            int arr[] = new int[n];
            System.out.println("Enter array elements:");
            for(int i=0; i<n; i++){
                arr[i] = in.nextInt();
            }

            System.out.print("Enter k position: ");
            int k = in.nextInt();
            if(k >= 0){
                k = k % n;
            }else{
                System.out.println("Negative position not allowed");
                return;
            }

            // reverse entire array --> O(n)
            reverseHelper(arr, 0, n-1);

            // reverse first k elements --> O(k)
            reverseHelper(arr, 0, k-1);

            // reverse remaining elements --> O(n-k)
            reverseHelper(arr, k, n-1);

            System.out.println("Shifted array: ");
            for(int i=0; i<n; i++){
                System.out.print(arr[i] + " ");
            }
        }else{
            System.out.println("Invalid size");
        }
    }


    private static void reverseHelper(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}