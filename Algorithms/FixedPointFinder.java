package Algorithms;


//Aims to find the single element which has value equal to it's position
public class FixedPointFinder {
    public static int findFixedPoint(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == mid) {
                return mid; // or return arr[mid]
            } else if (arr[mid] > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1; // return -1 if no such element exists
    }

    public static void main(String[] args) {
        int[] arr = {-10, -5, 0, 3, 7, 9, 12};
        int index = findFixedPoint(arr);
        if (index != -1) {
            System.out.println("Element a[i] such that a[i] = i is at index: " + index);
        } else {
            System.out.println("No element found such that a[i] = i");
        }
    }
}

