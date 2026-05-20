import java.util.Scanner;
public class P6_ReverseArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = in.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter array elements: ");
        for(int i=0; i<size; i++){
            arr[i] = in.nextInt();
        }

        // reverse array
        int i = 0, j = size - 1;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }

        System.out.println("Reversed array: ");
        for(int idx=0; idx<arr.length; idx++){
            System.out.print(arr[idx] + " ");
        }

        in.close();
    }
}
