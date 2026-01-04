// Last updated: 04/01/2026, 12:53:22
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
13
14        ListNode res= new ListNode(0);
15        ListNode curr= res;            
16        while(list1 != null || list2 != null){
17
18            if(list2==null || (list1!=null && list1.val <= list2.val)){
19                curr.next= new ListNode(list1.val);
20                curr= curr.next;
21                list1= list1.next;
22            }
23            else{
24                curr.next= new ListNode(list2.val);
25                curr= curr.next;
26                list2= list2.next;
27            }
28        }
29
30        return res.next;
31    }
32}