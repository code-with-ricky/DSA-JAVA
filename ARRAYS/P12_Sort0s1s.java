import java.util.Scanner;

public class P12_Sort_0s_1s {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int size = in.nextInt();

        if (size > 0) {
            int arr[] = new int[size];
            System.out.println("Enter array elements (0s or 1s): ");
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
            }

            int i = 0, j = size - 1;
            while (i < j) {
                if (arr[i] == 0) {
                    i++;
                } else if (arr[j] == 1) {
                    j--;
                } else {
                    // arr[i] == 1 and arr[j] == 0
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            }

            System.out.print("Sorted Array: ");
            for (int idx = 0; idx < size; idx++) {
                System.out.print(arr[idx] + " ");
            }
        } else {
            System.out.println("Size cannot be negative or zero");
        }

        in.close();
    }
}
