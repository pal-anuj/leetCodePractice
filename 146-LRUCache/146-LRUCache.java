// Last updated: 11/12/2025, 09:52:29
1class LRUCache {
2    class Node{
3        int key, value;
4        Node next,prev;
5        Node(int k, int v){
6            key= k;
7            value=v;
8        }
9    }
10    HashMap<Integer, Node> cache;
11    Node head,tail;
12    int capacity;
13    int size=0;
14
15    public LRUCache(int cap) {
16        capacity=cap;
17        cache= new HashMap<>();
18        head= new Node(0,0);
19        tail= new Node(0,0);
20        head.next= tail;
21        tail.prev= head;
22    }
23    
24    public void moveToHead(Node node){
25        remove(node);
26        insert(node);            
27    }
28    // 2
29    // 1->2->3
30    public void remove(Node node){
31        node.next.prev=node.prev;
32        node.prev.next=node.next; 
33    }
34    // 1
35    // 0->2->3->4
36    public void insert(Node node){
37        node.next= head.next;            
38        node.prev=head;
39        head.next.prev= node;
40        head.next=node;
41    }
42
43    // 0->1->2->3->4->5->0
44    public Node poptail(){
45        Node res= tail.prev;
46        remove(res);
47        return res;
48    }
49
50    public int get(int key) {
51        Node node= cache.get(key);
52        if(node==null) return -1;
53        moveToHead(node);
54        return node.value;
55    }
56    
57    public void put(int key, int value) {
58        Node node= cache.get(key);
59
60        if(node!=null){
61            node.value=value;
62            moveToHead(node);
63        }
64        else{
65            node= new Node(key, value);
66            insert(node);
67            cache.put(key, node);
68            size++;
69
70            if(size>capacity){
71                Node tailNode= poptail();
72                cache.remove(tailNode.key);  
73                size--;              
74            }
75        } 
76    }
77}
78
79/**
80 * Your LRUCache object will be instantiated and called as such:
81 * LRUCache obj = new LRUCache(capacity);
82 * int param_1 = obj.get(key);
83 * obj.put(key,value);
84 */