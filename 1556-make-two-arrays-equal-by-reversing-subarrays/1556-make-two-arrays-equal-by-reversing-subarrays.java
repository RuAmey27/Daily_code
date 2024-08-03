class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        
        int left = 0;
        int right = target.length - 1;

        while (left <= right) {
            if (target[left] != arr[left] || target[right] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}