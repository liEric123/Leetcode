#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    string longestPalindrome(string s) {
        // Time Complexity: O(N^2) because for every letter we try to build palindromes of even and odd length.
        // Space Complexity: O(1) because we only store pointers and constants.
        int lengthLong = 0;
        string longest = "";
    
        for (int i = 0; i < s.size(); i++)
        {
            int l, r;
            l = i, r = i;
            while (l >= 0 && r < s.size() && s[l] == s[r])
            {
                if (r - l + 1 > lengthLong)
                {
                    lengthLong = r - l + 1;
                    longest = s.substr(l, r - l + 1);
                }
                l--;
                r++;
            }
            l = i, r = i + 1;
            while (l >= 0 && r < s.size() && s[l] == s[r])
            {
                if (r - l + 1 > lengthLong)
                {
                    lengthLong = r - l + 1;
                    longest = s.substr(l, r - l + 1);
                }
                l--;
                r++;
            }
        }
        return longest;
    }
};

int main() {
    Solution sol;
    string input;
    
    cout << "Enter a string: ";
    while (getline(cin, input) && input != "exit") {
        cout << "Longest Palindromic Substring: " << sol.longestPalindrome(input) << endl;
        cout << "Enter another string: (exit to quit) ";
    }

    return 0;
}