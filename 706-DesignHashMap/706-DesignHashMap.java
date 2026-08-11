// Last updated: 11/08/2026, 07:49:55
1class MyHashMap {
2
3    int arr[];
4
5    public MyHashMap() {
6        arr = new int[1000001];
7        Arrays.fill(arr, -1);
8    }
9
10    public void put(int key, int value) {
11        arr[key] = value;
12    }
13
14    public int get(int key) {
15        return arr[key];
16    }
17
18    public void remove(int key) {
19        arr[key] = -1;
20    }
21}
22
23/**
24 * Your MyHashMap object will be instantiated and called as such:
25 * MyHashMap obj = new MyHashMap();
26 * obj.put(key,value);
27 * int param_2 = obj.get(key);
28 * obj.remove(key);
29 */