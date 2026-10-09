// Last updated: 10/10/2026, 00:59:20
1class Solution {
2    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
3        int n= candies.length;
4        int maxCandies=0;
5        for(int i=0;i<n;i++){
6            if(candies[i]>maxCandies){
7                maxCandies= candies[i];
8            }
9        }
10
11        System.out.println(n);
12        List<Boolean> res= new ArrayList<>();
13        for(int num : candies){
14            if(num + extraCandies >= maxCandies){
15                res.add(true);
16            }
17            else{
18                res.add(false);
19            }
20        }
21        return res;
22    }
23}