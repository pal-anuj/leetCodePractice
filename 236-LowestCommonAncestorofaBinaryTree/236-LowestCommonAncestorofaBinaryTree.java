// Last updated: 27/03/2026, 00:24:40
1class Solution {
2    public int findDuplicate(int[] arr) {
3        /* 
4        //using extra space
5        HashSet<Integer> hs= new HashSet<>();
6        for(int i=0;i<arr.length;i++){
7            if(hs.contains(arr[i]))
8                return arr[i];
9            else
10                hs.add(arr[i]);
11        }
12        return 0;
13        */
14
15        // fast slow pointer similar to cycle linkedlist 0(n) with space 0(1)
16        int slow=arr[0];
17        int fast=arr[0];
18
19        do{
20            slow= arr[slow];
21            fast= arr[arr[fast]];
22        } while(slow != fast);
23
24        fast= arr[0];
25        while(slow != fast){
26            slow= arr[slow];
27            fast= arr[fast];
28        }
29        return slow;
30    }
31}