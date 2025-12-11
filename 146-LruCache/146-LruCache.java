// Last updated: 11/12/2025, 09:57:35
class LRUCache {
    class Node{
        int key, value;
        Node next,prev;
        Node(int k, int v){
            key= k;
            value=v;
        }
    }
    HashMap<Integer, Node> cache;
    Node head,tail;
    int capacity;
    int size=0;

    public LRUCache(int cap) {
        capacity=cap;
        cache= new HashMap<>();
        head= new Node(0,0);
        tail= new Node(0,0);
        head.next= tail;
        tail.prev= head;
    }
    
    public void moveToHead(Node node){
        remove(node);
        insert(node);            
    }
    // 2
    // 1->2->3
    public void remove(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next; 
    }
    // 1
    // 0->2->3->4
    public void insert(Node node){
        node.next= head.next;            
        node.prev=head;
        head.next.prev= node;
        head.next=node;
    }

    // 0->1->2->3->4->5->0
    public Node poptail(){
        Node res= tail.prev;
        remove(res);
        return res;
    }

    public int get(int key) {
        Node node= cache.get(key);
        if(node==null) return -1;
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node= cache.get(key);

        if(node!=null){
            node.value=value;
            moveToHead(node);
        }
        else{
            node= new Node(key, value);
            insert(node);
            cache.put(key, node);
            size++;

            if(size>capacity){
                Node tailNode= poptail();
                cache.remove(tailNode.key);  
                size--;              
            }
        } 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */