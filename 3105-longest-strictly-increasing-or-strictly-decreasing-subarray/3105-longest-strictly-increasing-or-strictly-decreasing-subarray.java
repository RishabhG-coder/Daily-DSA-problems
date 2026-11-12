class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 1;
        int mx = Integer.MIN_VALUE;
        while (j < n) {
            while (j < n && nums[j] > nums[j - 1]) {
                mx = Math.max(mx, j - i + 1);
                j++;
            }
            if (j >= n)
                break;
            i = j;
            j++;
        }
        mx = Math.max(mx, j - i);
        i = 0;
        j = 1;
        int mn = Integer.MIN_VALUE;
        while (j < n) {
            while (j < n && nums[j] < nums[j - 1]) {
                mn = Math.max(mn, j - i + 1);
                j++;
            }
            if (j >= n)
                break;
            i = j;
            j++;
        }
        mn = Math.max(mn, j - i);
        System.out.print(mx + " " + mn);
        return Math.max(mx, mn);
    }
}