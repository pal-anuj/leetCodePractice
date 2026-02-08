// Last updated: 08/02/2026, 09:08:49
1class LFUCache {
2
3    final int capacity; // total capacity of LFU cache
4    int currSize; // current number of keys in cache
5    int minFrequency; // minimum frequency among all keys
6
7    // key -> node mapping (direct access)
8    Map<Integer, DLLNode> cache;
9
10    // frequency -> doubly linked list of nodes
11    Map<Integer, DoubleLinkedList> frequencyMap;
12
13    public LFUCache(int capacity) {
14        this.capacity = capacity;
15        this.currSize = 0;
16        this.minFrequency = 0;
17
18        this.cache = new HashMap<>();
19        this.frequencyMap = new HashMap<>();
20    }
21
22    /**
23     * Get value by key.
24     * Also updates node frequency and repositions it.
25     */
26    public int get(int key) {
27        DLLNode currNode = cache.get(key);
28        if (currNode == null) {
29            return -1;
30        }
31
32        // increase frequency and relocate node
33        updateNode(currNode);
34        return currNode.val;
35    }
36
37    /**
38     * Updates the frequency of a node and moves it
39     * from old frequency list to new frequency list.
40     */
41    private void updateNode(DLLNode node) {
42
43        int currFreq = node.frequency;
44
45        // remove node from current frequency list
46        DoubleLinkedList currList = frequencyMap.get(currFreq);
47        currList.removeNode(node);
48
49        // if this list was the minFrequency list and is now empty,
50        // increment minFrequency
51        if (currFreq == minFrequency && currList.listSize == 0) {
52            minFrequency++;
53        }
54
55        // increment node frequency
56        node.frequency++;
57
58        // 🔥 IMPORTANT FIX: use node.frequency, NOT node.key
59        DoubleLinkedList newList = frequencyMap.getOrDefault(node.frequency, new DoubleLinkedList());
60
61        // add node to new frequency list (most recently used)
62        newList.addNode(node);
63        frequencyMap.put(node.frequency, newList);
64    }
65
66    /**
67     * Insert or update a key-value pair.
68     */
69    public void put(int key, int val) {
70
71        // edge case: zero capacity cache
72        if (capacity == 0)
73            return;
74
75        // if key already exists → update value and frequency
76        if (cache.containsKey(key)) {
77            DLLNode node = cache.get(key);
78            node.val = val;
79            updateNode(node);
80            return;
81        }
82
83        // inserting a new key
84        currSize++;
85
86        // if capacity exceeded → evict LFU key
87        if (currSize > capacity) {
88
89            // get the least frequency list
90            DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
91
92            // remove LRU node from that frequency list
93            DLLNode lruNode = minFreqList.tail.prev;
94            cache.remove(lruNode.key);
95            minFreqList.removeNode(lruNode);
96
97            currSize--;
98        }
99
100        // new node always starts with frequency 1
101        minFrequency = 1;
102        DLLNode newNode = new DLLNode(key, val);
103
104        // add new node to frequency 1 list
105        DoubleLinkedList currList = frequencyMap.getOrDefault(minFrequency, new DoubleLinkedList());
106
107        currList.addNode(newNode);
108        frequencyMap.put(minFrequency, currList);
109        cache.put(key, newNode);
110    }
111}
112
113/**
114 * Doubly Linked List Node
115 */
116class DLLNode {
117    int key;
118    int val;
119    int frequency;
120    DLLNode next;
121    DLLNode prev;
122
123    protected DLLNode(int key, int val) {
124        this.key = key;
125        this.val = val;
126        this.frequency = 1; // new node starts with freq = 1
127    }
128}
129
130/**
131 * Doubly Linked List to store nodes of same frequency
132 * Maintains LRU order within same frequency
133 */
134class DoubleLinkedList {
135
136    int listSize;
137    DLLNode head;
138    DLLNode tail;
139
140    protected DoubleLinkedList() {
141        head = new DLLNode(0, 0);
142        tail = new DLLNode(0, 0);
143        head.next = tail;
144        tail.prev = head;
145        listSize = 0;
146    }
147
148    /**
149     * Add node right after head (most recently used)
150     */
151    void addNode(DLLNode node) {
152        DLLNode nextNode = head.next;
153
154        node.next = nextNode;
155        node.prev = head;
156
157        head.next = node;
158        nextNode.prev = node;
159
160        listSize++;
161    }
162
163    /**
164     * Remove a node from the list
165     */
166    void removeNode(DLLNode node) {
167        DLLNode prevNode = node.prev;
168        DLLNode nextNode = node.next;
169
170        prevNode.next = nextNode;
171        nextNode.prev = prevNode;
172
173        listSize--;
174    }
175}
176
177/**
178 * Your LFUCache object will be instantiated and called as such:
179 * LFUCache obj = new LFUCache(capacity);
180 * int param_1 = obj.get(key);
181 * obj.put(key,value);
182 */