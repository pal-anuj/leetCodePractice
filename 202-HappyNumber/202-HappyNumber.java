// Last updated: 17/02/2026, 08:30:41
1class Solution {
2    public boolean isHappy(int n) {
3        Set<Integer> seen = new HashSet<>();
4
5        while (n != 1) {
6            if (seen.contains(n))
7                return false;
8
9            seen.add(n);
10            n = getNext(n);
11        }
12        return true;
13    }
14
15    private int getNext(int n) {
16        int sum = 0;
17        while (n > 0) {
18            int digit = n % 10;
19            sum += digit * digit;
20            n /= 10;
21        }
22        return sum;
23    }
24}