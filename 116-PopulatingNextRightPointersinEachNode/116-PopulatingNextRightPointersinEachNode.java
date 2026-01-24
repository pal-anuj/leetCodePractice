// Last updated: 24/01/2026, 09:48:33
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public Node left;
6    public Node right;
7    public Node next;
8
9    public Node() {}
10    
11    public Node(int _val) {
12        val = _val;
13    }
14
15    public Node(int _val, Node _left, Node _right, Node _next) {
16        val = _val;
17        left = _left;
18        right = _right;
19        next = _next;
20    }
21};
22*/
23
24class Solution {
25    public Node connect(Node root) {
26
27        if (root == null)
28            return null;
29
30        Queue<Node> q = new LinkedList<>();
31        q.offer(root);
32
33        while (!q.isEmpty()) {
34            int n = q.size();
35
36            for (int i = 0; i < n; i++) {
37                Node curr = q.poll();
38                curr.next = i == n - 1 ? null : q.peek();
39
40                if (curr.left != null)
41                    q.offer(curr.left);
42                if (curr.right != null)
43                    q.offer(curr.right);
44            }
45        }
46
47        return root;
48    }
49}