// Last updated: 04/05/2026, 06:10:57
1/**
2 * Definition for singly-linked list.
3 * class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public boolean hasCycle(ListNode head) {
14        Set<ListNode> set= new HashSet<>();
15        while(head!=null){
16            if(set.contains(head))
17                return true;
18
19            set.add(head);
20            System.out.println(head.val);
21            head = head.next;    
22        }
23        return false;
24    }
25}