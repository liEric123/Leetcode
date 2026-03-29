#include <iostream>
#include <sstream>
#include <string>
#include <vector>
using namespace std;
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
class Solution {
public:
    bool hasCycle(ListNode *head) {
        // Time Complexity: O(N) since traversing the list and cycle takes only O(N+K) ≈ O(N)
        // Space Complexity: O(1) since just use a few pointers
        if (head == nullptr || head->next == nullptr)
        {
            return false;
        }
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast != nullptr && fast->next != nullptr)
        {
            slow = slow->next;
            fast = fast->next->next;
            if (fast == nullptr)
            {
                return false;
            }
            if (slow == fast)
            {
                return true;
            }
        }
        return false;
    }
};

int main() {
    cout << "Enter the list: " << endl;
    string line;
    getline(cin, line);

    cout << "Enter the cycle position: " << endl;
    int pos;
    cin >> pos;

    vector<int> nums;
    stringstream ss(line);
    int x;
    while (ss >> x) {
        nums.push_back(x);
    }

    ListNode* head = nullptr;
    ListNode* tail = nullptr;
    ListNode* cycleNode = nullptr;

    for (int i = 0; i < (int)nums.size(); i++) {
        ListNode* node = new ListNode(nums[i]);
        if (head == nullptr) {
            head = node;
        } else {
            tail->next = node;
        }
        tail = node;
        if (i == pos) {
            cycleNode = node;
        }
    }

    if (tail != nullptr && pos >= 0 && pos < (int)nums.size()) {
        tail->next = cycleNode;
    }

    Solution sol;
    bool result = sol.hasCycle(head);

    cout << "Has cycle: " << endl;
    cout << (result ? "true" : "false") << endl;

    return 0;
}