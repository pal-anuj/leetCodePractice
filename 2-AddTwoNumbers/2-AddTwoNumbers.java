// Last updated: 12/10/2026, 23:48:16
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
13        int num1 = 0;
14        int num2 = 0;
15
16        ListNode newH = new ListNode(0);
17        ListNode cur = newH;
18        int carry = 0;
19        while (l1 != null || l2 != null || carry > 0) {
20            int sum = carry;
21            if (l2 != null && l1 != null) {
22                sum += l1.val + l2.val;
23                l1 = l1.next;
24                l2 = l2.next;
25            } else if (l1 != null) {
26                sum += l1.val;
27                l1 = l1.next;
28            } else if (l2 != null) {
29                sum += l2.val;
30                l2 = l2.next;
31            }
32            carry = 0;
33            if (sum >= 10) {
34                carry = sum / 10;
35                sum = sum % 10;
36            }
37            cur.next = new ListNode(sum);
38            cur = cur.next;
39        }
40
41        return newH.next;
42    }
43}