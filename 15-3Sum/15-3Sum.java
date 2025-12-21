// Last updated: 21/12/2025, 12:39:04
1class Solution {
2    public List<List<Integer>> threeSum(int[] arr) {
3        
4        int n=arr.length;
5        List<List<Integer>> res= new ArrayList<>();
6        
7        /* brute force approach Start*/
8        Set<List<Integer>> set= new HashSet<>();
9        Map<Integer,Integer> map= new HashMap<>();
10        for(int i=0;i<n;i++){
11            map.put(arr[i],i);
12        }
13
14        for(int i=0;i<n;i++){
15            int x= arr[i];
16            for(int j=i+1;j<n;j++){
17                int y=arr[j];
18
19                int z= -1 * (x+y);
20                if(map.containsKey(z))
21                {
22                    int k=map.get(z);
23                    if(i!=j && j!=k && k!=i ){
24                        List<Integer> ls= new ArrayList<>(Arrays.asList(x, y, z));
25                        Collections.sort(ls);
26                        if(!set.contains(ls))
27                        {
28                            res.add(ls);
29                            set.add(ls);
30                        }    
31                    }
32                }
33            }
34        }
35        /* brute force approach end*/
36
37        return res;
38    }
39}