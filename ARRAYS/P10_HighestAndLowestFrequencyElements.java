import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10_highest_lowest_frequency_elements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = in.nextInt();

        if (size > 0) {
            // LinkedHashMap keeps insertion order = first appearance in array (tie-break)
            Map<Integer, Integer> freq = new LinkedHashMap<>();

            System.out.println("Enter array elements: ");
            for (int i = 0; i < size; i++) {
                int x = in.nextInt();
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            int highestFrequency = Integer.MIN_VALUE;
            int lowestFrequency = Integer.MAX_VALUE;
            int highestFreqEle = 0;
            int lowestFreqEle = 0;

            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                int ele = entry.getKey();
                int count = entry.getValue();

                if (count > highestFrequency) {
                    highestFrequency = count;
                    highestFreqEle = ele;
                }

                if (count < lowestFrequency) {
                    lowestFrequency = count;
                    lowestFreqEle = ele;
                }
            }

            System.out.println("Highest Frequency Element: " + highestFreqEle
                    + " (frequency: " + highestFrequency + ")");
            System.out.println("Lowest Frequency Element: " + lowestFreqEle
                    + " (frequency: " + lowestFrequency + ")");
        } else {
            System.out.println("Size of array cannot be negative or zero");
        }

        in.close();
    }
}
