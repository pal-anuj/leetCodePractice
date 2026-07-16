// Last updated: 17/07/2026, 00:11:18
1class Solution {
2public:
3    vector<int> twoSum(vector<int>& nums, int target) {
4
5        std::unordered_map<int,int> ValueToIndexMap;
6
7        for(int currentIndex=0;currentIndex < nums.size();currentIndex++)
8        {
9            int currentValue = nums[currentIndex];
10            int requiredValue = target - currentValue;
11
12            if(ValueToIndexMap.find(requiredValue) != ValueToIndexMap.end())
13            {
14                return {ValueToIndexMap[requiredValue],currentIndex};
15            }
16            ValueToIndexMap[currentValue] = currentIndex;
17        }
18        return {-1,-1};
19        
20    }
21};