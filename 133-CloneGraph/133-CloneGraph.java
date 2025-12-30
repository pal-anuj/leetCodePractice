// Last updated: 30/12/2025, 08:41:11
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
22    public Node cloneGraph(Node node) {
23        if(node== null) return null;
24
25        // Map: original node -> cloned node
26        Map<Node, Node> map= new HashMap<>();
27
28        // Queue for BFS
29        Queue<Node> q= new LinkedList<>();
30
31        // Clone the first node
32        Node clone= new Node(node.val, new ArrayList<>());
33        map.put(node, clone);
34        q.add(node);
35
36        while(!q.isEmpty()){
37
38            Node curr= q.poll();
39
40            ArrayList<Node> al= new ArrayList<>();
41            for(Node nei : curr.neighbors){
42                // If neighbor is not cloned yet
43                if(!map.containsKey(nei)){
44                    map.put(nei, new Node(nei.val, new ArrayList<>()));
45                    q.add(nei);
46                }
47
48                // Add cloned neighbor to current cloned node
49                map.get(curr).neighbors.add(map.get(nei));           
50             }
51        }
52        return clone;
53    }
54}