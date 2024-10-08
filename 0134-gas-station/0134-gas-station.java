class Solution {
   public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, start = 0, tank = 0;
        
        // Calculate total gas and total cost
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        // If total gas is less than total cost, return -1
        if (totalGas < totalCost) {
            return -1;
        }
        
        // Find the starting gas station
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        
        return start;
    }
}