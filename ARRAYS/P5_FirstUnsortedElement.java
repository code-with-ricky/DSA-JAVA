import java.util.Scanner;
public class P5_FirstUnsortedElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        if (size > 0) {
            int[] arr = new int[size];
            System.out.println("Enter array elements: ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            int firstUnsortedElement = 0;
            boolean found = false;
            for (int i = 1; i < size; i++) {
                if (arr[i] < arr[i - 1]) {
                    firstUnsortedElement = arr[i];
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("First Unsorted Element: " + firstUnsortedElement);
            } else {
                System.out.println("Array is already sorted.");
            }
        }else{
            System.out.println("Invalid Size");
        }

        sc.close();
    }
}
