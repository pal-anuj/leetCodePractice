// Last updated: 04/01/2026, 09:15:32
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
15        ListNode slow=head,fast= head;
16
17        while(fast!=null && fast.next!=null){
18            slow= slow.next;
19            fast= fast.next.next;
20            if(fast == slow) return true;
21        }
22        return false;
23        
24        /*
25        ListNode curr= head;
26        Set<ListNode> set= new HashSet<>();
27        while(curr!= null){
28
29            if(set.contains(curr)){
30                return true;
31            }
32            set.add(curr);
33            curr= curr.next;
34        }
35        return false;
36        */
37
38
39
40    }
41}