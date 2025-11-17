class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        // hash map to store numbers and their corresponding indices
        // supports O(1) lookup time
        // one pass through all numbers so O(n) time complexity
        // hash map stores all numbers so O(n) space complexity
        unordered_map<int, int> map;
        for (int i = 0; i < nums.size(); i++)
        {
            // if found the two numbers that add up to target
            if (map.find(target - nums[i]) != map.end())
            {
                return {i, map[target - nums[i]]};
            }
            // if not found add to hash map
            map[nums[i]] = i;
        }
        // if no solution
        return {};
    }
};