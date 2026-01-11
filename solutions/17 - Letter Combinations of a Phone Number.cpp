#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
using namespace std;
class Solution {
public:
    vector<string> letterCombinations(string digits) {
        // Time Complexity: O(4^N) worst case because 8 and 9 have 4 letters each
        //                  and adding a digit multiplies total combinations by 4.
        // Space Complexity: O(N * 4^N) for 4^N strings of length N.
        if (digits.empty())
        {
            return {};
        }
        unordered_map<char, string> mymap = {{'2', "abc"}, {'3', "def"}, {'4', "ghi"}, {'5', "jkl"}, {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}};

        vector<string> result = {""};
        for (int i = 0; i < digits.size(); i++)
        {
            char digit = digits[i];
            vector<string> temp;

            for (int j = 0; j < result.size(); j++)
            {
                string combination = result[j];
                string letters = mymap[digit];

                for (int k = 0; k < letters.size(); k++)
                {
                    temp.push_back(combination + letters[k]);
                }
            }
            result = temp;
        }
        return result;
    }
};

int main() {
    cout << "Enter a string of digits (2-9):\n";
    string digits;
    cin >> digits;

    Solution solution;
    vector<string> combinations = solution.letterCombinations(digits);

    if (combinations.empty()) {
        cout << "No combinations available.\n";
    } else {
        cout << "Letter combinations:\n";
        for (const string& s : combinations) {
            cout << s << " ";
        }
        cout << endl;
    }

    return 0;
}