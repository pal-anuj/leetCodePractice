// Last updated: 11/08/2026, 06:59:06
1class LRUCache {
2    class Node{
3        int key;
4        int val;
5        Node next, prev;
6        Node(int key, int val){
7            this.key=key;
8            this.val=val;
9        }
10    }
11
12    int capacity;
13    int size;
14    Map<Integer,Node> cache;
15    Node head,tail;
16
17
18    public LRUCache(int capacity) {
19        cache= new HashMap<>();
20        size=0;
21        this.capacity= capacity;
22        head= new Node(0,0);
23        tail= new Node(0,0);
24        head.next=tail;
25        tail.prev=head;
26    }
27    
28    public int get(int key) {
29        Node node=cache.get(key);
30        if(node==null) return -1;
31        moveToHead(node);
32        return node.val;
33    }
34
35    private void moveToHead(Node node){
36        remove(node);
37        insert(node);
38    }
39
40    private void remove(Node node){
41        node.prev.next=node.next;
42        node.next.prev= node.prev;
43    }
44    private void insert(Node node){
45        node.next= head.next;
46        node.prev= head;
47        head.next.prev= node;
48        head.next= node;
49    }
50    
51    public void put(int key, int value) {
52        Node node= cache.get(key);
53
54        if(node!=null){
55            node.val= value;
56            moveToHead(node);
57        }
58        else{
59            node= new Node(key, value);
60            insert(node);
61            cache.put(key, node);
62            size++;
63
64            if(capacity < size){
65                Node tailNode= poptail();
66                cache.remove(tailNode.key);
67                size--;
68            }
69        }
70    }
71
72    private Node poptail(){
73        Node res= tail.prev;
74        remove(res);
75        return res;
76    }
77
78
79}
80
81/**
82 * Your LRUCache object will be instantiated and called as such:
83 * LRUCache obj = new LRUCache(capacity);
84 * int param_1 = obj.get(key);
85 * obj.put(key,value);
86 */