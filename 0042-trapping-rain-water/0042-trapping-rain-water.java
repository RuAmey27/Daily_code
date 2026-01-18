class Solution {
    public int trap(int[] height) {
     Stack<Integer> stack = new Stack<>(); // stores indices
        int water = 0;

        for (int i = 0; i < height.length; i++) {

            // When current bar is higher than stack top,
            // we found a right boundary
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {

                int bottom = stack.pop(); // valley bottom

                // If stack is empty, no left boundary
                if (stack.isEmpty()) break;

                int left = stack.peek();  // left boundary

                int width = i - left - 1;
                int boundedHeight =
                        Math.min(height[left], height[i]) - height[bottom];

                water += width * boundedHeight;
            }

            // Push current index
            stack.push(i);
        }

        return water;
    }
}