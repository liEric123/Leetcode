#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        // Time Complexity: O(N) because we loop through the vector once.
        // Space Complexity: O(1) because we don't use any other data structure.
        int answer = 0;
        for (int i : nums) {
            answer = answer ^ i;
        }
        return answer;
    }
};

int main() {
    Solution sol;
    cout << "Enter array elements: ";
    vector<int> nums;
    int x;
    while (cin >> x) {
        nums.push_back(x);
        if (cin.peek() == '\n') break;
    }
    int result = sol.singleNumber(nums);
    cout << "Output: " << result << endl;
}