class Solution {
   public static void bubbleSort(int[] arr,String[] arr2) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    String temp2=arr2[j];
                    arr2[j]=arr2[j+1];
                    arr2[j+1]=temp2;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then the array is sorted
            if (!swapped) break;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        Solution.bubbleSort(heights,names);
        return names;
    }
}