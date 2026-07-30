// Last updated: 30/07/2026, 05:30:01
1class MinStack {
2
3    static class Node{
4        int val;
5        int min;
6        Node next;
7
8        Node(int val, int min, Node next){
9            this.val=val;
10            this.min=min;
11            this.next=next;
12        }
13    }
14
15    Node head;
16    public MinStack() {
17    }
18    
19    public void push(int value) {
20        if(head==null){
21            head= new Node(value, value, null);
22        }
23        else{
24            head= new Node(value, Math.min(head.min, value), head);
25        }
26    }
27    
28    public void pop() {
29        head= head.next;
30    }
31    
32    public int top() {
33        return head.val;
34    }
35    
36    public int getMin() {
37        return head.min;
38    }
39}
40
41/**
42 * Your MinStack object will be instantiated and called as such:
43 * MinStack obj = new MinStack();
44 * obj.push(value);
45 * obj.pop();
46 * int param_3 = obj.top();
47 * int param_4 = obj.getMin();
48 */