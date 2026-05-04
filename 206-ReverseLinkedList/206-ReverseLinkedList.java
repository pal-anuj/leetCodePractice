// Last updated: 04/05/2026, 06:01:30
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
13        // Effcient approach
14        ListNode prev= null;
15        ListNode cur= head;
16        while(cur!=null){
17            ListNode next= cur.next;
18            cur.next = prev;
19            prev=cur;
20            cur= next;
21        }
22        return prev;
23
24        // // base case Recursive method Time : O(n), space: O(n) for stack call
25        // if(head == null || head.next == null)
26        //     return head;    
27
28        // ListNode newHead= reverseList(head.next);
29        
30        // head.next.next = head;
31        // head.next = null;
32
33        // return newHead;
34
35        
36        // // Brute Force approach
37        // List<Integer> ls = new ArrayList<>();
38        // while (head != null) {
39        //     ls.add(head.val);
40        //     head = head.next;
41        // }
42        // Collections.reverse(ls);
43        // ListNode newHead = new ListNode();
44        // ListNode temp = newHead;
45        // for (int num : ls) {
46        //     ListNode temp1 = new ListNode(num);
47        //     temp.next = temp1;
48        //     temp = temp.next;
49        // }
50        // return newHead.next;
51    }
52}