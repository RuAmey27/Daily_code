class Solution {
    public int trap(int[] height) {

        int n = height.length;

        // stack implemented using array (stores indices)
        int[] stack = new int[n];
        int top = -1;

        int water = 0;

        for (int i = 0; i < n; i++) {

            // while current bar is higher than the top of stack
            while (top >= 0 && height[i] > height[stack[top]]) {

                int bottom = stack[top--]; // POP valley bottom

                // no left boundary
                if (top < 0) break;

                int left = stack[top]; // left boundary index

                int width = i - left - 1;
                int boundedHeight =
                        Math.min(height[left], height[i]) - height[bottom];

                water += width * boundedHeight;
            }

            // PUSH current index
            stack[++top] = i;
        }

        return water;
    }
}
