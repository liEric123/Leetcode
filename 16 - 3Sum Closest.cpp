#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        // Time Complexity: Sorting takes O(NLog(N)).
        //                  Search takes O(N^2) since outer loop is O(N)
        //                  and inner while loop is O(N) so total time complexity is O(N^2).
        // Space Complexity: O(1) since just some pointers and sorting is done in place.
        int closest = INT_MAX;
        int ans;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size() - 2; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }
            int l = i + 1, r = nums.size() - 1;
            while (l < r)
            {
                int num = nums[i] + nums[l] + nums[r];
                if (abs(num - target) < closest)
                {
                    closest = abs(num - target);
                    ans = num;
                }
                if (nums[i] + nums[l] + nums[r] == target)
                {
                    return target;
                }
                else if (nums[i] + nums[l] + nums[r] < target)
                {
                    l++;
                }
                else
                {
                    r--;
                }
            }
        }
        return ans;
    }
};

int main() {
    cout << "Enter numbers for the array: ";
    string line;
    getline(cin, line);

    vector<int> nums;
    stringstream ss(line);
    int val;
    while (ss >> val) nums.push_back(val);

    cout << "Enter the target number: ";
    int target;
    cin >> target;

    Solution s;
    int result = s.threeSumClosest(nums, target);

    cout << "Closest sum = " << result << endl;

    return 0;
}