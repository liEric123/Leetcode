#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>
using namespace std;
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        // Time Complexity: O(Nlog(N)) for sorting algorithm
        // Space Complexity: O(log(N)) for sorting algorithm
        sort(strs.begin(), strs.end());
        int idx = 0;
        while (idx < strs.at(0).size() && idx < strs.at(strs.size() - 1).size())
        {
            if (strs.at(0)[idx] != strs.at(strs.size() - 1)[idx])
            {
                break;
            }
            idx++;
        }
        return strs.at(0).substr(0, idx);
    }
};


int main() {
    Solution solution;
    vector<string> strs;
    cout << "Enter strings separated by spaces: ";
    string line;
    getline(cin, line);
    stringstream ss(line);
    string word;
    while (ss >> word) {
        strs.push_back(word);
    }
    cout << "Longest common prefix: " << solution.longestCommonPrefix(strs) << endl;
    return 0;
}