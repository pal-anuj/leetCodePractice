// Last updated: 13/01/2026, 06:57:59
1class MyStack {
2
3    // Q1 - 12345 //FIFO
4    // Q2 - 
5    //Stack - LIFO
6    static int curr;
7    Queue<Integer> q1= new LinkedList<>();
8    Queue<Integer> q2= new LinkedList<>();
9    
10    public MyStack() {
11        curr=0;
12    }
13    
14    public void push(int x) {
15        curr++;
16        q2.add(x);
17        while(!q1.isEmpty()){
18            q2.add(q1.poll());
19        } 
20        q1 = q2;
21        System.out.println(q1.peek());        
22        q2= new LinkedList<>();
23
24    }
25
26    public int pop() {
27        if(q1.isEmpty()) return -1;
28        curr--;
29        return q1.poll();
30    }
31    
32    public int top() {
33        return q1.isEmpty() ? -1: q1.peek();        
34    }
35    
36    public boolean empty() {
37        return curr==0;
38    }
39}
40
41/**
42 * Your MyStack object will be instantiated and called as such:
43 * MyStack obj = new MyStack();
44 * obj.push(x);
45 * int param_2 = obj.pop();
46 * int param_3 = obj.top();
47 * boolean param_4 = obj.empty();
48 */