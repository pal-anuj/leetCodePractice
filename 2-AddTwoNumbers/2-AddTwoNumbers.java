// Last updated: 06/06/2026, 23:26:31
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
13        int carry = 0;
14
15        ListNode res = new ListNode();
16        ListNode cur = res;
17        while (l1 != null && l2 != null) {
18            int num = l1.val + l2.val + carry;
19
20            if (num >= 10) {
21                carry = num / 10;
22                num %= 10;
23                System.out.println(carry);
24
25            } 
26            else
27                carry = 0;
28            cur.next = new ListNode(num);
29            l1 = l1.next;
30            l2 = l2.next;
31            cur = cur.next;
32        }
33
34        while (l1 != null) {
35            int num = l1.val + carry;
36            if (num >= 10) {
37                carry = num / 10;
38                num %= 10;
39            } else
40                carry = 0;
41            cur.next = new ListNode(num);
42            l1 = l1.next;
43            cur = cur.next;
44        }
45        while (l2 != null) {
46            int num = l2.val + carry;
47            if (num >= 10) {
48                carry = num / 10;
49                num %= 10;
50            } else
51                carry = 0;
52            cur.next = new ListNode(num);
53            l2 = l2.next;
54            cur = cur.next;
55        }
56
57        if (carry != 0)
58            cur.next = new ListNode(carry);
59
60        return res.next;
61    }
62}