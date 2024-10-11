class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        
        // Sort friends based on arrival time.
        int[][] sortedTimes = new int[n][3];
        for (int i = 0; i < n; i++) {
            sortedTimes[i][0] = times[i][0];   // arrival time
            sortedTimes[i][1] = times[i][1];   // departure time
            sortedTimes[i][2] = i;             // friend index
        }
        Arrays.sort(sortedTimes, (a, b) -> a[0] - b[0]);  // Sort by arrival time
        
        // PriorityQueue to store available chairs (min-heap to get smallest available chair)
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);  // Initially all chairs from 0 to n-1 are available
        }
        
        // PriorityQueue to store the occupied chairs and their leaving time
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for (int[] time : sortedTimes) {
            int arrival = time[0];
            int departure = time[1];
            int friend = time[2];
            
            // Free up chairs of friends who have left before current arrival
            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= arrival) {
                availableChairs.add(occupiedChairs.poll()[1]);
            }
            
            // Assign the smallest available chair to the current friend
            int assignedChair = availableChairs.poll();
            
            // If the current friend is the target friend, return the assigned chair number
            if (friend == targetFriend) {
                return assignedChair;
            }
            
            // Mark the chair as occupied until the friend's departure time
            occupiedChairs.add(new int[] {departure, assignedChair});
        }
        
        return -1;
    }
}