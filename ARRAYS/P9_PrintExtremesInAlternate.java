import java.util.Scanner;

public class P9_PrintExtremesInAlternate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = in.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter array elements: ");
        for(int i=0; i<size; i++){
            arr[i] = in.nextInt();
        }

        int i=0, j = size - 1;
        while(i <= j) {
            System.out.print(arr[i] + " " + arr[j] + " ");
            i++;
            j--;
        }

        in.close();
    }
}
