class Solution {
    public int minGroups(int[][] intervals) {
        List<int[]> events = new ArrayList<>();
        
        // Add events for each interval
        for (int[] interval : intervals) {
            events.add(new int[]{interval[0], 1});  // Start of interval
            events.add(new int[]{interval[1] + 1, -1});  // End of interval
        }
        
        // Sort events by time, breaking ties by prioritizing end (-1) over start (+1)
        Collections.sort(events, (a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        
        int maxGroups = 0;
        int activeIntervals = 0;
        
        // Sweep through events
        for (int[] event : events) {
            activeIntervals += event[1];  // Add or remove an interval
            maxGroups = Math.max(maxGroups, activeIntervals);  // Track max active intervals
        }
        
        return maxGroups;
    }
}