// Last updated: 07/02/2026, 00:01:15
1class MinStack {
2
3    int[] arr;
4    int cap;
5    int top;
6    TreeMap<Integer, Integer> map;
7
8    public MinStack() {
9        top = -1;
10        this.cap = 30000;
11        arr = new int[30000];
12        map = new TreeMap<>();
13    }
14
15    public void push(int val) {
16        if (top == cap - 1)
17            return;
18        else {
19            arr[++top] = val;
20            map.put(val, map.getOrDefault(val, 0) + 1);
21        }
22    }
23
24    public void pop() {
25        if (top == -1)
26            return;
27        else {
28            int num = arr[top--];
29            map.put(num, map.get(num) - 1);
30            if (map.get(num) == 0)
31                map.remove(num);
32        }
33    }
34
35    public int top() {
36        if (top > -1)
37            return arr[top];
38        else
39            return Integer.MAX_VALUE;
40    }
41
42    public int getMin() {
43        if (map.size() > 0)
44            return map.firstEntry().getKey();
45        else
46            return Integer.MAX_VALUE;
47    }
48}
49
50/**
51 * Your MinStack object will be instantiated and called as such:
52 * MinStack obj = new MinStack();
53 * obj.push(val);
54 * obj.pop();
55 * int param_3 = obj.top();
56 * int param_4 = obj.getMin();
57 */