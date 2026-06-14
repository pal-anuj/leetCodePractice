// Last updated: 14/06/2026, 08:34:41
1class Solution {
2    public boolean checkGoodInteger(int n) {
3        int m = n;
4        int squareSum = 0;
5        int digitSum = 0;
6        do {
7            int num = n % 10;
8            n = n / 10;
9            digitSum += num;
10            num *= num;
11            squareSum += num;
12        }while (n > 0);
13
14            System.out.println("squareSum=" + squareSum);
15            System.out.println("digitSum=" + digitSum);
16
17        return (squareSum - digitSum) >= 50;
18    }
19}