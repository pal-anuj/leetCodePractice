// Last updated: 07/01/2026, 09:29:34
1/*
2// Definition for a Node.
3class Node {
4    int val;
5    Node next;
6    Node random;
7
8    public Node(int val) {
9        this.val = val;
10        this.next = null;
11        this.random = null;
12    }
13}
14*/
15
16class Solution {
17    public Node copyRandomList(Node head) {
18        
19        if(head==null) return null;
20        Node next,res;
21        for(Node curr=head; curr!=null;){
22            next= curr.next;
23            curr.next= new Node(curr.val);
24            curr.next.next= next;
25            curr=next;
26        }
27
28        for(Node curr=head; curr!=null;curr= curr.next.next){
29            curr.next.random= (curr.random!=null)? curr.random.next: null;
30        }
31
32        Node original= head; Node copy= head.next;
33        res= copy;
34        while(original!=null && copy!=null){
35
36            original.next= 
37                original.next!=null? original.next.next: original.next;
38            
39            copy.next= 
40                copy.next!=null? copy.next.next: copy.next;
41            
42            original= original.next;
43            copy= copy.next;
44        }
45
46        return res;
47
48        /*
49        Node curr= head;
50        Map<Node,Node> map= new HashMap<>();
51        while(curr!=null){            
52            map.put(curr, new Node(curr.val));
53            curr= curr.next;
54        }
55
56        for(Node temp=head;temp!=null; temp=temp.next)
57        {
58            Node cloneCurr= map.get(temp);
59            cloneCurr.next= map.get(temp.next);
60            cloneCurr.random= map.get(temp.random);
61        }
62
63        Node newHead= map.get(head);
64        return newHead;
65        */
66    }
67}