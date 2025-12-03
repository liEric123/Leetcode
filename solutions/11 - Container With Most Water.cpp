#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int maxArea(vector<int>& height) {
        // Time Complexity: O(N) since we use two pointers and check each element once
        // Space Complexity: O(1) since we only use a few variables
        int areaMax = 0;
        int left = 0, right = height.size() - 1;
        while (left < right)
        {
            int currArea = min(height[left], height[right]) * (right - left);
            areaMax = max(areaMax, currArea);
            if (height[left] < height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return areaMax;
    }
};

int main() {
    Solution sol;
    cout << "Enter the elements of the height array separated by spaces: ";
    string line;
    getline(cin, line);
    stringstream ss(line);
    vector<int> height;
    int num;
    while (ss >> num) {
        height.push_back(num);
    }

    cout << "The maximum area is: " << sol.maxArea(height) << endl;

    return 0;
}