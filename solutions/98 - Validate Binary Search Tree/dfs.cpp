#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        // Time Complexity: O(N) because we need to go through each node
        // Space Complexity: O(H) where H is the height of the tree for recursion stack
        return check(root, LONG_MIN, LONG_MAX);
    }
    bool check(TreeNode* root, long mini, long maxi)
    {
        if (root == nullptr)
        {
            return true;
        }
        if (root->val <= mini || root->val >= maxi)
        {
            return false;
        }
        return check(root->left, mini, root->val) && check(root->right, root->val, maxi);
    } 
};

int main() {
    cout << "Enter BST values: " << endl;

    string line;
    getline(cin, line);

    stringstream ss(line);
    vector<string> tokens;
    string tok;
    while (ss >> tok) tokens.push_back(tok);

    TreeNode* root = nullptr;

    if (!tokens.empty() && tokens[0] != "null") {
        root = new TreeNode(stoi(tokens[0]));
        queue<TreeNode*> q;
        q.push(root);

        size_t i = 1;
        while (!q.empty() && i < tokens.size()) {
            TreeNode* cur = q.front();
            q.pop();

            if (i < tokens.size() && tokens[i] != "null") {
                cur->left = new TreeNode(stoi(tokens[i]));
                q.push(cur->left);
            }
            i++;

            if (i < tokens.size() && tokens[i] != "null") {
                cur->right = new TreeNode(stoi(tokens[i]));
                q.push(cur->right);
            }
            i++;
        }
    }

    Solution sol;
    cout << "Is the tree a valid BST?: " << (sol.isValidBST(root) ? "true" : "false") << endl;

    return 0;
}