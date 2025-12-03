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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        // Time Complexity: O(NlogK) because we push will push a total of N nodes onto the heap.
        //                  For each node, we pop and push its next node onto the heap which is O(logK).
        // Space Complexity: O(K) because there are K linked-lists, resulting in K nodes in the priority queue.
        auto comp = [](ListNode* a, ListNode* b) { return a->val > b->val; };
        priority_queue<ListNode*, vector<ListNode*>, decltype(comp)> pq(comp);
        for (ListNode* n : lists)
        {
            if (n != nullptr)
            {
                pq.push(n);
            }
        }
        ListNode* head = nullptr;
        ListNode* tail = nullptr;
        while (!pq.empty())
        {
            ListNode* curr = pq.top();
            pq.pop();
            if (head == nullptr)
            {
                head = curr;
                tail = curr;
            }
            else
            {
                tail->next = curr;
                tail = curr;
            }
            if (curr->next != nullptr)
            {
                pq.push(curr->next);
            }
        }
        return head;
    }
};

int main() {
    cout << "How many lists? ";

    string line;
    getline(cin, line);
    int k = stoi(line);

    vector<ListNode*> lists;
    cout << "Enter each list on its own line:\n";

    for (int i = 0; i < k; i++) {
        getline(cin, line);

        stringstream ss(line);
        int x;

        ListNode* head = nullptr;
        ListNode* tail = nullptr;

        while (ss >> x) {
            ListNode* node = new ListNode(x);
            if (!head)
                head = tail = node;
            else
                tail->next = node, tail = node;
        }

        lists.push_back(head);
    }

    Solution sol;
    ListNode* res = sol.mergeKLists(lists);

    cout << "Merged Output: ";
    while (res) {
        cout << res->val << " ";
        res = res->next;
    }
    cout << "\n";

    return 0;
}