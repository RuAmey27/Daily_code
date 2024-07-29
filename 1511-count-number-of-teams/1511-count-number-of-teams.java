class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[] leftSmaller = new int[n];
        int[] rightLarger = new int[n];
        int[] leftLarger = new int[n];
        int[] rightSmaller = new int[n];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftSmaller[i]++;
                } else if (rating[j] > rating[i]) {
                    leftLarger[i]++;
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (rating[j] > rating[i]) {
                    rightLarger[i]++;
                } else if (rating[j] < rating[i]) {
                    rightSmaller[i]++;
                }
            }
        }

        int numTeams = 0;
        for (int i = 0; i < n; i++) {
            numTeams += leftSmaller[i] * rightLarger[i] + leftLarger[i] * rightSmaller[i];
        }

        return numTeams;
    }
}