class Solution {
    public int findMinDifference(List<String> timePoints) {
       ArrayList<Integer> times = new ArrayList<>();

        for (String time : timePoints) {
            String[] hrmin = time.split(":");
            int totalMinutes = Integer.parseInt(hrmin[0]) * 60 + Integer.parseInt(hrmin[1]);
            times.add(totalMinutes);
        }

        Collections.sort(times);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < times.size(); i++) {
            int diff = times.get(i) - times.get(i - 1);
            minDiff = Math.min(minDiff, diff);
        }

        int circularDiff = (1440 - times.get(times.size() - 1)) + times.get(0);
        minDiff = Math.min(minDiff, circularDiff);

        return minDiff;
    }
}