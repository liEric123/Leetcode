#include <iostream>
#include <vector>
#include <sstream>
using namespace std;
class Solution {
public:
    vector<int> getConcatenation(vector<int>& nums) {
        // Time Complexity: O(N) to build the answer array
        // Space Complexity: O(N) for answer array
        vector<int> newArr(nums.size() * 2);
        for (int i = 0; i < nums.size(); i++)
        {
            newArr[i] = nums[i];
        }
        for (int i = nums.size(); i < newArr.size(); i++)
        {
            newArr[i] = nums[i - nums.size()];
        }
        return newArr;
    }
};

int main() {
    cout << "Enter the elements of the array: " << endl;

    string line;
    getline(cin, line);

    stringstream ss(line);
    vector<int> nums;
    int x;

    while (ss >> x) {
        nums.push_back(x);
    }

    Solution solution;
    vector<int> result = solution.getConcatenation(nums);

    cout << "Concatenated array:" << endl;
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << " ";
    }
    cout << endl;

    return 0;
}