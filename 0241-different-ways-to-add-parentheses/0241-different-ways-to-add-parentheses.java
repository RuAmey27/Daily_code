class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
                List<Integer> result = new ArrayList<>();
        
        // Traverse through each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // If the character is an operator, split the expression
            if (c == '+' || c == '-' || c == '*') {
                // Compute left and right parts of the expression
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                
                // Combine the results of left and right parts using the operator
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        
        // If no operator was found, the expression is just a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        return result;

    }
}