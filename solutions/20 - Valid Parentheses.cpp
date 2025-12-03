#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    bool isValid(string s) {
        // Time Complexity: O(N) since we process each character only once
        // Space Complexity: O(N) in worst case (all opening brackets on stack)
        stack<char> stac;
        for (int i = 0; i < s.size(); i++)
        {
            if (s[i] == '(' || s[i] == '{' || s[i] == '[')
            {
                stac.push(s[i]);
            }
            else
            {
                if (stac.empty())
                {
                    return false;
                }
                char correspond = stac.top();
                stac.pop();
                if ((correspond == '(' && s[i] != ')') || (correspond == '{' && s[i] != '}') || (correspond == '[' && s[i] != ']'))
                {
                    return false;
                }
            }
        }
        if (stac.empty())
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
};

int main() {
    cout << "Enter a string of brackets to check: ";
    string s;
    getline(cin, s);

    Solution sol;
    bool valid = sol.isValid(s);

    if (valid) {
        cout << "The string is valid." << endl;
    } else {
        cout << "The string is NOT valid." << endl;
    }

    return 0;
}