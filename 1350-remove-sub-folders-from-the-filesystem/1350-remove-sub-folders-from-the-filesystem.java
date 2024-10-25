class Solution {
    public List<String> removeSubfolders(String[] folder) {
         Arrays.sort(folder);
        
        List<String> result = new ArrayList<>();
        
        for (String f : folder) {
            // Only add if it's not a sub-folder of the last added folder
            if (result.isEmpty() || !f.startsWith(result.get(result.size() - 1) + "/")) {
                result.add(f);
            }
        }
        
        return result;
    }
}