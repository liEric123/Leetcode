#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>
using namespace std;
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        // Time Complexity: Sorting takes O(NLog(N))
        //                  3Sum search takes O(N^2) since outer loop is O(N)
        //                  and inner while loop is O(N) so total time complexity is O(N^2)
        // Space Complexity: O(1) since just some pointers and sorting is done in place.
        sort(nums.begin(), nums.end());
        vector<vector<int>> answer;
        for (int i = 0; i < nums.size(); i++)
        {
            if (i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }
            int left = i + 1;
            int right = nums.size() - 1;
            while (left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0)
                {
                    left++;
                }
                else if (sum > 0)
                {
                    right --;
                }
                else
                {
                    answer.push_back({nums[i], nums[left], nums[right]});
                    while (left < right && nums[left] == nums[left + 1])
                    {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1])
                    {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return answer;
    }
};

int main() {
    cout << "Enter numbers separated by spaces:\n";

    string line;
    getline(cin, line);

    stringstream ss(line);
    vector<int> nums;
    int x;

    while (ss >> x) {
        nums.push_back(x);
    }

    Solution solution;
    vector<vector<int>> result = solution.threeSum(nums);

    if (result.empty()) {
        cout << "No triplets found that sum to zero.\n";
    } else {
        for (auto& t : result) {
            cout << "[" << t[0] << ", " << t[1] << ", " << t[2] << "]\n";
        }
    }

    return 0;
}