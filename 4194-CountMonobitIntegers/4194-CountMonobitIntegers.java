// Last updated: 16/04/2026, 05:36:35
class Solution {
    public int countMonobit(int n) {
        int count = 1;
        int num = 1;

        while (num <= n) {
            count++;
            num = (num << 1) | 1;
        }
        return count;
    }
}