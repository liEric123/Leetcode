#include <iostream>
#include <vector>
#include <string>
using namespace std;
class Solution {
public:
    int romanToInt(string s) {
        // Time Complexity: O(N) since we loop over each character in the string.
        // Space Complexity: O(1) since total space is independent of the string.
        vector<int> roman(26, 0);
        roman['I' - 'A'] = 1;
        roman['V' - 'A'] = 5;
        roman['X' - 'A'] = 10;
        roman['L' - 'A'] = 50;
        roman['C' - 'A'] = 100;
        roman['D' - 'A'] = 500;
        roman['M' - 'A'] = 1000;

        int ans = 0;
        for (int i = 0; i < s.size(); ++i)
        {
            int current = roman[s[i] - 'A'];
            int next = 0;
            if (i + 1 < s.size())
            {
                next = roman[s[i + 1] - 'A'];
            }

            if (current < next)
            {
                ans -= current;
            }
            else
            {
                ans += current;
            }
        }
        return ans;
    }
};

int main() {
    Solution solution;
    string input;

    cout << "Enter a Roman numeral: ";
    cin >> input;

    cout << "Integer value: " << solution.romanToInt(input) << endl;

    return 0;
}