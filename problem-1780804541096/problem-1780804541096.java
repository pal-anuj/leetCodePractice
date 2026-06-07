// Last updated: 07/06/2026, 09:25:41
1class Solution {
2    public int sumOfGoodIntegers(int n, int k) {
3        int sum = 0;
4        for (int i = 1; i <= 200; i++) {
5            int dif = Math.abs(n - i);
6
7            System.out.println( n & i);
8            if (dif <= k  && (n & i) == 0){
9                System.out.println("i="+i+" , dif= "+dif);
10                sum += i;
11            }
12        }
13        return sum;
14    }
15}