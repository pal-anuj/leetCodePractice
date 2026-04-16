// Last updated: 16/04/2026, 05:36:36
class Solution {
    public long nthSmallest(long n, int k) {

        //DFS
        n--; // zero-based
        int B = 60; // max bits
        long r = 0;

        for (int i = B - 1; i > 0; i--) {
            long c = comb(i - 1, k);

            if (n >= c) {
                n -= c;
                k--;
                r |= (1L << (i - 1));
            }
        }
        return r;

        /*
        // Navie Approch but Time Limit Exceeded
        long i = (1L << k) - 1;
        long max= (1L << (k+19)) - 1;
        System.out.println(max);
        for (i = 1; i < max; i++) {
        
            int c = countOnes(i);
            if (c == k)
                n--;
        
            if (n == 0)
                break;
        }
        return i;
        */

    }

    // DFS Helper method to calculate nCr (combination)
    private long comb(int n, int r) {
        if (r < 0 || r > n)
            return 0;
        if (r == 0 || r == n)
            return 1;

        r = Math.min(r, n - r);
        long res = 1;

        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
        }
        return res;
    }

    // naive approach helper
    public static int countOnes(long n) {
        int count = 0;

        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
