// Last updated: 04/02/2026, 10:28:32
1class Solution {
2    public int findTargetSumWays(int[] nums, int target) {
3
4        int n= nums.length;            
5        int sumOfArray=0;
6        int zeroCount = 0;
7
8        for(int i=0;i<n;i++){
9            sumOfArray= sumOfArray + nums[i];
10            if(nums[i]==0)
11                zeroCount++;
12        }
13
14        // REQUIRED VALIDATION
15        // 1 (target + sumOfArray) must be EVEN
16        // 2 |target| <= sumOfArray
17        if (Math.abs(target) > sumOfArray || (target + sumOfArray) % 2 != 0) {
18            return 0;
19        }
20
21        int sum= (target + sumOfArray)/2;
22        int res= countOfSubset(nums, sum);
23
24        // since 0 is neither +ve nor -ve so it can be count of not count,
25        // so to handle this scenario we need to multiply result by 2^zeroCount, 
26        System.out.println("res="+res);
27        System.out.println("zeroCount="+zeroCount);
28        return res;
29    }
30
31    private int countOfSubset(int[] arr, int sum){
32        int n= arr.length;
33        int[][] t= new int [n+1][sum+1];
34
35        for(int i=0;i<=n;i++){
36            for(int j=0;j<=sum;j++){
37                if(i==0)
38                    t[i][j]= 0;                    
39                if(j==0)
40                    t[i][j]= 1;
41            }
42        }
43
44        for(int i=1;i<=n;i++){
45            for(int j=0;j<=sum;j++){
46                if(arr[i-1] <= j)
47                    t[i][j]= t[i-1][j- arr[i-1]] + t[i-1][j];
48                else
49                    t[i][j]= t[i-1][j];
50            }
51        }
52 
53        return t[n][sum];
54    }
55}