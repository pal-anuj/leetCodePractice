// Last updated: 16/04/2026, 05:37:10
class LFUCache {

    final int capacity; // total capacity of LFU cache
    int currSize; // current number of keys in cache
    int minFrequency; // minimum frequency among all keys

    // key -> node mapping (direct access)
    Map<Integer, DLLNode> cache;

    // frequency -> doubly linked list of nodes
    Map<Integer, DoubleLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFrequency = 0;

        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    /**
     * Get value by key.
     * Also updates node frequency and repositions it.
     */
    public int get(int key) {
        DLLNode currNode = cache.get(key);
        if (currNode == null) {
            return -1;
        }

        // increase frequency and relocate node
        updateNode(currNode);
        return currNode.val;
    }

    /**
     * Updates the frequency of a node and moves it
     * from old frequency list to new frequency list.
     */
    private void updateNode(DLLNode node) {

        int currFreq = node.frequency;

        // remove node from current frequency list
        DoubleLinkedList currList = frequencyMap.get(currFreq);
        currList.removeNode(node);

        // if this list was the minFrequency list and is now empty,
        // increment minFrequency
        if (currFreq == minFrequency && currList.listSize == 0) {
            minFrequency++;
        }

        // increment node frequency
        node.frequency++;

        DoubleLinkedList newList = frequencyMap.getOrDefault(node.frequency, new DoubleLinkedList());

        // add node to new frequency list (most recently used)
        newList.addNode(node);
        frequencyMap.put(node.frequency, newList);
    }

    /**
     * Insert or update a key-value pair.
     */
    public void put(int key, int val) {

        // edge case: zero capacity cache
        if (capacity == 0)
            return;

        // if key already exists → update value and frequency
        if (cache.containsKey(key)) {
            DLLNode node = cache.get(key);
            node.val = val;
            updateNode(node);
            return;
        }

        // inserting a new key
        currSize++;

        // if capacity exceeded → evict LFU key
        if (currSize > capacity) {

            // get the least frequency list
            DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);

            // remove LRU node from that frequency list
            DLLNode lruNode = minFreqList.tail.prev;
            cache.remove(lruNode.key);
            minFreqList.removeNode(lruNode);

            currSize--;
        }

        // new node always starts with frequency 1
        minFrequency = 1;
        DLLNode newNode = new DLLNode(key, val);

        // add new node to frequency 1 list
        DoubleLinkedList currList = frequencyMap.getOrDefault(minFrequency, new DoubleLinkedList());

        currList.addNode(newNode);
        frequencyMap.put(minFrequency, currList);
        cache.put(key, newNode);
    }
}

/**
 * Doubly Linked List Node
 */
class DLLNode {
    int key;
    int val;
    int frequency;
    DLLNode next;
    DLLNode prev;

    protected DLLNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.frequency = 1; // new node starts with freq = 1
    }
}

/**
 * Doubly Linked List to store nodes of same frequency
 * Maintains LRU order within same frequency
 */
class DoubleLinkedList {

    int listSize;
    DLLNode head;
    DLLNode tail;

    protected DoubleLinkedList() {
        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);
        head.next = tail;
        tail.prev = head;
        listSize = 0;
    }

    /**
     * Add node right after head (most recently used)
     */
    void addNode(DLLNode node) {
        DLLNode nextNode = head.next;

        node.next = nextNode;
        node.prev = head;

        head.next = node;
        nextNode.prev = node;

        listSize++;
    }

    /**
     * Remove a node from the list
     */
    void removeNode(DLLNode node) {
        DLLNode prevNode = node.prev;
        DLLNode nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        listSize--;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */