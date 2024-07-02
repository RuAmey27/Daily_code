package Algorithms;

public class FirstInfiniteFinder {
    public static int findFirstInfinite(int[] arr) // Time cost T(m)=O(logm)+O(logm)=2O(logm) ~O(logm)
    {
        // Step 1: Exponential search to find the range    //Time cost is O(logm)
        int index = 1;
        while (true) {
            try {
                if (arr[index] == Integer.MAX_VALUE) {
                    break;
                }
                index *= 2;
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }

        // Step 2: Binary search within the identified range  //Time cost is O(logm)
        int low = index / 2;
        int high = index;
        int firstInfinite = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            try {
                if (arr[mid] == Integer.MAX_VALUE) {
                    firstInfinite = mid; // Record the candidate for the first infinite
                    high = mid - 1; // Search in the left half
                } else {
                    low = mid + 1; // Search in the right half
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                high = mid - 1; // Adjust search range due to out-of-bounds
            }
        }

        return firstInfinite;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int index = findFirstInfinite(arr);
        if (index != -1) {
            System.out.println("The first infinite is at index: " + index);
        } else {
            System.out.println("No infinite found in the array.");
        }
    }
}


/*Large array with the first infinite at the end:

If the first infinite value appears near the end of a large array, the exponential search has to perform many iterations 
before finding the range where the first infinite is located. 
For example:
int[] arr = {1, 2, 3, 4, 5, ..., Integer.MAX_VALUE};  // Assume Integer.MAX_VALUE is at a very large index
Specifically, if the infinite value is at the last position of the array of size 𝑛,
the exponential search would have to expand up to the size of the array, doubling the index each time.
Array with large gaps between integers and the first infinite:

If there are large gaps between the integers and the first infinite value, the algorithm still needs to expand significantly. 
For example:
int[] arr = {1, 2, 3, ..., Integer.MAX_VALUE, Integer.MAX_VALUE, ...};  // Assume there are large gaps of finite values
Here, the first occurrence of Integer.MAX_VALUE is located far from the initial values, requiring the exponential search to cover a large range.
Sparse array with far-separated values:

If the array has very sparse finite values with large indices before reaching the first infinite, the exponential search will need to expand widely. 
For example:
int[] arr = {1, Integer.MAX_VALUE, Integer.MAX_VALUE, ..., Integer.MAX_VALUE};  // `1` at index 0, and infinite values starting from index 1
In this case, the exponential search would quickly find the infinite value, but this scenario represents a dense clustering of infinite values after a single finite value.
In all these scenarios, the exponential search will perform the maximum number of steps to identify the range containing the first infinite value, thus representing the worst-case input for the algorithm. */

