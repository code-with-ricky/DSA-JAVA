import java.util.Scanner;

class P1_AverageOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        if (size > 0) {
            int[] arr = new int[size];
            int sum = 0;
            System.out.println("Enter array elements: ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            
            double average = (sum * 1.0) / size;
            System.out.println("Average: " + average);
        }else{
            System.out.println("Invalid Size");
        }

        sc.close();
    }
}