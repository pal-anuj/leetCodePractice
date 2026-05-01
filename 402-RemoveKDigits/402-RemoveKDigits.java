// Last updated: 01/05/2026, 15:53:32
1class Solution {
2    public String removeKdigits(String num, int k) {
3        int n = num.length();
4        if (n == k) return "0";
5        Deque<Character> dq = new ArrayDeque<>();
6
7        // Step 1: Build monotonic stack
8        for (int i = 0; i < n; i++) {
9            while (!dq.isEmpty() && k > 0 && dq.peekLast() - '0' > num.charAt(i) - '0') {
10                dq.removeLast();
11                k--;
12            }
13            dq.addLast(num.charAt(i));
14        }
15
16        // Step 2: Remove remaining k digits
17        while (!dq.isEmpty() && k > 0) {
18            dq.removeLast();
19            k--;
20        }
21
22        // Step 4: Remove leading zeros
23        while (!dq.isEmpty() && dq.peekFirst() - '0' == 0)
24            dq.pollFirst();
25
26        // Step 3: Build result
27        String res = new String();
28        while (!dq.isEmpty()) {
29            res = res + dq.pollFirst();
30        }
31
32        return res.length() == 0 ? "0" : res;
33    }
34}