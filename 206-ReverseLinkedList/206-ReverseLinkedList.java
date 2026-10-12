// Last updated: 12/10/2026, 23:20:55
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
12    public ListNode reverseList(ListNode head) {
13
14        // return reverse(head, null);
15
16        ListNode prev = null;
17        while (head != null) {
18            ListNode next = head.next;
19            head.next = prev;
20            prev = head;
21            head = next;
22        }
23        return prev;
24    }
25
26    private ListNode reverse(ListNode head, ListNode prev) {
27        if (head == null)
28            return prev;
29        ListNode next = head.next;
30        head.next = prev;
31        prev = head;
32        head = next;
33        return reverse(head, prev);
34    }
35}