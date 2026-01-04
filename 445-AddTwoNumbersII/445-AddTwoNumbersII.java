// Last updated: 04/01/2026, 12:38:55
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
12    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
13
14        Stack<Integer> st1= new Stack<>();
15        while(l1!=null){
16            st1.push(l1.val);
17            l1= l1.next;
18        }
19
20        Stack<Integer> st2= new Stack<>();
21        while(l2!=null){
22            st2.push(l2.val);
23            l2= l2.next;
24        }
25
26        Stack<Integer> res= new Stack<>();
27        int carry=0;
28        while(!st1.isEmpty() || !st2.isEmpty() || carry!=0){
29            int digit1= st1.isEmpty()?0: st1.pop();
30            int digit2= st2.isEmpty()?0: st2.pop();
31
32            int sum= digit1 + digit2 + carry;
33            int digit= sum % 10;
34            carry= sum/10; 
35            res.push(digit);
36        }    
37
38        ListNode head= new ListNode(0);
39        ListNode curr= head;
40        while(!res.isEmpty()){
41            curr.next= new ListNode(res.pop());
42            curr= curr.next;   
43        }
44        return head.next;
45    }
46}