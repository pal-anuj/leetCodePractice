// Last updated: 04/01/2026, 09:13:03
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
14        
15        Set<ListNode> set= new HashSet<>();
16        ListNode curr= head;
17
18        while(curr!= null){
19
20            if(set.contains(curr)){
21                return true;
22            }
23            set.add(curr);
24            curr= curr.next;
25        }
26        return false;
27    }
28}