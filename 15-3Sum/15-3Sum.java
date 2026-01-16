// Last updated: 16/01/2026, 22:50:59
1class Solution {
2    public List<List<Integer>> threeSum(int[] arr) {
3        
4        int n=arr.length;
5        List<List<Integer>> res= new ArrayList<>();
6        
7        /* brute force approach Start*/
8        Set<List<Integer>> set= new HashSet<>();
9
10        for(int i=0;i<n;i++){
11            int x= arr[i];
12            HashSet<Integer> hs= new HashSet<>();
13            for(int j=i+1;j<n;j++){
14                int y=arr[j];
15
16                int z= -1 * (x+y);
17                if(hs.contains(z))
18                {
19                    if(x+y+z==0 ){
20                        List<Integer> ls= new ArrayList<>(Arrays.asList(x, y, z));
21                        Collections.sort(ls);
22                        if(!set.contains(ls))
23                        {
24                            res.add(ls);
25                            set.add(ls);
26                        }    
27                    }
28                }
29                hs.add(y);
30            }
31        }
32        /* brute force approach end*/
33
34        return res;
35    }
36}