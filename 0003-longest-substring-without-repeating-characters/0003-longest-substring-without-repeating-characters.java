class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        int n = s.length();
        int cnt = 0;
        while (j < n) {
            char ch = s.charAt(j);
            if (!mp.containsKey(ch)) {
                mp.put(ch, 1);
                cnt = Math.max(cnt, j - i + 1);
                j++;
            } else {
                while (mp.containsKey(ch)) {
                    mp.remove(s.charAt(i));
                    i++;
                }
                mp.put(ch, 1);
                cnt = Math.max(cnt, j - i + 1);
                j++;
            }
        }
        cnt = Math.max(cnt, j - i);

        return cnt;
    }
}