// Last updated: 13/06/2026, 09:29:28
1class MyHashMap {
2    int[] map;
3
4    public MyHashMap() {
5        map = new int[1000001];
6        Arrays.fill(map, -1);
7    }
8
9    public void put(int key, int value) {
10        map[key] = value;
11    }
12
13    public int get(int key) {
14        return map[key];
15    }
16
17    public void remove(int key) {
18        map[key] = -1;
19    }
20}
21
22/**
23 * Your MyHashMap object will be instantiated and called as such:
24 * MyHashMap obj = new MyHashMap();
25 * obj.put(key,value);
26 * int param_2 = obj.get(key);
27 * obj.remove(key);
28 */