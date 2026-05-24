/*
    Find Union of two arrays --> find all unique elements in both arrays
    
    Input:
    Array 1 = [1,2,2,3]
    Array 2 = [2,3,3,4]

    Output:
    Union = [1,2,3,4]


    Brute Force : Used HashSet for handling unique elements automatically
    loop -> O(n1) and O(n2)
    insertion in set --> O(1)

    Total TC: O(n1 * 1) + O(n2 * 1) = O(n1 + n2)
*/
import java.util.*;
public class P15_UnionOfArrayElements {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of array1: ");
        int n1 = in.nextInt();
        System.out.print("Enter size of array2: ");
        int n2 = in.nextInt();

        if(n1 > 0 && n2 > 0){
            int arr1[] = new int[n1];
            int arr2[] = new int[n2];
            System.out.println("Enter array1 elements:");
            for(int i=0; i<n1; i++){
                arr1[i] = in.nextInt();
            }
            System.out.println("Enter array2 elements:");
            for(int i=0; i<n2; i++){
                arr2[i] = in.nextInt();
            }

            Set<Integer> union = new HashSet<>();
            // O(n1)
            for(int i=0; i<n1; i++){
                union.add(arr1[i]); // O(1)
            }

            // O(n2)
            for(int i=0; i<n2; i++){
                union.add(arr2[i]); // O(1)
            }

            for(int ele: union){
                System.out.print(ele + " ");
            }
        }else{
            System.out.println("Array size is invalid");
        }
    }
}