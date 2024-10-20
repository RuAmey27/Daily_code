import java.util.*;

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> operators = new Stack<>();
        Stack<Set<Boolean>> operands = new Stack<>();
        operands.push(new HashSet<>());  // To handle the top-level expression

        for (char c : expression.toCharArray()) {
            if (c == 't' || c == 'f') {
                operands.peek().add(c == 't');
            } else if (c == '!' || c == '&' || c == '|') {
                operators.push(c);
                operands.push(new HashSet<>());
            } else if (c == ')') {
                char operator = operators.pop();
                Set<Boolean> operandSet = operands.pop();
                boolean result = false;
                
                if (operator == '!') {
                    result = !operandSet.iterator().next();  // NOT operator has only one operand
                } else if (operator == '&') {
                    result = true;
                    for (boolean val : operandSet) {
                        result &= val;
                    }
                } else if (operator == '|') {
                    result = false;
                    for (boolean val : operandSet) {
                        result |= val;
                    }
                }
                operands.peek().add(result);  // Add the result to the previous operand set
            }
        }
        
        return operands.pop().iterator().next();  // Return the final result
    }
}
