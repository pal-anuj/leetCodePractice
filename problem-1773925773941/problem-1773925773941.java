// Last updated: 19/03/2026, 18:39:33
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
13        ListNode res = new ListNode();
14        ListNode tail = res;
15        int carry = 0;
16
17        while (l1 != null || l2 != null || carry != 0) {
18            int digit1 = l1 != null ? l1.val : 0;
19            int digit2 = l2 != null ? l2.val : 0;
20            int sum = digit1 + digit2 + carry;
21            int digit = sum % 10;
22            carry = sum / 10;
23
24            ListNode temp = new ListNode(digit);
25            tail.next = temp;
26            tail = tail.next;
27
28            l1 = l1 != null ? l1.next : null;
29            l2 = l2 != null ? l2.next : null;
30
31        }
32        return res.next;
33    }
34}