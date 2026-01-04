// Last updated: 04/01/2026, 12:03:02
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
13        
14        ListNode res = new ListNode(0);
15        ListNode tail = res;
16        int carry = 0;
17
18        while (l1 != null || l2 != null || carry != 0) {
19            int digit1 = (l1 != null) ? l1.val : 0;
20            int digit2 = (l2 != null) ? l2.val : 0;
21
22            int sum = digit1 + digit2 + carry;
23            int digit = sum % 10;
24            carry = sum / 10;
25
26            ListNode newNode = new ListNode(digit);
27            tail.next = newNode;
28            tail = tail.next;
29
30            l1 = (l1 != null) ? l1.next : null;
31            l2 = (l2 != null) ? l2.next : null;
32        }
33
34        return res.next;
35    }
36}