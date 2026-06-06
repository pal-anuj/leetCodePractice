// Last updated: 06/06/2026, 23:33:54
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
12    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
13        ListNode res = new ListNode(0);
14        ListNode cur = res;
15        int carry = 0;
16        while (l1 != null || l2 != null || carry != 0) {
17            int digit1 = (l1 != null) ? l1.val : 0;
18            int digit2 = (l2 != null) ? l2.val : 0;
19
20            int sum = digit1 + digit2 + carry;
21            int digit = sum % 10;
22            carry = sum / 10;
23
24            cur.next = new ListNode(digit);
25            cur = cur.next;
26
27            l1 = (l1 != null) ? l1.next : null;
28            l2 = (l2 != null) ? l2.next : null;
29        }
30
31        return res.next;
32    }
33}