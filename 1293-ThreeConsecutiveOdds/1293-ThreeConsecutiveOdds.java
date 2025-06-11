// Last updated: 11/06/2025, 17:43:29
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int j : arr) {

            if (j % 2 != 0) {
                System.out.println(j % 2);
                count = count + 1;
                if (count == 3)
                    break;
            } else {
                count = 0;
            }

        }
        return count == 3;
    }
}