// Last updated: 04/01/2026, 00:03:25
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
12    public ListNode removeNthFromEnd(ListNode head, int n) {
13        if(head==null) return null;  
14
15        // Dummy node to handle head removal
16        ListNode dummy = new ListNode(0);
17        dummy.next = head;
18
19        ListNode firstHead= dummy;
20        ListNode secondHead= dummy;
21
22        for(int i=0;i<n; i++){
23            firstHead= firstHead.next;
24        }
25
26        while(firstHead.next!=null)
27        {
28            firstHead= firstHead.next;
29            secondHead= secondHead.next;
30        }
31
32        secondHead.next= secondHead.next.next;
33
34        return dummy.next;
35    }
36
37}