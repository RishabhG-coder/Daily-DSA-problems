
class Solution {
    public long minimumMaxValue(int n, int index, int value) {

        // Value 1 cannot have a GCD greater than 1 with any number.
        if (value == 1) return -1L;

        // Find the smallest prime factor.
        int p = 0;

        for (int i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                p = i;
                break;
            }
        }

        // If p == 0, value is prime.
        boolean isPrime = (p == 0);

        // Number of elements required after value.
        long right = n - 1L - index;

        long ans = value;

        // Construct the right side.
        if (right > 0) {
            if (isPrime) {
                ans += value + 2L * (right - 1);
            } else if (value % 2 == 0) {
                ans += 2L * right;
            } else {
                ans += p + 2L * (right - 1);
            }
        }

        // Check whether the left side is possible.
        if (index > 0) {

            // A prime number cannot have a smaller valid predecessor.
            if (isPrime) return -1L;

            long first;

            if (value % 2 == 0) {
                first = value - 2L * index;
            } else {
                first = value - p - 2L * (index - 1L);
            }

            if (first < 2) return -1L;
        }

        return ans;
    }
}
