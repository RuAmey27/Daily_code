package Algorithms;


//Errot here 
import java.util.Arrays;
import java.util.Random;

public class QuickSortMedianOfMedians {

    // Function to partition the array around a pivot element
    private static int partition(int[] arr, int low, int high, int pivot) {
        int pivotValue = arr[pivot];
        // Move pivot to end
        swap(arr, pivot, high);

        int i = low; // Index to track smaller elements

        for (int j = low; j < high; j++) {
            if (arr[j] < pivotValue) {
                swap(arr, i, j);
                i++;
            }
        }

        // Move pivot element back to its correct position
        swap(arr, i, high);

        return i;
    }

    // Function to swap two elements in an array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to find the k-th smallest element using Median of Medians
    private static int findKthSmallest(int[] arr, int low, int high, int k) {
        if (k > 0 && k <= high - low + 1) {
            // Divide the array into groups of 5 and find medians
            int n = high - low + 1; // Number of elements in the current subarray

            // Array to store medians of groups
            int[] medians = new int[(n + 4) / 5];
            int i;
            for (i = 0; i < n / 5; i++) {
                medians[i] = findMedian(arr, low + i * 5, low + i * 5 + 4);
            }
            if (i * 5 < n) {
                medians[i] = findMedian(arr, low + i * 5, low + n - 1);
                i++;
            }

            // Find the median of medians recursively
            int medianOfMedians = (i == 1) ? medians[i - 1]
                    : findKthSmallest(medians, 0, i - 1, i / 2);

            // Partition the array around the median of medians and get position of pivot element
            int pos = partition(arr, low, high, medianOfMedians);

            // If position is same as k
            if (pos - low == k - 1)
                return arr[pos];
            if (pos - low > k - 1) // If position is more, recur for left subarray
                return findKthSmallest(arr, low, pos - 1, k);

            // Else recur for right subarray
            return findKthSmallest(arr, pos + 1, high, k - pos + low - 1);
        }

        // If k is more than number of elements in array
        return Integer.MAX_VALUE;
    }

    // Function to find median of five elements
    private static int findMedian(int[] arr, int low, int high) {
        int n = high - low + 1;
        int[] temp = new int[n];
        int medianIndex = n / 2;

        for (int i = low; i <= high; i++)
            temp[i - low] = arr[i];

        Arrays.sort(temp);
        return temp[medianIndex];
    }

    // Function to generate an array of random integers
    private static int[] generateRandomArray(int size, int maxRange) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(maxRange);
        }
        return arr;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        int size = 20; // Adjust size as needed
        int maxRange = 100; // Adjust range of random numbers as needed

        int[] arr = generateRandomArray(size, maxRange);
        System.out.println("Original Array: " + Arrays.toString(arr));

        int k = size / 5; // Finding the n/5-th smallest element
        int kthSmallest = findKthSmallest(arr, 0, arr.length - 1, k);
        System.out.println("n/5-th smallest element: " + kthSmallest);

        Arrays.sort(arr); // Sorting the array to verify
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
