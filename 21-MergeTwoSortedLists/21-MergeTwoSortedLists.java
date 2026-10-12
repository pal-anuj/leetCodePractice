// Last updated: 12/10/2026, 23:14:14
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
13        ListNode newH = new ListNode(0);
14        ListNode cur = newH;
15        while (list1 != null || list2 != null) {
16            if(list2==null || (list1!=null && list1.val<= list2.val)){
17                cur.next= new ListNode(list1.val);
18                cur=cur.next;
19                list1=list1.next;
20            }else{
21                cur.next= new ListNode(list2.val);
22                cur= cur.next;
23                list2= list2.next;
24            }
25        }
26        return newH.next;
27    }
28}