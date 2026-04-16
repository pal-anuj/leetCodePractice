// Last updated: 16/04/2026, 05:36:16
class Solution {
    public boolean uniformArray(int[] nums1) {
        int oddCount = 0;
        int evenCount = 0;
        int smallOdd = Integer.MAX_VALUE;
        int smallEven = Integer.MAX_VALUE;
        //Either all are even
        // if any odd then starting smalled odd should
        for (int num :  nums1) {
            int x= num % 2;
            // System.out.println("x= "+num+"=>"+x);
            if (x == 0) {
                evenCount++;
                smallEven = Math.min(smallEven, num);
            } else {
                oddCount++;
                smallOdd = Math.min(smallOdd, num);
            }
        }
        // System.out.println("smallOdd="+smallOdd);
        // System.out.println("smallEven="+smallEven);

        if (oddCount == 0 && evenCount > 0)
            return true;
        if (oddCount >= 1 && smallOdd < smallEven)
            return true;
        else
            return false;

    }
}