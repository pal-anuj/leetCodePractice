// Last updated: 21/08/2026, 00:27:58
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
13        ListNode l3 = new ListNode(0);
14        ListNode dummy = l3;
15
16        int carry = 0;
17        while (l1 != null && l2 != null) {
18            int num = l1.val + l2.val + carry;
19            if (num > 9) {
20                carry = num / 10;
21                num = num % 10;
22            } else {
23                carry = 0;
24            }
25            dummy.next = new ListNode(num);
26            dummy = dummy.next;
27            l1 = l1.next;
28            l2 = l2.next;
29        }
30
31        while (l1 != null) {
32            int num = l1.val + carry;
33            if (num > 9) {
34                carry = num / 10;
35                num = num % 10;
36            } else {
37                carry = 0;
38            }
39            dummy.next = new ListNode(num);
40            dummy = dummy.next;
41            l1 = l1.next;
42        }
43        while (l2 != null) {
44            int num = l2.val + carry;
45            if (num > 9) {
46                carry = num / 10;
47                num = num % 10;
48            } else {
49                carry = 0;
50            }
51            dummy.next = new ListNode(num);
52            dummy = dummy.next;
53            l2 = l2.next;
54        }
55
56        if (carry != 0) {
57            dummy.next = new ListNode(carry);
58            dummy = dummy.next;
59        }
60        return l3.next;
61    }
62}