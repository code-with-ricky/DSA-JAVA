import java.util.Scanner;

public class P4_CountZerosAndOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        if (size > 0) {
            int[] arr = new int[size];
            int count0 = 0, count1 = 0;
            System.out.println("Enter array elements: ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
                if(arr[i] == 0) count0 += 1;
                else count1 += 1;
            }

            System.out.println("Number of 0s: " + count0);
            System.out.println("Number of 1s: " + count1);   
        }else{
            System.out.println("Invalid Size");
        }

        sc.close();
    }
}
