class Solution {
    public boolean primeSubOperation(int[] nums) {
    int n = nums.length;
        List<Integer> primes = generatePrimes(1000);

        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= prev) return false;

            // Try to make nums[i] as small as possible while still greater than prev
            for (int j = primes.size() - 1; j >= 0; j--) {
                int p = primes.get(j);
                if (p < nums[i] && nums[i] - p > prev) {
                    nums[i] -= p;
                    break;
                }
            }
            if (nums[i] <= prev) return false;
            prev = nums[i];
        }
        return true;
    }

    private List<Integer> generatePrimes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }

}