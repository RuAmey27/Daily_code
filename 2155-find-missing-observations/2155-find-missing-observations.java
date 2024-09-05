class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean * (n + m);
        int sumOfProvidedRolls = 0;
        for (int roll : rolls) {
            sumOfProvidedRolls += roll;
        }
        int sumOfMissingRolls = totalSum - sumOfProvidedRolls;
        
        if (sumOfMissingRolls < n || sumOfMissingRolls > 6 * n) {
            return new int[] {};
        }
        
        int[] missingRolls = new int[n];
        int baseValue = sumOfMissingRolls / n;
        int remainder = sumOfMissingRolls % n;
        
        for (int i = 0; i < n; i++) {
            missingRolls[i] = baseValue;
        }
        
        for (int i = 0; i < remainder; i++) {
            missingRolls[i]++;
        }
        
        return missingRolls;
    }
}
