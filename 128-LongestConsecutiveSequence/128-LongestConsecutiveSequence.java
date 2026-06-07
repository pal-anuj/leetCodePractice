// Last updated: 07/06/2026, 10:42:12
1class Solution {
2    public List<Integer> majorityElement(int[] nums) {
3        int n = nums.length;
4        Map<Integer, Integer> freqCount = new HashMap<>();
5        for (int num : nums) {
6            freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
7        }
8
9        int maj = (int) Math.ceil((double) (n / 3));
10        // System.out.println(maj);
11        List<Integer> res = new ArrayList<>();
12        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
13            if (entry.getValue() > maj) {
14                // System.out.println("freq=>" + entry.getValue() + " , num= " + entry.getKey());
15                res.add(entry.getKey());
16            }
17        }
18
19        return res;
20    }
21}