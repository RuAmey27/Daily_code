class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        Set<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }
        int currentSum = 0;
        int count = 0;

        for (int i = 1; i <= n; i++) {
           
            if (bannedSet.contains(i)) {
                continue;
            }

            if (currentSum + i > maxSum) {
                break;
            }

            currentSum += i;
            count++;
        }

        return count;
    }
}