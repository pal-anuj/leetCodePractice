// Last updated: 03/05/2026, 22:38:30
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
14        ListNode newHead= new ListNode();
15        ListNode cur= newHead;
16        while(list1!=null && list2!=null){
17            if(list1.val <= list2.val){
18                cur.next= new ListNode(list1.val);
19                cur= cur.next;
20                list1= list1.next;
21            }else{
22                cur.next= new ListNode(list2.val);
23                cur= cur.next;
24                list2= list2.next;
25            }
26        }
27
28        while(list1!=null){
29            cur.next= list1;
30            cur=cur.next;
31            list1= list1.next;
32        }
33        while(list2!=null){
34            cur.next= list2;
35            cur=cur.next;
36            list2= list2.next;
37        }
38        return newHead.next;
39    }
40}