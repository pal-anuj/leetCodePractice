// Last updated: 24/01/2026, 00:09:52
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> st1= new Stack<>();
        while(l1!=null){
            st1.push(l1.val);
            l1= l1.next;
        }

        Stack<Integer> st2= new Stack<>();
        while(l2!=null){
            st2.push(l2.val);
            l2= l2.next;
        }

        Stack<Integer> res= new Stack<>();
        int carry=0;
        while(!st1.isEmpty() || !st2.isEmpty() || carry!=0){
            int digit1= st1.isEmpty()?0: st1.pop();
            int digit2= st2.isEmpty()?0: st2.pop();

            int sum= digit1 + digit2 + carry;
            int digit= sum % 10;
            carry= sum/10; 
            res.push(digit);
        }    

        ListNode head= new ListNode(0);
        ListNode curr= head;
        while(!res.isEmpty()){
            curr.next= new ListNode(res.pop());
            curr= curr.next;   
        }
        return head.next;
    }
}