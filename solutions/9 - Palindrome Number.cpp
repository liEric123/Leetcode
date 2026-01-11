#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    bool isPalindrome(int x) {
        // Time Complexity: O(log(x)) because that is how many digits are in x and we build vector of digits.
        // Space Complexity: O(log(x)) because we store all digits.
        if (x < 0 || (x % 10 == 0 && x !=0))
        {
            return false;
        }
        vector<int> num;
        while (x > 0)
        {
            num.push_back(x % 10);
            x /= 10;
        }
        for (int i = 0; i < num.size(); i++)
        {
            if (num[i] != num[num.size() - i - 1])
            {
                return false;
            }
        }
        return true;
    }
};

int main() {
    Solution sol;
    int n;
    cout << "Enter an integer to check if it is a palindrome: ";
    cin >> n;
    
    if (sol.isPalindrome(n)) {
        cout << n << " is a palindrome." << endl;
    } else {
        cout << n << " is not a palindrome." << endl;
    }

    return 0;
}