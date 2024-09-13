class Solution {
    public int lengthLongestPath(String input) {
       String modifiedInput = input.replace("\t", "\\");
        String[] lines = modifiedInput.split("\n");

        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;

        for (String line : lines) {
            // Calculate depth by counting backslashes
            int depth = line.lastIndexOf('\\') + 1;

            // Trim the depth part to get the actual name
            String name = line.substring(depth);

            // Update the stack to hold the current length for this depth
            while (stack.size() > depth) {
                stack.pop();
            }

            // Calculate current path length including current name
            int currentLength = (stack.isEmpty() ? 0 : stack.peek()) + name.length();
            
            // If it's a file, check if it's the longest path
            if (name.contains(".")) {
                maxLength = Math.max(maxLength, currentLength);
            }

            // Push the current length to the stack
            stack.push(currentLength + 1); // +1 for the '/' character
        }

        return maxLength;
    }
}