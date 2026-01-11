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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        // Time Complexity: O(M + N) because we have to go through both lists worst case.
        // Space Complexity: O(1) because just a few pointers.
        ListNode* it1 = list1;
        ListNode* it2 = list2;
        ListNode dummy(0);
        ListNode* ans = &dummy;
        while (it1 != nullptr && it2 != nullptr)
        {
            if (it1->val <= it2->val)
            {
                ans->next = it1;
                it1 = it1->next;
                ans = ans->next;
            }
            else
            {
                ans->next = it2;
                it2 = it2->next;
                ans = ans->next;
            }
        }
        if (it1 != nullptr)
        {
            ans->next = it1;
        }
        else
        {
            ans->next = it2;
        }
        return dummy.next;
    }
};

int main() {
    cout << "Enter first sorted list elements separated by spaces:\n";
    string line1;
    getline(cin, line1);
    stringstream ss1(line1);
    ListNode* list1 = nullptr;
    ListNode* tail1 = nullptr;
    int val;
    while (ss1 >> val) {
        ListNode* node = new ListNode(val);
        if (!list1) {
            list1 = node;
            tail1 = node;
        } else {
            tail1->next = node;
            tail1 = node;
        }
    }

    cout << "Enter second sorted list elements separated by spaces:\n";
    string line2;
    getline(cin, line2);
    stringstream ss2(line2);
    ListNode* list2 = nullptr;
    ListNode* tail2 = nullptr;
    while (ss2 >> val) {
        ListNode* node = new ListNode(val);
        if (!list2) {
            list2 = node;
            tail2 = node;
        } else {
            tail2->next = node;
            tail2 = node;
        }
    }

    Solution sol;
    ListNode* merged = sol.mergeTwoLists(list1, list2);

    cout << "Merged list: ";
    while (merged) {
        cout << merged->val;
        if (merged->next) cout << " -> ";
        merged = merged->next;
    }
    cout << endl;

    return 0;
}