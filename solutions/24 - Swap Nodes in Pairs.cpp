#include <iostream>
#include <string>
#include <sstream>
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
    ListNode* swapPairs(ListNode* head) {
        // Time Complexity: O(N) because we only traverse the list once, swapping pairs.
        // Space Complexity: O(1) for a couple pointers.
        if (head == nullptr || head->next == nullptr)
        {
            return head;
        }
        
        ListNode* newHead = head->next;
        ListNode* dummy = head;
        ListNode* prev = nullptr;
        while (dummy != nullptr && dummy->next != nullptr)
        {
            ListNode* third = dummy->next->next;
            ListNode* second = dummy->next;
            second->next = dummy;
            dummy->next = third;
            if (prev == nullptr)
            {
                prev = dummy;
            }
            else
            {
                prev->next = second;
                prev = dummy;
            }
            dummy = third;
        }
        return newHead;
    }
};

int main() {
    cout << "Enter list elements (space-separated):\n";

    string line;
    getline(cin, line);

    stringstream ss(line);
    int x;

    ListNode* head = nullptr;
    ListNode* tail = nullptr;

    while (ss >> x) {
        ListNode* node = new ListNode(x);
        if (!head) head = tail = node;
        else tail->next = node, tail = node;
    }

    Solution sol;
    ListNode* res = sol.swapPairs(head);

    cout << "Output: ";
    while (res) {
        cout << res->val << " ";
        res = res->next;
    }
    cout << "\n";

    return 0;
}