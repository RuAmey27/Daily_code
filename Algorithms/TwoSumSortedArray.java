package Algorithms;

public class TwoSumSortedArray {
    public static int[] findPair(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == x) {
                return new int[]{arr[left], arr[right]};
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1}; // Return {-1, -1} if no such pair found
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 7, 11, 15};
        int targetSum = 9;
        int[] result = findPair(arr, targetSum);

        if (result[0] != -1 && result[1] != -1) {
            System.out.println("Pair found: (" + result[0] + ", " + result[1] + ")");
        } else {
            System.out.println("No such pair found.");
        }
    }
}
