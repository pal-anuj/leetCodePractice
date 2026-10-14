// Last updated: 14/10/2026, 09:56:42
1class StockSpanner {
2    private List<Integer> ls;
3    private Stack<Integer> st;
4
5    public StockSpanner() {
6        this.ls = new ArrayList<>();
7        this.st = new Stack<>();
8    }
9
10    public int next(int price) {
11        while (!st.isEmpty() && ls.get(st.peek()) <= price) {
12            st.pop();
13        }
14
15        int res = st.isEmpty() ? ls.size() + 1 : ls.size() - st.peek();
16        ls.add(price);        
17        st.push(ls.size() - 1);
18        System.out.println(st);
19        return res;
20    }
21}
22
23/**
24 * Your StockSpanner object will be instantiated and called as such:
25 * StockSpanner obj = new StockSpanner();
26 * int param_1 = obj.next(price);
27 */