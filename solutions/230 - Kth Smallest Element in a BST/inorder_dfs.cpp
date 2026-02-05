#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <sstream>
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
    int kthSmallest(TreeNode* root, int k) {
        // Time Complexity: O(N) because we visit every node once to put it into the vector.
        // Space Complexity: O(N) for the in-order vector.
        vector<int> sorted;
        dfs(sorted, root);
        return sorted.at(k - 1);
    }
    void dfs(vector<int>& sorted, TreeNode* root)
    {
        if (root == nullptr)
        {
            return;
        }
        dfs(sorted, root->left);
        sorted.push_back(root->val);
        dfs(sorted, root->right);
        return;
    }
};

int main() {
    cout << "Enter tree values: " << endl;
    string line;
    getline(cin, line);

    cout << "Enter k: " << endl;
    int k;
    cin >> k;

    stringstream ss(line);
    vector<string> nodes;
    string token;
    while (ss >> token) {
        nodes.push_back(token);
    }

    if (nodes.empty() || nodes[0] == "null") {
        cout << "kth smallest element: -1" << endl;
        return 0;
    }

    TreeNode* root = new TreeNode(stoi(nodes[0]));
    queue<TreeNode*> q;
    q.push(root);

    int i = 1;
    while (!q.empty() && i < nodes.size()) {
        TreeNode* node = q.front();
        q.pop();

        if (i < nodes.size() && nodes[i] != "null") {
            node->left = new TreeNode(stoi(nodes[i]));
            q.push(node->left);
        }
        i++;

        if (i < nodes.size() && nodes[i] != "null") {
            node->right = new TreeNode(stoi(nodes[i]));
            q.push(node->right);
        }
        i++;
    }

    Solution sol;
    cout << "kth smallest element: " << sol.kthSmallest(root, k) << endl;

    return 0;
}