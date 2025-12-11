// Last updated: 11/12/2025, 09:57:27
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp= node;
        while(temp!=null && temp.next.next!=null)
        {
            ListNode a= temp;
            a.val= temp.next.val;
            temp= temp.next;
        }
        temp.val= temp.next.val;
        temp.next=null;
    }
}