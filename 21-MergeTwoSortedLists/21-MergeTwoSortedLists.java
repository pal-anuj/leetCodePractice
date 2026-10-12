// Last updated: 12/10/2026, 23:10:16
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
12    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
13        ListNode l1 = list1;
14        ListNode l2 = list2;
15        ListNode newH = new ListNode(0);
16        ListNode cur = newH;
17        while (l1 != null && l2 != null) {
18            if (l1.val > l2.val) {
19                cur.next = l2;
20                l2 = l2.next;
21                cur = cur.next;
22            } else if (l1.val < l2.val) {
23                cur.next = l1;
24                l1 = l1.next;
25                cur = cur.next;
26            } else {
27                cur.next = l1;
28                l1 = l1.next;
29                cur=cur.next;
30            }
31        }
32
33        if (l1 != null) {
34            cur.next = l1;
35        }
36
37        if (l2 != null) {
38            cur.next = l2;
39        }
40        return newH.next;
41    }
42}