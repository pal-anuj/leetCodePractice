// Last updated: 10/10/2026, 15:19:11
1class MyHashMap {
2    int[] arr;
3    public MyHashMap() {
4        arr= new int[9999999];
5        Arrays.fill(arr, -1);
6    }
7    
8    public void put(int key, int value) {
9        arr[key]= value;
10    }
11    
12    public int get(int key) {
13        return arr[key];
14    }
15    
16    public void remove(int key) {
17        arr[key]=-1;
18    }
19}
20
21/**
22 * Your MyHashMap object will be instantiated and called as such:
23 * MyHashMap obj = new MyHashMap();
24 * obj.put(key,value);
25 * int param_2 = obj.get(key);
26 * obj.remove(key);
27 */