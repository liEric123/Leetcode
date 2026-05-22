#include <iostream>
#include <vector>
#include <sstream>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        // Time Complexity: O(LogN) to binary search.
        // Space Complexity: O(1) for a few variables.
        int low = 0, high = nums.size() - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
            {
                return mid;
            }
            // left half sorted
            if (nums[low] <= nums[mid])
            {
                if (target < nums[mid] && target >= nums[low])
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            // right half sorted
            else
            {
                if (target > nums[mid] && target <= nums[high])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }
};

int main() {
    Solution sol;
    vector<int> nums;
    string line;
    int target;

    cout << "Enter nums: " << endl;
    getline(cin, line);

    stringstream ss(line);
    int x;
    while (ss >> x) {
        nums.push_back(x);
    }

    cout << "Enter target: " << endl;
    cin >> target;

    int result = sol.search(nums, target);

    cout << "Index:" << endl;
    cout << result << endl;

    return 0;
}