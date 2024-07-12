class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return calculatePoints(s, 'a', 'b', x, y);
        } else {
            return calculatePoints(s, 'b', 'a', y, x);
        }
    }

    private int calculatePoints(String s, char first, char second, int highPoints, int lowPoints) {
        // Step 1: Remove the pair with the higher points first
        StringBuilder stack = new StringBuilder();
        int points = 0;

        for (char c : s.toCharArray()) {
            if (c == second && stack.length() > 0 && stack.charAt(stack.length() - 1) == first) {
                stack.deleteCharAt(stack.length() - 1);
                points += highPoints;
            } else {
                stack.append(c);
            }
        }

        // Step 2: Process remaining string for the lower points pair
        StringBuilder remaining = new StringBuilder();
        for (char c : stack.toString().toCharArray()) {
            if (c == first && remaining.length() > 0 && remaining.charAt(remaining.length() - 1) == second) {
                remaining.deleteCharAt(remaining.length() - 1);
                points += lowPoints;
            } else {
                remaining.append(c);
            }
        }

        return points;
    }
}
