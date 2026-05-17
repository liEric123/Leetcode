#include <iostream>
#include <vector>
#include <sstream>
using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        // Time Complexity: O(LogN) since we can safely halve the search space every iteration.
        // Space Complexity: O(1) for a few variables.
        if (nums.size() == 1) {
            return 0;
        }

        int l = 0;
        int r = nums.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m - 1 >= 0 && m + 1 <= nums.size() - 1 && nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) {
                return m;
            }
            if (m == 0 && m + 1 <= nums.size() - 1 && nums[m] > nums[m + 1]) {
                return m;
            }
            if (m == nums.size() - 1 && m - 1 >= 0 && nums[m] > nums[m - 1]) {
                return m;
            }
            if (m - 1 >= 0 && nums[m - 1] > nums[m]) {
                r = m - 1;
            } else if (m + 1 <= nums.size() - 1 && nums[m + 1] > nums[m]) {
                l = m + 1;
            }
        }
        return l;
    }
};

int main() {
    cout << "Enter nums: " << endl;
    string line;
    getline(cin, line);

    stringstream ss(line);
    vector<int> nums;
    int x;

    while (ss >> x) {
        nums.push_back(x);
    }

    Solution sol;

    cout << "Peak index: " << endl;
    cout << sol.findPeakElement(nums) << endl;

    return 0;
}