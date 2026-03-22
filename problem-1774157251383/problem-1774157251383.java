// Last updated: 22/03/2026, 10:57:31
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int oddCount = 0;
4        int evenCount = 0;
5        int smallOdd = Integer.MAX_VALUE;
6        int smallEven = Integer.MAX_VALUE;
7        //Either all are even
8        // if any odd then starting smalled odd should
9        for (int num :  nums1) {
10            int x= num % 2;
11            // System.out.println("x= "+num+"=>"+x);
12            if (x == 0) {
13                evenCount++;
14                smallEven = Math.min(smallEven, num);
15            } else {
16                oddCount++;
17                smallOdd = Math.min(smallOdd, num);
18            }
19        }
20        // System.out.println("smallOdd="+smallOdd);
21        // System.out.println("smallEven="+smallEven);
22
23        if (oddCount == 0 && evenCount > 0)
24            return true;
25        if (oddCount >= 1 && smallOdd < smallEven)
26            return true;
27        else
28            return false;
29
30    }
31}