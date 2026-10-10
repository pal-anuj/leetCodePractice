// Last updated: 10/10/2026, 20:36:18
1class MyHashMap {
2    private static class Node {
3        int key;
4        int val;
5        Node next;
6
7        Node(int k, int v, Node n) {
8            key = k;
9            val = v;
10            next = n;
11        }
12    }
13
14    private static final float LOAD_FACTOR = 0.75f;
15    private int size = 0;
16    private Node[] table;
17
18    public MyHashMap() {
19        table = new Node[16];
20        size = 0;
21    }
22
23    private int getIndex(int key, int cap) {
24        int h = key ^ (key >>> 16); // spread high bits into low bits
25        return h & (cap - 1); // fast modulo, works since cap is power of 2
26    }
27
28    public void put(int key, int val) {
29        int idx = getIndex(key, table.length);
30
31        for (Node n = table[idx]; n != null; n = n.next) {
32            if (n.key == key) {
33                n.val = val;
34                return;
35            }
36        }
37        table[idx] = new Node(key, val, table[idx]);
38        size++;
39        if (size > table.length * LOAD_FACTOR)
40            resize();
41    }
42
43    private void resize() {
44        Node[] old = table;
45        table = new Node[old.length << 1];
46        for (Node head : old) {
47            for (Node n = head; n != null;) {
48                Node next = n.next;
49                int idx = getIndex(n.key, table.length);
50                n.next = table[idx];
51                table[idx] = n;
52                n = next;
53            }
54        }
55    }
56
57    public int get(int key) {
58        int idx = getIndex(key, table.length);
59        for (Node n = table[idx]; n != null; n = n.next) {
60            if (n.key == key)
61                return n.val;
62        }
63        return -1;
64    }
65
66    public void remove(int key) {
67        int idx = getIndex(key, table.length);
68        Node prev = null;
69        for (Node n = table[idx]; n != null; n = n.next) {
70            if (n.key == key) {
71                if (prev == null) {
72                    table[idx] = n.next;
73                } else {
74                    prev.next = prev.next.next;
75                }
76                size--;
77                return;
78            }
79            prev = n;
80        }
81    }
82}
83
84/**
85 * Your MyHashMap object will be instantiated and called as such:
86 * MyHashMap obj = new MyHashMap();
87 * obj.put(key,val);
88 * int param_2 = obj.get(key);
89 * obj.remove(key);
90 */