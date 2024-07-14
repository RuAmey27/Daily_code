class Solution {
   public int minimumCost(int m, int n, int[] horizontalCuts, int[] verticalCuts) {
        // Sort the cuts in descending order
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        // Reverse the arrays to get descending order
        for (int i = 0; i < horizontalCuts.length / 2; i++) {
            int temp = horizontalCuts[i];
            horizontalCuts[i] = horizontalCuts[horizontalCuts.length - i - 1];
            horizontalCuts[horizontalCuts.length - i - 1] = temp;
        }
        for (int i = 0; i < verticalCuts.length / 2; i++) {
            int temp = verticalCuts[i];
            verticalCuts[i] = verticalCuts[verticalCuts.length - i - 1];
            verticalCuts[verticalCuts.length - i - 1] = temp;
        }

        int hCount = 1; // Initial horizontal pieces count
        int vCount = 1; // Initial vertical pieces count
        int hIndex = 0;
        int vIndex = 0;
        int cost = 0;

        // Greedily choose the larger cut from the two arrays
        while (hIndex < horizontalCuts.length && vIndex < verticalCuts.length) {
            if (horizontalCuts[hIndex] >= verticalCuts[vIndex]) {
                cost += horizontalCuts[hIndex] * vCount;
                hCount++;
                hIndex++;
            } else {
                cost += verticalCuts[vIndex] * hCount;
                vCount++;
                vIndex++;
            }
        }

        // Add remaining horizontal cuts
        while (hIndex < horizontalCuts.length) {
            cost += horizontalCuts[hIndex] * vCount;
            hIndex++;
        }

        // Add remaining vertical cuts
        while (vIndex < verticalCuts.length) {
            cost += verticalCuts[vIndex] * hCount;
            vIndex++;
        }

        return cost;
    }

}