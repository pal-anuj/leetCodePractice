// Last updated: 11/12/2025, 02:06:56
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) { val = x; }
7 * }
8 */
9class Solution {
10    public void deleteNode(ListNode node) {
11        ListNode temp= node;
12        while(temp!=null && temp.next.next!=null)
13        {
14            ListNode a= temp;
15            a.val= temp.next.val;
16            temp= temp.next;
17        }
18        temp.val= temp.next.val;
19        temp.next=null;
20    }
21}