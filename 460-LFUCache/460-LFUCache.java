// Last updated: 08/02/2026, 09:12:01
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
58        DoubleLinkedList newList = frequencyMap.getOrDefault(node.frequency, new DoubleLinkedList());
59
60        // add node to new frequency list (most recently used)
61        newList.addNode(node);
62        frequencyMap.put(node.frequency, newList);
63    }
64
65    /**
66     * Insert or update a key-value pair.
67     */
68    public void put(int key, int val) {
69
70        // edge case: zero capacity cache
71        if (capacity == 0)
72            return;
73
74        // if key already exists → update value and frequency
75        if (cache.containsKey(key)) {
76            DLLNode node = cache.get(key);
77            node.val = val;
78            updateNode(node);
79            return;
80        }
81
82        // inserting a new key
83        currSize++;
84
85        // if capacity exceeded → evict LFU key
86        if (currSize > capacity) {
87
88            // get the least frequency list
89            DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
90
91            // remove LRU node from that frequency list
92            DLLNode lruNode = minFreqList.tail.prev;
93            cache.remove(lruNode.key);
94            minFreqList.removeNode(lruNode);
95
96            currSize--;
97        }
98
99        // new node always starts with frequency 1
100        minFrequency = 1;
101        DLLNode newNode = new DLLNode(key, val);
102
103        // add new node to frequency 1 list
104        DoubleLinkedList currList = frequencyMap.getOrDefault(minFrequency, new DoubleLinkedList());
105
106        currList.addNode(newNode);
107        frequencyMap.put(minFrequency, currList);
108        cache.put(key, newNode);
109    }
110}
111
112/**
113 * Doubly Linked List Node
114 */
115class DLLNode {
116    int key;
117    int val;
118    int frequency;
119    DLLNode next;
120    DLLNode prev;
121
122    protected DLLNode(int key, int val) {
123        this.key = key;
124        this.val = val;
125        this.frequency = 1; // new node starts with freq = 1
126    }
127}
128
129/**
130 * Doubly Linked List to store nodes of same frequency
131 * Maintains LRU order within same frequency
132 */
133class DoubleLinkedList {
134
135    int listSize;
136    DLLNode head;
137    DLLNode tail;
138
139    protected DoubleLinkedList() {
140        head = new DLLNode(0, 0);
141        tail = new DLLNode(0, 0);
142        head.next = tail;
143        tail.prev = head;
144        listSize = 0;
145    }
146
147    /**
148     * Add node right after head (most recently used)
149     */
150    void addNode(DLLNode node) {
151        DLLNode nextNode = head.next;
152
153        node.next = nextNode;
154        node.prev = head;
155
156        head.next = node;
157        nextNode.prev = node;
158
159        listSize++;
160    }
161
162    /**
163     * Remove a node from the list
164     */
165    void removeNode(DLLNode node) {
166        DLLNode prevNode = node.prev;
167        DLLNode nextNode = node.next;
168
169        prevNode.next = nextNode;
170        nextNode.prev = prevNode;
171
172        listSize--;
173    }
174}
175
176/**
177 * Your LFUCache object will be instantiated and called as such:
178 * LFUCache obj = new LFUCache(capacity);
179 * int param_1 = obj.get(key);
180 * obj.put(key,value);
181 */