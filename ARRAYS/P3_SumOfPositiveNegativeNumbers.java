import java.util.Scanner;

public class P3_SumOfPositiveNegativeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        if (size > 0) {
            int[] arr = new int[size];
            int sumPositive = 0, sumNegative = 0;
            System.out.println("Enter array elements: ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
                if(arr[i] > 0) sumPositive += arr[i];
                else if(arr[i] < 0) sumNegative += arr[i];
            }

            System.out.println("Sum of positive numbers: " + sumPositive);
            System.out.println("Sum of negative numbers: " + sumNegative);   
        }else{
            System.out.println("Invalid Size");
        }

        sc.close();
    }
}
