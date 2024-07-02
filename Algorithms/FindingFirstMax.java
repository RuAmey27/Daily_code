package Algorithms;

//Aims to find position of first infinite in the given array
public class FindingFirstMax {

    public static int findFirstInfinite(int[] arr) //Time complexity is O(logn)as uses binary search apporach 
    {
        int low = 0;
        int high = arr.length - 1;
        int firstInfinite = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == Integer.MAX_VALUE) {
                firstInfinite = mid; // Record the candidate for the first infinite
                high = mid - 1; // Search in the left half
            } else {
                low = mid + 1; // Search in the right half
            }
        }

        return firstInfinite;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE };
        int index = findFirstInfinite(arr);
        if (index != -1) {
            System.out.println("The first infinite is at index: " + index);
        } else {
            System.out.println("No infinite found in the array.");
        }
    }
}
