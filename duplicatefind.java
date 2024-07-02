/**
 * here we are finding duplicates in array using check and mark strategy
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        int k = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        // Index marking
        for (int i = 0; i < k; i++) {
            int index = arr[i] % k;
            arr[index] += k;
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
        return result;
    }
}