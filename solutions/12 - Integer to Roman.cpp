#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    string intToRoman(int num) {
        // Time Complexity: O(1) since all operations are instant.
        // Space Complexity: O(1) because total space is independent of num.
        
        // 0xxx, 1xxx, 2xxx, 3xxx
        vector<string> thousand{"", "M", "MM", "MMM"};
        // x0xx, x1xx, x2xx, x3xx, x4xx, x5xx, x6xx, x7xx, x8xx, x9xx
        vector<string> hundreds{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        // xx0x, xx1x, xx2x, xx3x, xx4x, xx5x, xx6x, xx7x, xx8x, xx9x
        vector<string> tens{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        // xxx0, xxx1, xxx2, xxx3, xxx4, xxx5, xxx6, xxx7, xxx8, xxx9
        vector<string> ones{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousand[num / 1000] + hundreds[num / 100 % 10] + tens[num / 10 % 10] + ones[num % 10];
    }
};

int main() {
    Solution sol;
    int num;
    cout << "Enter an integer between 1 and 3999: ";
    cin >> num;
    
    if(num < 1 || num > 3999) {
        cout << "Invalid input. Number must be between 1 and 3999." << endl;
        return 0;
    }

    string roman = sol.intToRoman(num);
    cout << "Roman numeral: " << roman << endl;
    
    return 0;
}