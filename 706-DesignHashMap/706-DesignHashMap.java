// Last updated: 13/06/2026, 10:00:13
1class MyHashMap {
2    class Node {
3        int key;
4        int val;
5        Node next;
6
7        Node(int key, int val) {
8            this.key = key;
9            this.val = val;
10        }
11    }
12
13    private Node[] buckets;
14    private int capacity;
15    private int size;
16    private final double LOAD_FACTOR = 0.75;
17
18    public MyHashMap() {
19        capacity = 16;
20        buckets = new Node[capacity];
21    }
22
23    private int hash(int key) {
24        return key % capacity;
25        // int hash = Objects.hashCode(key);
26        // // avoid negative index
27        // return Math.abs(hash) % capacity;
28    }
29
30    public void put(int key, int value) {
31        int idx = hash(key);
32
33        Node cur = buckets[idx];
34
35        while (cur != null) {
36            if (cur.key == key) {
37                cur.val = value;
38                return;
39            }
40            cur = cur.next;
41        }
42
43        Node node = new Node(key, value);
44        node.next = buckets[idx];
45        buckets[idx] = node;
46        size++;
47
48        // Resize if needed
49        if ((double) size / capacity >= LOAD_FACTOR) {
50            resize();
51        }
52    }
53
54    private void resize() {
55        int oldCapacity = capacity;
56        capacity *= 2;
57
58        Node[] oldBuckets = buckets;
59        buckets = new Node[capacity];
60        size = 0;
61
62        for (Node head : oldBuckets) {
63            while (head != null) {
64                put(head.key, head.val);
65                head = head.next;
66            }
67        }
68    }
69
70    public int get(int key) {
71        int idx = hash(key);
72        Node cur = buckets[idx];
73        while (cur != null) {
74            if (cur.key == key) {
75                return cur.val;
76            }
77            cur = cur.next;
78        }
79        return -1;
80    }
81
82    public void remove(int key) {
83        int idx = hash(key);
84        Node cur = buckets[idx];
85        Node prev = null;
86        while (cur != null) {
87            if (cur.key == key) {
88                if (prev == null) {
89                    buckets[idx] = cur.next;
90                } else {
91                    prev.next = cur.next;
92                }
93                size--;
94                return;
95            }
96            prev = cur;
97            cur = cur.next;
98        }
99    }
100}
101
102/**
103 * Your MyHashMap object will be instantiated and called as such:
104 * MyHashMap obj = new MyHashMap();
105 * obj.put(key,value);
106 * int param_2 = obj.get(key);
107 * obj.remove(key);
108 */