// Last updated: 31/08/2026, 22:31:18
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public List<Node> neighbors;
6    public Node() {
7        val = 0;
8        neighbors = new ArrayList<Node>();
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
23    private Node cloneUtil(Node node, HashMap<Node, Node> map) {
24        Node newNode = new Node(node.val);
25        map.put(node, newNode);
26
27        for (Node neighbor : node.neighbors) {
28            if (map.containsKey(neighbor)) {
29                newNode.neighbors.add(map.get(neighbor));
30            } else {
31                newNode.neighbors.add(cloneUtil(neighbor, map));
32            }
33        }
34        return newNode;
35    }
36
37    public Node cloneGraph(Node node) {
38        if (node == null)
39            return null;
40        HashMap<Node, Node> map = new HashMap<>();
41        return cloneUtil(node, map);
42    }
43}