// Last updated: 05/01/2026, 23:25:28
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
19        Node curr= head;
20        Map<Node,Node> map= new HashMap<>();
21        while(curr!=null){            
22            map.put(curr, new Node(curr.val));
23            curr= curr.next;
24        }
25
26        for(Node temp=head;temp!=null; temp=temp.next)
27        {
28            Node cloneCurr= map.get(temp);
29            cloneCurr.next= map.get(temp.next);
30            cloneCurr.random= map.get(temp.random);
31        }
32
33        Node newHead= map.get(head);
34        return newHead;
35    }
36}