import java.util.Scanner;

public class P7_ShiftArrayBy1Position {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = in.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter array elements: ");
        for(int i=0; i<size; i++){
            arr[i] = in.nextInt();
        }

        // shift in left direction
        int firstEle = arr[0];
        for(int i=0; i<size - 1; i++){
            arr[i] = arr[i+1];
        }
        arr[size-1] = firstEle;

        System.out.println("Left Shifted array: ");
        for(int idx=0; idx<size; idx++){
            System.out.print(arr[idx] + " ");
        }

        // shift in right direction
        int lastEle = arr[size-1];
        for(int i=size-1; i >= 1; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = lastEle;

        System.out.println("\nRight Shifted array: ");
        for(int idx=0; idx<size; idx++){
            System.out.print(arr[idx] + " ");
        }

        in.close();
    }
}
