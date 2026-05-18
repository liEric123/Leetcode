#include <iostream>
#include <vector>
#include <sstream>
#include <climits>
using namespace std;

class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        // Time Complexity: O(LogN) to binary search on the answer.
        // Space Complexity: O(1) for a few variables.
        int l = 1;
        int r = INT_MAX;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int tot_hours = 0;

            for (int i = 0; i < piles.size(); i++) {
                tot_hours += (piles[i] + m - 1) / m;
            }

            if (tot_hours <= h) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return l;
    }
};

int main() {
    cout << "Enter piles: " << endl;
    string line;
    getline(cin, line);

    stringstream ss(line);
    vector<int> piles;
    int x;

    while (ss >> x) {
        piles.push_back(x);
    }

    cout << "Enter h: " << endl;
    int h;
    cin >> h;

    Solution sol;

    cout << "Minimum eating speed: " << endl;
    cout << sol.minEatingSpeed(piles, h) << endl;

    return 0;
}