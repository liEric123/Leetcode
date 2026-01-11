#include <iostream>
#include <string>
#include <vector>
#include <climits>
#include <cctype>
using namespace std;
class Solution {
public:
    int myAtoi(string s) {
        // Time Complexity: O(N^2) because I used .erase() for every character.
        //                  To make O(N) don't use .erase(), use a pointer.
        // Space Complexity: O(N) for vector of digits.
        while (!s.empty())
        {
            if (s[0] == ' ')
            {
                s.erase(s.begin());
            }
            else
            {
                break;
            }
        }
        if (s.empty()) return 0;
        int mode = 1;
        if (s[0] == '-')
        {
            mode = 0;
            s.erase(s.begin());
        }
        else if (s[0] == '+')
        {
            s.erase(s.begin());
        }
        while (!s.empty())
        {
            if (s[0] == '0')
            {
                s.erase(s.begin());
            }
            else
            {
                break;
            }
        }
        vector<int> arr;
        while (!s.empty())
        {
            if (isdigit(s[0]))
            {
                arr.push_back(s[0] - '0');
                s.erase(s.begin());
            }
            else
            {
                break;
            }
        }
        long long ans = 0;
        if (arr.size() > 10)
        {
            if (mode == 0) return INT_MIN;
            return INT_MAX;
        }
        else if (arr.size() == 10)
        {
            long long full = 0;
            for (int i = 0; i < 10; i++)
            {
                full = full * 10 + arr[i];
            }
            if (mode == 0 && -full < INT_MIN) return INT_MIN;
            if (mode == 1 && full > INT_MAX) return INT_MAX;
            ans = full;
        }
        else
        {
            for (int i = 0; i < arr.size(); i++)
            {
                ans = ans * 10 + arr[i];
            }
        }

        if (mode == 0) ans *= -1;
        if (ans > INT_MAX) return INT_MAX;
        if (ans < INT_MIN) return INT_MIN;
        return ans;
    }
};

int main() {
    Solution sol;
    string input;
    cout << "Enter a string to convert to integer: ";
    getline(cin, input);
    int result = sol.myAtoi(input);
    cout << "Result: " << result << endl;
    return 0;
}