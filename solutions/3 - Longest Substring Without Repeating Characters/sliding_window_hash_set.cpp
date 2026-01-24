#include <iostream>
#include <string>
#include <unordered_set>
#include <algorithm>
using namespace std;
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        // Time Complexity: O(N) since with sliding window you'll process each character at
        //                       most twice
        // Space Complexity: O(N) because we use a hashset to store unique characters
        unordered_set<char> chars;
        int l = 0;
        int longest = 0;
        for (int r = 0; r < s.length(); r++)
        {
            while (chars.find(s[r]) != chars.end())
            {
                // found duplicate so remove first instance
                chars.erase(s[l]);
                l++;
            }
            chars.insert(s[r]);
            longest = max(longest, r - l + 1);
        }
        return longest;
    }
};

int main() {
    Solution sol;
    string s;

    cout << "Enter a string: \n";
    cin >> s;

    int result = sol.lengthOfLongestSubstring(s);

    cout << "Longest Substring Length: " << result << "\n";
    return 0;
}