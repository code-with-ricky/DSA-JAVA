/*
 * Array has n distinct numbers from {0, 1, 2, ..., n}.
 * Exactly one number from that range is missing — find it.
 *
 * Method 1 — Marking array: Time O(n), Space O(n)
 * Method 2 — XOR:           Time O(n), Space O(1)
 */

import java.util.Scanner;

public class P13_Find_Missing_Number {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n (size of array): ");
        int n = in.nextInt();

        if (n > 0) {
            int[] arr = new int[n];
            System.out.println("Enter " + n + " distinct numbers from 0 to " + n + ": ");
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int missingByMarking = findMissingUsingMarkingArray(arr, n);
            int missingByXor = findMissingUsingXor(arr, n);

            System.out.println("Missing Number (marking array): " + missingByMarking);
            System.out.println("Missing Number (XOR): " + missingByXor);
        } else {
            System.out.println("n cannot be <= 0");
        }

        in.close();
    }

    // Method 1: temp[0..n], mark present values, index still -1 is missing
    public static int findMissingUsingMarkingArray(int[] arr, int n) {
        int[] temp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            temp[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            temp[arr[i]] = 1;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == -1) {
                return i;
            }
        }
        return -1; // invalid input: no missing value in range
    }

    // Method 2: xor(0..n) ^ xor(array) = missing
    public static int findMissingUsingXor(int[] arr, int n) {
        int xorAll = 0;

        for (int i = 0; i <= n; i++) {
            xorAll ^= i;
        }

        for (int i = 0; i < n; i++) {
            xorAll ^= arr[i];
        }

        return xorAll;
    }
}
