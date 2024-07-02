package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class TwoSumGreaterThanX {
    public static List<int[]> findPairs(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        List<int[]> pairs = new ArrayList<>();

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum >x) {
                // All pairs (left, right), (left, right-1), ..., (left, left+1) are greater than x
                for (int i = left; i < right; i++) {
                    pairs.add(new int[]{arr[i], arr[right]});
                }
                right--;
            } else {
                left++;
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 7, 11, 15};
        int targetSum = 9;
        List<int[]> result = findPairs(arr, targetSum);

        System.out.println("Pairs with sum greater than " + targetSum + ":");
        for (int[] pair : result) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }
}
