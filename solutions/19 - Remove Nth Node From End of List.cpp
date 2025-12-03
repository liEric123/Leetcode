#include <bits/stdc++.h>
using namespace std;
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        // Time Complexity: O(N) since it takes one pass to find target node to remove
        //                       here N is the number of nodes in list
        // Space Complexity: O(1) since just a few pointers
        ListNode* slow = head;
        ListNode* fast = head;
        while (n--)
        {
            fast = fast->next;
        }
        // we need to remove head of list
        if (fast == nullptr)
        {
            ListNode* newHead = head->next;
            return newHead;
        }
        while (fast->next != nullptr)
        {
            fast = fast->next;
            slow = slow->next;
        }
        slow->next = slow->next->next;
        return head;
    }
};

int main() {
    cout << "Enter linked list elements separated by spaces:\n";
    string line;
    getline(cin, line);
    stringstream ss(line);

    ListNode* head = nullptr;
    ListNode* tail = nullptr;
    int val;
    while (ss >> val) {
        ListNode* node = new ListNode(val);
        if (!head) {
            head = node;
            tail = node;
        } else {
            tail->next = node;
            tail = node;
        }
    }

    cout << "Enter n (node from end to remove):\n";
    int n;
    cin >> n;

    Solution sol;
    head = sol.removeNthFromEnd(head, n);

    cout << "Resulting list: ";
    while (head) {
        cout << head->val;
        if (head->next) cout << " -> ";
        head = head->next;
    }
    cout << endl;

    return 0;
}