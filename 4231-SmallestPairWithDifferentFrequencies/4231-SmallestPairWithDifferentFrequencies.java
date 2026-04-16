// Last updated: 16/04/2026, 05:36:25
class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        Arrays.sort(nums);

        int[] res = new int[2];
        res[0] = nums[0];

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 1; i < nums.length; i++) {
            if (res[0] != nums[i] && freq.get(nums[i]) != freq.get(res[0])) {
                res[1] = nums[i];
                return res;
            }
        }

        return new int[] { -1, -1 };

    }
}