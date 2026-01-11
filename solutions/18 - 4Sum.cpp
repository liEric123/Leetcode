#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>
using namespace std;
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        // Time Complexity: O(N^3) because sorting takes NlogN, there are two outer loops,
        //                  and one inner two-pointer search, so total N^3.
        // Space Complexity: O(1) since just some pointers and sorting is done in place.
        if (nums.size() < 4)
        {
            return {};
        }
        sort(nums.begin(), nums.end());
        vector<vector<int>> v;

        for (int i = 0; i < nums.size() - 3; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }
            for (int j = i + 1; j < nums.size() - 2; j++)
            {
                if (j > i + 1 && nums[j] == nums[j - 1])
                {
                    continue;
                }

                int l = j + 1, r = nums.size() - 1;
                while (l < r) {
                    long long sum = (long long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target)
                    {
                        v.push_back({nums[i], nums[j], nums[l], nums[r]});
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                    else if (sum < target)
                    {
                        l++;
                    }
                    else
                    {
                        r--;
                    }
                }
            }
        }

        return v;
    }
};

int main() {
    cout << "Enter the array of numbers: ";
    string line;
    getline(cin, line);
    stringstream ss(line);
    vector<int> nums;
    int x;
    while (ss >> x) nums.push_back(x);

    cout << "Enter the target value: ";
    int target;
    cin >> target;

    Solution s;
    vector<vector<int>> result = s.fourSum(nums, target);

    if (result.empty()) {
        cout << "No quadruplets found that sum to the target.\n";
    } else {
        cout << "Quadruplets:\n";
        for (auto& quad : result) {
            cout << "[";
            for (int i = 0; i < 4; i++) {
                cout << quad[i];
                if (i < 3) cout << ", ";
            }
            cout << "]\n";
        }
    }

    return 0;
}