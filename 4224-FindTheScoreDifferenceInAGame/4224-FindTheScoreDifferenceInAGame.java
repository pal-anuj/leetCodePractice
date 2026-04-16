// Last updated: 16/04/2026, 05:36:28
class Solution {
    public int scoreDifference(int[] nums) {
        int score1 = 0;
        int score2 = 0;

        boolean isPlayer1active = true;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0)
                isPlayer1active = !isPlayer1active;

            if ((i + 1) % 6 == 0)
                isPlayer1active = !isPlayer1active;

            if (isPlayer1active)
                score1 += nums[i];
            else
                score2 += nums[i];
        }
        return score1 - score2;
    }
}