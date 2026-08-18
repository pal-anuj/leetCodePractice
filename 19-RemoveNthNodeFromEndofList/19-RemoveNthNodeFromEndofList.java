// Last updated: 18/08/2026, 09:56:11
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
15        ListNode dummy= new ListNode(0); // dummy node for head removal
16        dummy.next= head;
17
18        ListNode firstHead= dummy;
19        ListNode secondHead= dummy;
20
21        for(int i=0;i<n;i++){
22            firstHead= firstHead.next;
23        }
24        while(firstHead.next!=null){
25            firstHead= firstHead.next;
26            secondHead= secondHead.next;
27        }
28        secondHead.next= secondHead.next.next;
29        return dummy.next;
30    }
31}