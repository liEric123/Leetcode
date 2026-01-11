#include <iostream>
#include <vector>
#include <string>
using namespace std;
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        // Time Complexity: O(4^N/√N) because the approximation for the Nth Catalan number is
        //                  O(4^N/N^(3/2)) and string concatenation is O(N) so overall it is
        //                  O(4^N/√N).
        // Space Complexity: O(N) for recursion stack.
        vector<string> ans;
        recurse(ans, 0, n, "");
        return ans;
    }
    void recurse(vector<string>& ans, int left, int totalLeft, string curr)
    {
        if (totalLeft == 0)
        {
            ans.push_back(curr);
            return;
        }
        if (left == 0)
        {
            curr += "(";
            recurse(ans, left + 1, totalLeft, curr);
        }
        else if (left == totalLeft)
        {
            curr += ")";
            recurse(ans, left - 1, totalLeft - 1, curr);
        }
        else
        {
            recurse(ans, left - 1, totalLeft - 1, curr + ")");
            recurse(ans, left + 1, totalLeft, curr + "(");
        }
        return;
    }
};

int main() {
    int n;
    cout << "Enter n: ";
    cin >> n;

    Solution sol;
    vector<string> result = sol.generateParenthesis(n);

    cout << "All valid parentheses combinations:\n";
    for (const string& s : result) {
        cout << s << "\n";
    }
    cout << "Total combinations: " << result.size() << endl;

    return 0;
}