#include <iostream>
#include <vector>
#include <unordered_set>
#include <sstream>
using namespace std;
class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        // Time Complexity: O(N) to build the hash set.
        // Space Complexity: O(N) for the hash set.
        unordered_set<int> hashSet;
        for (int i : nums)
        {
            hashSet.insert(i);
        }
        return hashSet.size() != nums.size();
    }
};

int main() {
    cout << "Enter array elements: ";
    string line;
    getline(cin, line);

    stringstream ss(line);
    vector<int> nums;
    int x;
    while (ss >> x) {
        nums.push_back(x);
    }

    Solution solution;
    bool result = solution.containsDuplicate(nums);

    cout << "Contains duplicate? " << (result ? "True" : "False") << endl;

    return 0;
}