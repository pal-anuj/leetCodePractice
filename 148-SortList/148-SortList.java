// Last updated: 14/02/2026, 06:32:29
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode sortList(ListNode head) {
13        if (head == null || head.next == null)
14            return head;
15
16        // Step 1: Find mid
17        ListNode mid = getMid(head);
18        ListNode rightHead = mid.next;
19        mid.next = null; // break the List very important
20
21        // Step 2. Recusilvely sort both halves
22        ListNode leftSorted = sortList(head);
23        ListNode rightSorted = sortList(rightHead);
24
25        // Step 3. Merge sorted halves
26        return merge(leftSorted, rightSorted);
27    }
28
29    private ListNode merge(ListNode l1, ListNode l2) {
30        ListNode newHead = new ListNode(0);
31        ListNode temp = newHead;
32
33        while (l1 != null && l2 != null) {
34            if (l1.val < l2.val) {
35                temp.next = l1;
36                l1 = l1.next;
37            } else {
38                temp.next = l2;
39                l2 = l2.next;
40            }
41            temp = temp.next;
42        }
43
44        if (l1 != null)
45            temp.next = l1;
46        if (l2 != null)
47            temp.next = l2;
48
49        return newHead.next;
50    }
51
52    private ListNode getMid(ListNode node) {
53        ListNode fast = node.next;
54        ListNode slow = node;
55
56        while (fast != null && fast.next != null) {
57            fast = fast.next.next;
58            slow = slow.next;
59        }
60        return slow;
61    }
62}