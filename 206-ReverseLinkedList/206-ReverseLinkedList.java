// Last updated: 03/05/2026, 23:37:44
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
13        // base case
14        if(head == null || head.next == null)
15            return head;    
16
17        ListNode newHead= reverseList(head.next);
18        
19        head.next.next = head;
20        head.next = null;
21
22        return newHead;
23    }
24}