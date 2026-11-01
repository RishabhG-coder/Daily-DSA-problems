class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int t = -nums[i];
            HashSet<Integer> s = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = t - nums[j];
                if (s.contains(third)) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);
                    Collections.sort(temp);
                    set.add(temp);
                }
                s.add(nums[j]);
            }
        }
        return new ArrayList<>(set);
    }
}