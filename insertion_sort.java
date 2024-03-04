class InsertionSort {
    public static void main(String[] args) {
        int[] array = {7, 4, 1, 10, 3};
        insertionSort(array);
        System.out.println("Sorted array: " + toString(array));
    }

    public static void insertionSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i = i - 1;
            }
            arr[i + 1] = key;
        }
    }
}

