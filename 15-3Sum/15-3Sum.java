// Last updated: 21/12/2025, 13:41:57
1class Solution {
2    public List<List<Integer>> threeSum(int[] arr) {
3        
4        int n=arr.length;
5        List<List<Integer>> res= new ArrayList<>();
6        
7        /* 
8            most optimal approach Start, 
9            time- O(nlogn + n*n), space- O(numbr of unique triplets) 
10        */ 
11        Arrays.sort(arr);
12        for(int i=0;i<n;i++){
13            if(i>0 && arr[i] == arr[i-1]) continue;
14            int j=i+1;
15            int k=n-1;
16            while(j<k){
17                int sum= arr[i]+arr[j]+ arr[k];
18                if(sum < 0){
19                    j++;
20                }
21                else if(sum > 0){
22                    k--;                
23                }
24                else{
25                    List<Integer> ls= new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k]));
26                    res.add(ls);
27                    j++;
28                    k--;
29                    while(j<k && arr[j]== arr[j-1]) j++;
30                    while(j<k && arr[k]== arr[k+1]) k--;
31                }
32            }
33        }
34        /* Most optimal approach end  */ 
35
36
37        /* 
38            efficient approach Start 
39            time- O(n*n + logm ), space- O(n)+ O(numbr of unique triplets)  
40        */ 
41        // Set<List<Integer>> set= new HashSet<>();
42
43        // for(int i=0;i<n;i++){
44        //     int x= arr[i];
45        //     HashSet<Integer> hs= new HashSet<>();
46        //     for(int j=i+1;j<n;j++){
47        //         int y=arr[j];
48
49        //         int z= -1 * (x+y);
50        //         if(hs.contains(z))
51        //         {
52        //             if(x+y+z==0 ){
53        //                 List<Integer> ls= new ArrayList<>(Arrays.asList(x, y, z));
54        //                 Collections.sort(ls);
55        //                 if(!set.contains(ls))
56        //                 {
57        //                     res.add(ls);
58        //                     set.add(ls);
59        //                 }    
60        //             }
61        //         }
62        //         hs.add(y);
63        //     }
64        // }
65        /* efficient approach end*/
66
67        return res;
68    }
69}