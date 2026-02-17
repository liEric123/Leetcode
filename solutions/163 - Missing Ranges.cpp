#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

class Solution {
public:
    vector<vector<int>> findMissingRanges(vector<int>& nums, int lower, int upper) {
        // Time Complexity: O(N) to iterate through the array once.
        // Space Complexity: O(N) for output. O(1) for auxiliary space.
        int numsSize = nums.size();

        // Handle empty array case - entire range is missing
        if (numsSize == 0) {
            return {{lower, upper}};
        }

        vector<vector<int>> missingRanges;

        // Check if there's a gap between lower bound and first element
        if (nums[0] > lower) {
            missingRanges.push_back({lower, nums[0] - 1});
        }

        // Check for gaps between consecutive elements in the array
        for (int i = 1; i < numsSize; ++i) {
            // If difference between consecutive elements is greater than 1,
            // there's a gap
            if (nums[i] - nums[i - 1] > 1) {
                missingRanges.push_back({nums[i - 1] + 1, nums[i] - 1});
            }
        }

        // Check if there's a gap between last element and upper bound
        if (nums[numsSize - 1] < upper) {
            missingRanges.push_back({nums[numsSize - 1] + 1, upper});
        }

        return missingRanges;
    }
};

int main() {
    Solution sol;

    vector<int> nums;
    string line;

    cout << "Enter sorted elements: ";
    getline(cin, line);

    stringstream ss(line);
    int num;
    while (ss >> num) {
        nums.push_back(num);
    }

    int lower, upper;

    cout << "Enter lower bound: ";
    cin >> lower;

    cout << "Enter upper bound: ";
    cin >> upper;

    vector<vector<int>> result = sol.findMissingRanges(nums, lower, upper);

    if (result.empty()) {
        cout << "No missing ranges.\n";
    } else {
        cout << "\nMissing Ranges:\n";
        for (const auto& range : result) {
            cout << "[" << range[0] << ", " << range[1] << "]\n";
        }
    }

    return 0;
}