// Last updated: 25/03/2026, 23:58:47
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
14        List<Integer> ls = new ArrayList<>();
15        while (head != null) {
16            ls.add(head.val);
17            head = head.next;
18        }
19        Collections.reverse(ls);
20        ListNode newHead = new ListNode();
21        ListNode temp = newHead;
22        for (int num : ls) {
23            ListNode temp1 = new ListNode(num);
24            temp.next = temp1;
25            temp = temp.next;
26        }
27        return newHead.next;
28    }
29
30}