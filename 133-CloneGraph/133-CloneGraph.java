// Last updated: 30/01/2026, 20:00:11
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
23    public Node cloneGraph(Node node) {
24        if (node == null)
25            return null;
26        Map<Node, Node> map = new HashMap<>();
27        return cloneGraphUtil(node, map);
28    }
29
30    private Node cloneGraphUtil(Node node, Map<Node, Node> map) {
31        Node newNode = new Node(node.val);
32        map.put(node, newNode);
33
34        for (Node nei : node.neighbors) {
35            if (!map.containsKey(nei)) {
36                newNode.neighbors.add(cloneGraphUtil(nei, map));
37            } else {
38                newNode.neighbors.add(map.get(nei));
39            }
40        }
41
42        return newNode;
43    }
44}