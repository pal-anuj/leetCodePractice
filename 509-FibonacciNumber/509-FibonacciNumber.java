// Last updated: 14/09/2026, 18:26:25
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
13        return reverse(head, null);
14       
15        // ListNode prev=null;
16        // while(head!=null ){
17        //     ListNode next= head.next;
18        //     head.next= prev;
19        //     prev= head;
20        //     head=next;
21        // }
22        // return prev;
23    }
24
25    private ListNode reverse(ListNode head, ListNode prev){
26        if(head==null)
27            return prev;
28        ListNode next= head.next;
29        head.next= prev;
30        prev= head;
31        head= next;
32        return reverse(head, prev);
33    }
34}