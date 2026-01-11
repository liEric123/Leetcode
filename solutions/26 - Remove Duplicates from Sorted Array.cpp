#include <iostream>
#include <vector>
#include <string>
#include <sstream>
using namespace std;
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        // Time Complexity: O(N) because we loop over the array to find how many unique elements and
        //                  to remove duplicates and shift the numbers down.
        // Space Complexity: O(1) because we modify the vector in place and just use a few variables.
        int uniq = 1;
        for (int i = 1; i < nums.size(); i++)
        {
            if (nums[i] != nums[i - 1])
            {
                uniq++;
            }
        }
        int idx = 1;
        for (int i = 1; i < nums.size(); i++)
        {
            if (nums[i] != nums[i - 1])
            {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return uniq;
    }
};

int main() {
    cout << "Enter integers for the vector: ";
    string line;
    getline(cin, line);
    istringstream iss(line);

    vector<int> nums;
    int num;
    while (iss >> num) {
        nums.push_back(num);
    }

    Solution sol;
    int uniqCount = sol.removeDuplicates(nums);

    cout << "Number of unique elements: " << uniqCount << endl;
    cout << "Array after removing duplicates: ";
    for (int i = 0; i < uniqCount; i++) {
        cout << nums[i] << " ";
    }
    cout << endl;

    return 0;
}