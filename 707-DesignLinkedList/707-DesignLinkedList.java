// Last updated: 12/06/2026, 00:01:39
1class MyLinkedList {
2
3    class Node {
4        int val;
5        Node next;
6
7        Node() {
8        }
9
10        Node(int val) {
11            this.val = val;
12            this.next = null;
13        }
14    }
15
16    Node head;
17    Node tail;
18    int size;
19
20    public MyLinkedList() {
21        head = null;
22        tail = null;
23        size = 0;
24    }
25
26    public int get(int index) {
27        if (index < 0 || index >= size) {
28            // System.out.println("Index out of Bound");
29            return -1;
30        }
31        Node cur = head;
32        for (int i = 0; i < index; i++) {
33            cur = cur.next;
34        }
35        return cur.val;
36    }
37
38    public void addAtHead(int val) {
39        Node newNode = new Node(val);
40        newNode.next = head;
41        head = newNode;
42        if (size == 0)
43            tail = newNode;
44        size++;
45    }
46
47    public void addAtTail(int val) {
48        Node newNode = new Node(val);
49        if (size == 0) {
50            head = tail = newNode;
51        } else {
52            tail.next = newNode;
53            tail = newNode;
54        }
55        size++;
56    }
57
58    // 1<->2<->3<->4 
59    public void addAtIndex(int index, int val) {
60        if (index < 0 || index > size) {
61            // System.out.println("Index out of Bound");
62            return;
63        } else if (index == 0) {
64            addAtHead(val);
65            return;
66        } 
67        else if (index == size) {
68            addAtTail(val);
69            return;
70        }
71        else {
72            Node cur = head;
73            for (int i = 0; i < index - 1; i++) {
74                cur = cur.next;
75            }
76            Node newNode = new Node(val);
77            newNode.next = cur.next;
78            cur.next = newNode;
79        }
80        size++;
81    }
82
83    // 1<->2<->3<->4
84    public void deleteAtIndex(int index) {
85        if (index < 0 || index >= size) {
86            // System.out.println("Index out of Bound");
87            return;
88        }
89
90        if (index == 0) {
91            head = head.next;
92
93            if (head == null) {
94                tail = null;
95            }
96            size--;
97            return;
98        }
99        Node cur = head;
100        for (int i = 0; i < index - 1; i++) {
101            cur = cur.next;
102        }
103
104        if (cur.next == tail) {
105            tail = cur;
106        }
107        cur.next = cur.next.next;
108    
109        size--;
110    }
111}
112
113/**
114 * Your MyLinkedList object will be instantiated and called as such:
115 * MyLinkedList obj = new MyLinkedList();
116 * int param_1 = obj.get(index);
117 * obj.addAtHead(val);
118 * obj.addAtTail(val);
119 * obj.addAtIndex(index,val);
120 * obj.deleteAtIndex(index);
121 */