// Last updated: 30/01/2026, 19:54:17
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public List<Node> neighbors;
6    public Node() {
7        val = 0;
8        y = new ArrayList<Node>();
9    }
10    public Node(int _val) {
11        val = _val;
12        neighbors = new ArrayList<Node>();
13    }
14    public Node(int _val, ArrayList<Node> _neighbors) {
15        val = _val;
16        neighbors = _neighbors;
17    }
18}
19*/
20
21class Solution {
22
23    private static Map<Node, Node> map = new HashMap<>();
24
25    public Node cloneGraph(Node node) {
26        if (node == null)
27            return null;
28
29        Node newNode = new Node(node.val);
30        map.put(node, newNode);
31
32        for (Node nei : node.neighbors) {
33            if (!map.containsKey(nei)) {
34                newNode.neighbors.add(cloneGraph(nei));
35            } else {
36                newNode.neighbors.add(map.get(nei));
37            }
38        }
39
40        return newNode;
41    }
42}