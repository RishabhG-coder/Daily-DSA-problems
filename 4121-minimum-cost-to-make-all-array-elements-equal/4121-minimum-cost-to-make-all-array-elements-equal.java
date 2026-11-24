class Solution {
    public long minCost(int[] nums) {
        int n = nums.length;
        boolean flag = true;
        for (int i = 0; i <= n - 2; i++) {
            if (nums[i] != nums[i + 1]) {
                flag = false;
                break;
            }
        }
        if (flag)
            return 0;
        int i = 1;
        int j = 1;
        long ans = Long.MAX_VALUE;
        while (j <= n - 2) {
            while (j <= n - 2 && nums[j] == nums[i]) {
                j++;
            }
            if (i == 1 && nums[i] == nums[0])
                ans = Math.min(ans, ((long) (n - j) * nums[i]));
            else if (j == n - 1 && nums[j] == nums[i])
                ans = Math.min(ans, ((long) i * nums[i]));
            else
                ans = Math.min(ans, ((long) i * nums[i]) + ((long) (n - j) * nums[i]));
            i = j;
        }
        return ans;
    }
}