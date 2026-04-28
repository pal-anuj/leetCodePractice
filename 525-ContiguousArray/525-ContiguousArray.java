// Last updated: 28/04/2026, 23:29:23
class Solution {
    public int findMaxLength(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0) {
                max = i + 1;
            }
            if (map.containsKey(sum)) {
                var pos = map.get(sum);
                int len = i - pos;
                if (len > max) {
                    max = len;
                }
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}