// Last updated: 20/08/2026, 00:46:32
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
12    public void reorderList(ListNode head) {
13
14        if (head == null || head.next == null)
15            return;
16
17        // Find the middle of the list
18        ListNode p1 = head;
19        ListNode p2 = head;
20        while (p2.next != null && p2.next.next != null) {
21            p1 = p1.next;
22            p2 = p2.next.next;
23        }
24
25        // reverse the half after middle
26        ListNode preMiddle = p1;
27        ListNode preCurrent = p1.next;
28        while (preCurrent.next != null) {
29            ListNode current = preCurrent.next;
30            preCurrent.next = current.next;
31            current.next = preMiddle.next;
32            preMiddle.next = current;
33        }
34
35        // start reordering
36        p1 = head;
37        p2 = preMiddle.next;
38        while (p1 != preMiddle) {
39            preMiddle.next = p2.next;
40            p2.next = p1.next;
41            p1.next = p2;
42            p1 = p2.next;
43            p2 = preMiddle.next;
44        }
45    }
46}