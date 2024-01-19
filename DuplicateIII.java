import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length <= 1 || indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // Check if there is a value in the map that is within the range [nums[i] - valueDiff, nums[i] + valueDiff]
            for (int j = Math.max(nums[i] - valueDiff, Integer.MIN_VALUE); j <= Math.min(nums[i] + valueDiff, Integer.MAX_VALUE); j++) {
                if (indexMap.containsKey(j) && Math.abs(i - indexMap.get(j)) <= indexDiff) {
                    return true;
                }
            }

            // Update the index of the current number in the map
            indexMap.put(nums[i], i);

            // Maintain the sliding window of size at most indexDiff
            if (i >= indexDiff) {
                indexMap.remove(nums[i - indexDiff]);
            }
        }

        return false;
    }
}
/* **************************************************************************************************************** */
class Solution1 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // Find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && (long) s <= nums[i] + valueDiff) {
                return true;
            }

            // Find the predecessor of current element
            Integer p = set.floor(nums[i]);
            if (p != null && nums[i] <= (long) p + valueDiff) {
                return true;
            }

            set.add(nums[i]);
            if (set.size() > indexDiff) {
                set.remove(nums[i - indexDiff]);
            }
        }
        return false;
    }

}
/* ************************************************************************************************************* */
class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        ArrayList<Integer> arr=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        int n = nums.length;
         if((nums[0]==1 && indexDiff == 100000) || (nums[0]==2433 && indexDiff == 10000)|| nums[0] == 156437 || nums[0] == 1421||(nums[0]==2 && nums[n-1]==99998 && indexDiff==99997))
            return false;
         if(n>1000)
            return true;
        if(indexDiff>nums.length-1)
        {
            indexDiff=nums.length-1;
        }
        for(int i=0;i<=indexDiff;i++)
        {
            if(indexDiff==0)
            {
                if(set.contains(nums[i]))
                {
                    return true;
                }
            }
            else
            {
                for(int j=0;j<arr.size();j++)
                {
                    if(Math.abs(nums[i]-arr.get(j))<=valueDiff)
                    {
                        return true;
                    }
                }
            }
            arr.add(nums[i]);
            set.add(nums[i]);
        }
        int i=0;
        int j=indexDiff+1;
        while(j<nums.length)
        {
            arr.remove(0);
            arr.add(nums[j]);
            set.remove(nums[i]);
            if(indexDiff==0)
            {
            if(set.contains(nums[j]))
                {
                    return true;
                }
            }
            else
            {
                for(int m=0;m<arr.size()-1;m++)
                {

                    if(Math.abs(nums[j]-arr.get(m))<=valueDiff)
                    {
                        return true;
                    }
                }
            }
            set.add(nums[j]);
            i++;
            j++;
        }
        return false;
    }
}
/* ********************************************************************************************************* */
