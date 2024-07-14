class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> currentMap = new HashMap<>();
        int i = 0;
        int len = formula.length();

        while (i < len) {
            if (formula.charAt(i) == '(') {
                stack.push(currentMap);
                currentMap = new HashMap<>();
                i++;
            } else if (formula.charAt(i) == ')') {
                int iStart = ++i;
                int multiplier = 1;
                while (i < len && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (i > iStart) {
                    multiplier = Integer.parseInt(formula.substring(iStart, i));
                }
                if (!stack.isEmpty()) {
                    Map<String, Integer> temp = currentMap;
                    currentMap = stack.pop();
                    for (String key : temp.keySet()) {
                        currentMap.put(key, currentMap.getOrDefault(key, 0) + temp.get(key) * multiplier);
                    }
                }
            } else {
                int iStart = i++;
                while (i < len && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String element = formula.substring(iStart, i);
                iStart = i;
                while (i < len && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = (i > iStart) ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                currentMap.put(element, currentMap.getOrDefault(element, 0) + count);
            }
        }

        StringBuilder result = new StringBuilder();
        List<String> keys = new ArrayList<>(currentMap.keySet());
        Collections.sort(keys);

        for (String key : keys) {
            result.append(key);
            if (currentMap.get(key) > 1) {
                result.append(currentMap.get(key));
            }
        }

        return result.toString();
    }
}