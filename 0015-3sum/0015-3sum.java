class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        HashSet<List<Integer>> st = new HashSet<>();
        for (int i = 0; i <= n - 3; i++) {
            while (i >= 1 && a[i] == a[i - 1]) {
                i++;
                break;
            }
            int j = i + 1;
            int k = n - 1;
            int t = -a[i];
            while (j < k) {
                if (a[j] + a[k] == t) {
                    ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(a[i], a[j], a[k]));
                    if (!st.contains(temp)) {
                        st.add(temp);
                    }
                    j++;
                    k--;
                } else if (a[j] + a[k] > t) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(st);
    }
}