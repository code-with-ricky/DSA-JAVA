import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P14_Find_Unique_Ellement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter n (size of array): ");
        int n = in.nextInt();

        if (n > 0) {
            int[] arr = new int[n];
            System.out.println("Enter " + n + " elements in array");
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int uniqueElement = xorMethod(arr, n);

            System.out.println("Unique Element: " + uniqueElement);
        } else {
            System.out.println("n cannot be <= 0");
        }

        in.close();
    }

    public static int xorMethod(int[] arr, int n) {
        int uniqueElement = 0;
        for (int i = 0; i < n; i++) {
            uniqueElement ^= arr[i];
        }

        return uniqueElement;
    }

    public static int hashmapMethod(int[] arr, int n){
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<n; i++){
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }

        for(int ele: freq.keySet()){
            if(freq.get(ele) == 1){
                return ele;
            }
        }

        return 0;
    }
}