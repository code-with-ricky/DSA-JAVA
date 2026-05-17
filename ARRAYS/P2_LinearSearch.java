import java.util.Scanner;

public class P2_LinearSearch {
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
            System.out.print("Enter element to search: ");
            int ele = sc.nextInt();

            int index = -1;
            for(int i = 0; i < size; i++){
                if(arr[i] == ele){
                    index = i;
                    break;
                }
            }

            if(index == -1) System.out.println(ele + " not present in the array");
            else System.out.println(ele + " present in array at index: " + index);
        }else{
            System.out.println("Invalid Size");
        }

        sc.close();
    }
}
