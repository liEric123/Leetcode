#include <iostream>
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
    vector<vector<int>> levelOrder(TreeNode* root) {
        // Time Complexity: O(N) because we need to process each node
        // Space Complexity: O(N) for the answer and queue
        vector<vector<int>> ans;
        if (root == nullptr)
        {
            return ans;
        }
        queue<TreeNode*> q;
        q.push(root);
        while (!q.empty())
        {
            int qSize = q.size();
            vector<int> vec;
            for (int i = 0; i < qSize; i++)
            {
                TreeNode* node = q.front();
                q.pop();
                vec.push_back(node->val);
                if (node->left != nullptr)
                {
                    q.push(node->left);
                }
                if (node->right != nullptr)
                {
                    q.push(node->right);
                }
            }
            ans.push_back(vec);
        }
        return ans;
    }
};

int main() {
    Solution sol;

    cout << "Enter the tree: ";
    string line;
    getline(cin, line);

    if (line.empty() || line == "[]") {
        cout << "Output:\n[]\n";
        return 0;
    }

    stringstream ss(line);
    vector<string> nodes;
    string tok;

    while (ss >> tok) nodes.push_back(tok);
    if (nodes.empty() || nodes[0] == "null") {
        cout << "Output:\n[]\n";
        return 0;
    }

    TreeNode* root = new TreeNode(stoi(nodes[0]));
    queue<TreeNode*> q;
    q.push(root);

    int i = 1;
    while (!q.empty() && i < nodes.size()) {
        TreeNode* cur = q.front();
        q.pop();

        if (i < nodes.size() && nodes[i] != "null") {
            cur->left = new TreeNode(stoi(nodes[i]));
            q.push(cur->left);
        }
        i++;

        if (i < nodes.size() && nodes[i] != "null") {
            cur->right = new TreeNode(stoi(nodes[i]));
            q.push(cur->right);
        }
        i++;
    }

    vector<vector<int>> res = sol.levelOrder(root);

    cout << "Output:\n";
    for (auto& level : res) {
        for (int v : level) cout << v << " ";
        cout << "\n";
    }

    return 0;
}