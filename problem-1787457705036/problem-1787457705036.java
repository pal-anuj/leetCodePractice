// Last updated: 23/08/2026, 09:31:45
1class Solution {
2    public int longestSubarray(int[] nums, int k) {
3
4        // prime -> how many numbers in current window contain this prime
5        Map<Integer, Integer> frequency = new HashMap<>();
6
7        int l = 0;
8        int maxLength = 0;
9        int distinctPrimes = 0;
10        for (int r = 0; r < nums.length; r++) {
11
12            // Get distinct prime factors of nums[right]
13            Set<Integer> factors = getPrimeFactors(nums[r]);
14
15            // Add factors of nums[right]
16            for (int prime : factors) {
17
18                if (!frequency.containsKey(prime)) {
19                    distinctPrimes++;
20                    frequency.put(prime, 1);
21                } else {
22                    frequency.put(prime, frequency.get(prime) + 1);
23                }
24            }
25
26            // Shrink window if we have more than k distinct primes
27            while (distinctPrimes > k) {
28                Set<Integer> leftFactors = getPrimeFactors(nums[l]);
29
30                for (int prime : leftFactors) {
31
32                    int count = frequency.get(prime) - 1;
33
34                    if (count == 0) {
35                        frequency.remove(prime);
36                        distinctPrimes--;
37                    } else {
38                        frequency.put(prime, count);
39                    }
40                }
41
42                l++;
43            }
44
45            // Current window is valid
46            maxLength = Math.max(maxLength, r - l + 1);
47
48        }
49
50        return maxLength;
51    }
52
53    private static Set<Integer> getPrimeFactors(int num) {
54        Set<Integer> set = new HashSet<>();
55        for (int i = 2; i * i <= num; i++) {
56            if (num % i == 0) {
57                set.add(i);
58                while (num % i == 0) {
59                    num /= i;
60                }
61            }
62        }
63
64        if (num > 1) {
65            set.add(num);
66        }
67        return set;
68    }
69}