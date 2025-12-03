#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int reverse(int x) {
        // Time Complexity: O(log(|x|)) because that is how many digits are in x, and we loop over each digit.
        // Space Complexity: O(1) for some constants.
        int ans = 0;
        while(x != 0)
        {
            int digit = x % 10;
            x /= 10;
            if (INT_MAX / 10 < ans || (INT_MAX / 10 == ans && digit > 7) )
            {
                return 0;
            }
            else if (INT_MIN / 10 > ans || (INT_MIN / 10 == ans && digit == -9))
            {
                return 0;
            }
            ans = ans * 10 + digit;
            
        }

        return ans;
    }
};

int main() {
    Solution s;
    cout << "Enter an integer to reverse: ";
    int x;
    cin >> x;
    int result = s.reverse(x);
    cout << "Reversed integer: " << result << endl;
    return 0;
}