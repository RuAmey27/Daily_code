class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
      // Min-heap to keep track of the smallest element in the current window
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int maxInHeap = Integer.MIN_VALUE;  // Track the maximum value in the current window
        int start = 0, end = Integer.MAX_VALUE;  // Initialize the result range

        // Initialize the heap by adding the first element of each list
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, 0, i});  // Add (value, index_in_list, list_id)
            maxInHeap = Math.max(maxInHeap, val);  // Track the maximum element
        }

        // Process the heap
        while (minHeap.size() == nums.size()) {
            // Get the smallest element from the heap
            int[] min = minHeap.poll();
            int minVal = min[0];
            int minIndex = min[1];
            int listId = min[2];

            // Update the result range if we find a smaller range
            if (maxInHeap - minVal < end - start || (maxInHeap - minVal == end - start && minVal < start)) {
                start = minVal;
                end = maxInHeap;
            }

            // If there are more elements in the list, add the next one to the heap
            if (minIndex + 1 < nums.get(listId).size()) {
                int nextVal = nums.get(listId).get(minIndex + 1);
                minHeap.offer(new int[]{nextVal, minIndex + 1, listId});
                maxInHeap = Math.max(maxInHeap, nextVal);  // Update the maximum element in the current window
            }
        }

        return new int[]{start, end};
    }  
    }
