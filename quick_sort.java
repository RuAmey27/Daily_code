class QuickSort {

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array
            int partitionIndex = partition(array, low, high);

            // Recursively sort the sub-arrays
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // Choose the pivot element (last element)
        int pivot = array[high];
        int i = low - 1;

        // Iterate through the array and move elements smaller than the pivot to the left
        // and elements greater than the pivot to the right
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        // Place the pivot element in its correct position
        swap(array, i + 1, high);

        // Return the index of the pivot element
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        System.out.println("Array before sorting:");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("Array after sorting:");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
