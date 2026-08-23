// Last updated: 23/08/2026, 09:04:16
1class Solution {
2    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
3        Set<Integer> set= new HashSet<>();
4        for(int num : nums){
5            set.add(num);
6        }
7
8        List<List<Integer>> res= new ArrayList<>();    
9        for(int i=lower;i<=upper;i++){
10            if(set.contains(i))
11                continue;
12            else{
13                List<Integer> ls= new ArrayList<>();
14                ls.add(i);
15                while(i <= upper && !set.contains(i)){
16                    i++;                        
17                }
18                ls.add(i-1);
19                res.add(ls);
20            }
21        }
22        return res;
23    }
24}