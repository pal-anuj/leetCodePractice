// Last updated: 02/05/2026, 14:39:04
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
13        // Efficient approach    
14        ListNode prev=null;
15        ListNode curr=head;
16        while(curr!=null){
17            ListNode next= curr.next;
18            curr.next = prev;
19            prev= curr;
20            curr= next;
21        }
22        return prev;
23        
24        // // Brute Force approach
25        // List<Integer> ls = new ArrayList<>();
26        // while (head != null) {
27        //     ls.add(head.val);
28        //     head = head.next;
29        // }
30        // Collections.reverse(ls);
31        // ListNode newHead = new ListNode();
32        // ListNode temp = newHead;
33        // for (int num : ls) {
34        //     ListNode temp1 = new ListNode(num);
35        //     temp.next = temp1;
36        //     temp = temp.next;
37        // }
38        // return newHead.next;
39    }
40
41}