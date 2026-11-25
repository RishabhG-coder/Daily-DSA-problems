class Solution {
    public static int findGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    public int maxLength(int[] nums) {
        int len = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int prevG = nums[i];
            int lcmV = nums[i];
            int p = nums[i];
            for (int j = i + 1; j < n; j++) {
                p *= nums[j];
                prevG = findGCD(prevG, nums[j]);
                lcmV = (lcmV * nums[j]) / (findGCD(lcmV, nums[j]));
                if (p == (lcmV * prevG)) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }
}