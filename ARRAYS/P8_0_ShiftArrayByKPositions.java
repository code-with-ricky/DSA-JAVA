// Ques: Shift array elements by k positions
// Time complexity = O(k * n)
// if k = n; Time complexity = O(n*n)

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

            while(k > 0){
                // shift in right direction
                int last = arr[n-1];
                for(int i=n-1; i>=1; i--){
                    arr[i] = arr[i-1];
                }
                arr[0] = last;
                k--;
            }

            System.out.println("Shifted array: ");
            for(int i=0; i<n; i++){
                System.out.print(arr[i] + " ");
            }
        }else{
            System.out.println("Invalid size");
        }
    }
}