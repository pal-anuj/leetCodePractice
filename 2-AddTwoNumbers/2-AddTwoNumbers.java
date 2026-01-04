// Last updated: 04/01/2026, 11:58:45
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
14        ListNode i1= l1;
15        ListNode i2= l2;
16
17        int carry=0;
18        ListNode res=new ListNode(0);
19        ListNode curr= res;
20        while(i1 != null && i2 != null){
21            int num = i1.val + i2.val + carry;
22            if(num>9){
23                carry= num / 10; 
24                num= num % 10;
25            }
26            else
27                carry=0;
28            // System.out.println(num);
29
30            curr.next= new ListNode(num);
31            curr= curr.next;
32
33            i1= i1.next;
34            i2= i2.next;
35        }
36
37        if(i1 != null){
38
39            while(i1 != null){
40                int num = i1.val + carry;
41                if(num>9){
42                    carry= num / 10; 
43                    num= num % 10;
44                }
45                else
46                    carry=0;
47                curr.next= new ListNode(num);
48                curr= curr.next;
49                i1= i1.next;
50            }
51        }
52        else if(i2 != null){
53
54            while(i2 != null){
55                int num = i2.val + carry;
56                if(num>9){
57                    carry= num / 10; 
58                    num= num % 10;
59                }
60                else
61                    carry=0;
62                curr.next= new ListNode(num);
63                curr= curr.next;
64                i2= i2.next;
65            }
66        }
67
68        if(carry!=0)
69         {
70                curr.next= new ListNode(carry);
71                curr= curr.next;
72         }   
73
74        return res.next;
75    }
76}