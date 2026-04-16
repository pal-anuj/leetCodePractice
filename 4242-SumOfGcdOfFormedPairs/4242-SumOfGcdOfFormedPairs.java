// Last updated: 16/04/2026, 05:36:24
class Solution {
    public long gcdSum(int[] nums) {
        int[] gcdPrefix = gcdPrefix(nums);

        // for(int num : gcdPrefix)
        //    System.out.println(num);                 

        Arrays.sort(gcdPrefix);

        int l = 0;
        int r = gcdPrefix.length - 1;
        long res = 0;
        while (l < r) {
            res += gcd(gcdPrefix[l++], gcdPrefix[r--]);
        }
        return res;
    }

    private int[] gcdPrefix(int[] nums) {
        int n = nums.length;
        int[] gcdPrefix = new int[n];
        int runningMax = nums[0];
        gcdPrefix[0] = gcd(nums[0], runningMax);

        for (int i = 1; i < n; i++) {
            runningMax = Math.max(nums[i], runningMax);
            gcdPrefix[i] = gcd(nums[i], runningMax);
        }
        return gcdPrefix;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}