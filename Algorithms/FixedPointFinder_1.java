package Algorithms;

import java.util.ArrayList;
import java.util.List;


//This program aims to find the all numbers in array whose position is same as of value 
//This uses binary search approach for that purpose
public class FixedPointFinder_1 {
    public static List<Integer> findAllFixedPoints(int[] arr) {
        List<Integer> fixedPoints = new ArrayList<>();
        findFixedPoints(arr, 0, arr.length - 1, fixedPoints);
        return fixedPoints;
    }

    private static void findFixedPoints(int[] arr, int low, int high, List<Integer> fixedPoints) {
        if (low > high) {
            return;
        }

        int mid = (low + high) / 2;                 //T(n)=2⋅T(2/n)+O(n) ~T(n)=O(nlogn) Time Complexity
                                                    //Space stacksize can be O(logn)+O(n)
        if (arr[mid] == mid) {
            fixedPoints.add(mid);

            // Search linearly to the left of the found point
            int left = mid - 1;
            while (left >= low) {
                if (arr[left] == left) {
                    fixedPoints.add(left);
                }
                left--;
            }

            // Search linearly to the right of the found point
            int right = mid + 1;
            while (right <= high) {
                if (arr[right] == right) {
                    fixedPoints.add(right);
                }
                right++;
            }
        }

        // Continue the search in both halves
        findFixedPoints(arr, low, mid - 1, fixedPoints);
        findFixedPoints(arr, mid + 1, high, fixedPoints);
    }

    public static void main(String[] args) {
        int[] arr = {-10, -5, 0, 3, 3, 4, 5, 7, 9, 12, 12};
        List<Integer> fixedPoints = findAllFixedPoints(arr);
        if (!fixedPoints.isEmpty()) {
            System.out.println("Elements a[i] such that a[i] = i are at indices: " + fixedPoints);
        } else {
            System.out.println("No elements found such that a[i] = i");
        }
    }
}


