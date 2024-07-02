package Algorithms;

public class TwoSumSortedArray_boolean
{
    public static boolean hasPairWithSumGreaterThanX(int[] arr, int x) {
        if (arr.length < 2) {
            return false; // Cannot have a pair if array has less than 2 elements
        }

        // Calculate the sum of the last two elements
        int sum = arr[arr.length - 2] + arr[arr.length - 1];

        return sum>x?true:false;
    }

    public static void main(String[] args) {
        int[] arr = {1000, 2000, 3000, 4000, 5000, 6000};
        // No pairs sum to 10000
        int[] arr3 = {5000, 6000, 7000, 8000, 9000, 10000};
// Pairs: (7000, 3000), (8000, 2000), (9000, 1000), (10000, 0)

// Pairs: (5000, 5000), (6000, 4000), (8000, 2000), (9000, 1000)

        int targetSum = 10000; // Example target sum
        boolean result = hasPairWithSumGreaterThanX(arr3, targetSum);

        if (result) {
            System.out.println("Array has a pair with sum " + targetSum);
        } else {
            System.out.println("Array does not have a pair with sum " + targetSum);
        }
    }
}
