class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int cnt = 0;
        unordered_map<char, int> um;
        int n = s.size();
        int i = 0, j = 0;
        while (j < n) {
            um[s[j]]++;
            while (um[s[j]] > 1) {
                um[s[i]]--;
                if (um[s[i]] == 0) {
                    um.erase(s[i]);
                }
                i++;
            }
            cnt = max(cnt, (int)um.size());
            j++;
        }
        return cnt;
    }
};