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
class Solution {
public:
    struct ListNode {
        int val;
        ListNode *next;
        ListNode() : val(0), next(nullptr) {}
        ListNode(int x) : val(x), next(nullptr) {}
        ListNode(int x, ListNode *next) : val(x), next(next) {}
    };

    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* point1 = l1;
        ListNode* point2 = l2;

        ListNode* head = nullptr;
        ListNode* current = nullptr;
        int carry = 0;
        int v1,v2;
        while (point1 != nullptr || point2 != nullptr || carry != 0) {
            if (point1 != nullptr)
            {
                v1 = point1->val;
            }
            else
            {
                v1 = 0;
            }
            if (point2 != nullptr)
            {
                v2 = point2->val;
            }
            else
            {
                v2 = 0;
            }
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            int curr = sum % 10;

            ListNode* newNode = new ListNode(curr);

            if (head == nullptr) {
                head = newNode;
            }
            else {
                current->next = newNode;
            }
            current = newNode;

            if (point1 != nullptr) {
                point1 = point1->next;
            }
            if (point2 != nullptr) {
                point2 = point2->next;
            }
        }

        return head;
    }
};

int main() {
    Solution sol;

    int n, x;

    cout << "How many digits in list 1? ";
    cin >> n;

    Solution::ListNode* l1 = nullptr;
    Solution::ListNode* t1 = nullptr;

    cout << "Enter digits of list 1: ";
    for (int i = 0; i < n; i++) {
        cin >> x;
        Solution::ListNode* node = new Solution::ListNode(x);
        if (!l1) l1 = node;
        else t1->next = node;
        t1 = node;
    }

    cout << "How many digits in list 2? ";
    cin >> n;

    Solution::ListNode* l2 = nullptr;
    Solution::ListNode* t2 = nullptr;

    cout << "Enter digits of list 2: ";
    for (int i = 0; i < n; i++) {
        cin >> x;
        Solution::ListNode* node = new Solution::ListNode(x);
        if (!l2) l2 = node;
        else t2->next = node;
        t2 = node;
    }

    Solution::ListNode* r = sol.addTwoNumbers(l1, l2);

    cout << "Result: ";
    while (r) {
        cout << r->val << " ";
        r = r->next;
    }
    cout << endl;

    return 0;
}