import java.util.Arrays;

public class mergeinplace {
   

    public static void merge(int[] arr1, int n, int[] arr2, int m) {
        int gap = (n + m + 1) / 2;
        
        while (gap > 0) {
            int i = 0;
            int j = gap;
            
            while (j < (n + m)) {
                if (j < n && arr1[i] > arr1[j]) {
                    // Swap elements in arr1
                    int temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                    System.out.println("Swapped arr1[" + i + "] and arr1[" + j + "]: " + Arrays.toString(arr1));
                } else if (j >= n && i < n && arr1[i] > arr2[j - n]) {
                    // Swap elements between arr1 and arr2
                    int temp = arr1[i];
                    arr1[i] = arr2[j - n];
                    arr2[j - n] = temp;
                    System.out.println("Swapped arr1[" + i + "] and arr2[" + (j - n) + "]: " + Arrays.toString(arr1) + " & " + Arrays.toString(arr2));
                } else if (j >= n && i >= n && arr2[i - n] > arr2[j - n]) {
                    // Swap elements in arr2
                    int temp = arr2[i - n];
                    arr2[i - n] = arr2[j - n];
                    arr2[j - n] = temp;
                    System.out.println("Swapped arr2[" + (i - n) + "] and arr2[" + (j - n) + "]: " + Arrays.toString(arr2));
                }
                i++;
                j++;
            }
            
            System.out.println("After gap " + gap + ":");
            System.out.println("arr1: " + Arrays.toString(arr1));
            System.out.println("arr2: " + Arrays.toString(arr2));
            
            if (gap == 1) {
                gap = 0;
            } else {
                gap = (gap + 1) / 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 9, 10, 15, 20};
        int[] arr2 = {2, 3, 8, 13};

        int n = arr1.length;
        int m = arr2.length;

        merge(arr1, n, arr2, m);

        System.out.println("Final merged arrays:");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
    }
}

    
