#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    string convert(string s, int numRows) {
        // Time Complexity: O(N) because we loop over all characters to compute numCols.
        //                  To build the matrix, we loop over all characters again.
        // Space Complexity: O(N) to store the N characters in our matrix.
        if (numRows == 1 || s.size() <= numRows)
        {
            return s;
        }
        int lettersLeft = s.size();
        int numCols = 0;

        while (lettersLeft > 0)
        {
            if (lettersLeft - numRows <= 0)
            {
                numCols++;
                break;
            }
            else
            {
                lettersLeft -= numRows;
                numCols++;
            }
            for (int i = 0; i < numRows - 2; i++)
            {
                if (lettersLeft - 1 <= 0)
                {
                    numCols++;
                    break;
                }
                else
                {
                    lettersLeft--;
                    numCols++;
                }
            }
        }

        lettersLeft = s.size();
        vector<vector<char>> matrix(numRows, vector<char>(numCols, '\0'));

        int r = 0;
        int c = 0;
        int mode = 0; // mode = 0: down, mode = 1: diagonal up
        int idx = 0;  // index for s

        while (idx < s.size())
        {
            matrix[r][c] = s[idx++];
            if (mode == 0)
            {
                if (r == numRows - 1)
                {
                    mode = 1;
                    r--;
                    c++;
                }
                else
                {
                    r++;
                }
            }
            else
            {
                if (r == 0)
                {
                    mode = 0;
                    r++;
                }
                else
                {
                    r--;
                    c++;
                }
            }
        }

        string ans = "";
        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++)
            {
                if (matrix[i][j] != '\0')
                {
                    ans += matrix[i][j];
                }
            }
        }

        return ans;
    }
};

int main() {
    Solution sol;
    string s;
    int numRows;

    cout << "Enter the string: ";
    getline(cin, s);

    cout << "Enter the number of rows: ";
    cin >> numRows;

    string result = sol.convert(s, numRows);

    cout << "Converted string: " << result << endl;

    return 0;
}