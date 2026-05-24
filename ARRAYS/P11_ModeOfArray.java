import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class P11_Mode_Of_Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int size = in.nextInt();

        if (size > 0) {
            Map<Integer, Integer> freq = new LinkedHashMap<>();
            for (int i = 0; i < size; i++) {
                int x = in.nextInt();
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            // Step 1: find maximum frequency
            int highestFrequency = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() > highestFrequency) {
                    highestFrequency = entry.getValue();
                }
            }

            // Step 2: collect every element with that frequency (order = first in array)
            List<Integer> modes = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == highestFrequency) {
                    modes.add(entry.getKey());
                }
            }

            System.out.println("Mode frequency: " + highestFrequency);
            System.out.println("Mode value(s): " + modes);
        } else {
            System.out.println("Size cannot be <= 0");
        }

        in.close();
    }
}
