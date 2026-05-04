// Last updated: 04/05/2026, 07:39:06
1class LRUCache {
2
3    class Node {
4        int key, val;
5        Node prev, next;
6
7        Node(int key, int val) {
8            this.key = key;
9            this.val = val;
10        }
11    }
12
13    Map<Integer, Node> cache;
14    Node head, tail;
15    int capacity;
16    int size;
17
18    public LRUCache(int capacity) {
19        this.capacity = capacity;
20        size = 0;
21        cache = new HashMap<>();
22        head = new Node(0, 0);
23        tail = new Node(0, 0);
24        head.next = tail;
25        tail.prev = head;
26    }
27
28    public int get(int key) {
29        Node node = cache.get(key);
30        if (node == null)
31            return -1;
32        moveToHead(node);
33
34        return node.val;
35    }
36
37    public void moveToHead(Node node) {
38        remove(node);
39        insert(node);
40    }
41
42    public void remove(Node node) {
43        node.next.prev = node.prev;
44        node.prev.next = node.next;
45    }
46
47    public void insert(Node node) {
48        node.next = head.next;
49        node.prev = head;
50
51        head.next.prev = node;
52        head.next = node;
53    }
54
55    public void put(int key, int value) {
56
57        Node node = cache.get(key);
58
59        if (node != null) {
60            node.val = value;
61            moveToHead(node);
62        } else {
63            node = new Node(key, value);
64            insert(node);
65            cache.put(key, node);
66            size++;
67
68            if (size > capacity) {
69                Node tailNode = poptail();
70                cache.remove(tailNode.key);
71                size--;
72            }
73        }
74    }
75
76    public Node poptail() {
77        Node res = tail.prev;
78        remove(res);
79        return res;
80    }
81}
82
83/**
84 * Your LRUCache object will be instantiated and called as such:
85 * LRUCache obj = new LRUCache(capacity);
86 * int param_1 = obj.get(key);
87 * obj.put(key,value);
88 */