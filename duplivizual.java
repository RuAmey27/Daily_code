import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
class duplivizual {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        int k = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        System.out.println("Initial array: ");
        printArray(arr);

        // Index marking
        for (int i = 0; i < k; i++) {
            int index = arr[i] % k;
            arr[index] += k;
            System.out.println("After processing element " + arr[i] + " at index " + i + ": ");
            printArray(arr);
        }

        // Extract counts
        for (int i = 0; i < k; i++) {
            if (arr[i] / k > 1) {
                result.add(i);
            }
        }

        // Check if no duplicates were found
        if (result.isEmpty()) {
            result.add(-1);
        }

        Collections.sort(result); // Ensure ascending order
        System.out.println("Result list: " + result);
        return result;
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 3, 1, 2, 3, 6, 6};
        int[] arr2 = {0, 1, 2, 3};
        
        System.out.println("Processing first array:");
        duplicates(arr1, arr1.length);
        System.out.println();

        System.out.println("Processing second array:");
        duplicates(arr2, arr2.length);
    }
}
