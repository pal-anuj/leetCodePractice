// Last updated: 14/09/2026, 23:32:23
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
13        if(head==null || head.next==null )
14            return head;
15        
16        ListNode newHead= reverseList(head.next);
17        head.next.next= head;
18        head.next=null;
19
20        return newHead;
21
22        // return reverse(head, null);
23       
24        // ListNode prev=null;
25        // while(head!=null ){
26        //     ListNode next= head.next;
27        //     head.next= prev;
28        //     prev= head;
29        //     head=next;
30        // }
31        // return prev;
32    }
33
34    private ListNode reverse(ListNode head, ListNode prev){
35        if(head==null)
36            return prev;
37        ListNode next= head.next;
38        head.next= prev;
39        prev= head;
40        head= next;
41        return reverse(head, prev);
42    }
43}